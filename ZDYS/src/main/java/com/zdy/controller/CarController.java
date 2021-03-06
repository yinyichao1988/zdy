package com.zdy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zdy.entity.Car;
import com.zdy.entity.User;
import com.zdy.service.CarManager;
import com.zdy.utils.Page;


@Controller
@RequestMapping("/car")
public class CarController {

	@Resource(name = "carManager")
	private CarManager carManager;
	
	private final Integer pageSize = 10;
	
	@RequestMapping("/getAllCar")
	public String getAllCar(Integer page,String cph,HttpServletRequest request){
		if(page==null)page=1;
		Map<String, String> conditions = new HashMap<String, String>();
		conditions.put("cph", cph);
		Page<Car> pages = carManager.findPageCarByIntegrateds((--page)*pageSize, pageSize,conditions);
		pages.setTotalPage((int)Math.ceil((float)pages.getTotal()/(float)pageSize));
		request.setAttribute("pages", pages);
		request.setAttribute("page", ++page);
		request.setAttribute("cph", cph);
		return "car/carManager";
	}

	
	@RequestMapping("/delCar")
	public void delCar(String ids, HttpServletResponse response) {
		String message = "删除失败！";
		if(ids!=null){
			Integer upResult = carManager.updateCars(ids);
			if(upResult>0){
				message = "删除成功！";
			}
		}
		response.setContentType("text/plain; charset=utf-8");
		try {
			PrintWriter out = response.getWriter();
			out.write(message);
			out.flush();   
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	@RequestMapping("/toAddCar")
	public String toAddCar(HttpServletRequest request) {
		return "car/toaddcar";
	}

	@RequestMapping("/addCar")
	public void addCar(Car car,HttpServletResponse response,HttpSession httpSession) {
		String message = "添加成功！";
		if(car.getId()!=null){
			message = "修改成功！";
		}
		User user = (User) httpSession.getAttribute("user");
		car.setJybm(user.getBm());
		car.setJysfzh(user.getUsername());
		car.setJysj(user.getSj());
		car.setJyxm(user.getXm());
		car.setLrsj(new Date());
		carManager.saveCar(car);
		 response.setContentType("text/plain;charset=utf-8");
			try {
				PrintWriter out = response.getWriter();
				out.write(message);
				out.flush();   
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}


	@RequestMapping("/toUpdateCar")
	public String updateCar(Long id, HttpServletRequest request) {
		if(id!=null){
			request.setAttribute("zcar", carManager.findCarById(id));
		}
		return "car/toaddcar";
	}
	
}

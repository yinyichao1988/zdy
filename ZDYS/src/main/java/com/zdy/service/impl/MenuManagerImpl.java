package com.zdy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zdy.dao.MenuDao;
import com.zdy.entity.Menu;
import com.zdy.service.MenuManager;
@Service("menuManager")
public class MenuManagerImpl implements MenuManager {
	@Autowired
    @Qualifier("menuDao")
	private MenuDao menuDao;
	
	@Transactional(readOnly = true)
	public List<Menu> getMenuAll(Long userId) {
//		 List<Object[]> objectList = menuDao.getMenuAll(userId);
		 return menuDao.getMenuAll(userId);
	}

}

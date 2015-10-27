package com.zdy.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Service;

import com.zdy.dao.MenuDao;
import com.zdy.dao.base.BaseDAO;
import com.zdy.entity.Menu;
@Service("menuDao")
public class MenuDaoImpl  extends BaseDAO<Menu,Long> implements MenuDao{
	/**
	 * ����û�id��ѯ�û�
	 */
	public List<Menu> getMenuAll(Long userId) {
		String sql = "select r.id,r.name from z_menu r inner join z_role_resource rr on r.id = rr.resourceid inner join z_user_role u on u.roleid = rr.roleid and u.userid = ?";
//		Query query = getEntityManager().createNativeQuery(sql);
		Query query = (Query) getCurrentSession().createSQLQuery(sql).addEntity(Menu.class);
		query.setParameter(0, userId);
		@SuppressWarnings("unchecked")
		List<Menu> result = query.list();
		return result;
	}
}
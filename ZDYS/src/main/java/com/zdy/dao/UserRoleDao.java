package com.zdy.dao;

import com.zdy.entity.UserRole;

public interface UserRoleDao {

	public void saveUserRole(UserRole userRole);
	public void delUserRole(String userId);
}

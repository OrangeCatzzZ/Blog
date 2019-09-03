package cn.blog.service;

import cn.blog.entity.AdminUser;

public interface AdminUserService {
	
	/**
	 * 登陆方法
	 * @param userName
	 * @param password
	 * @return
	 */
	AdminUser login(String userName, String password);
	
}

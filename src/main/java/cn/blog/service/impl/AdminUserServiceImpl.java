package cn.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.blog.entity.AdminUser;
import cn.blog.mapper.AdminUserMapper;
import cn.blog.service.AdminUserService;
@Service
public class AdminUserServiceImpl implements AdminUserService {
	
	@Autowired	
	private AdminUserMapper adminUserMapper;
	
	@Override
	public AdminUser login(String userName, String password) {
		return adminUserMapper.login(userName, password);
	}

}

package com.oracle.service;

import com.oracle.dao.UserDao;
import com.oracle.daoImpl.UserDaoImpl;
import com.oracle.entity.User;

/**
 * 业务层 :
 *   作用是用来整合  DAO的数据的
 *   降低耦合
 *
 */
public class UserServiceImpl  {
	
	UserDao userDao = new UserDaoImpl();
	
	//验证当前的 用户是否可以注册
	public boolean register(User user){
		boolean result = false;
		//根据 注册的用户名 来查询 是否重名
		User us = userDao.getUserByName(user.getUserName());
		if(us == null) {
			//user == null ，说明数据库没这个人
			result = userDao.register(user);
		}
		return result;
	}
	
	//登录操作
	public User login(String userName,String password) {
		return userDao.selUser(userName, password);
	}
	
	//通过用户名去查询 用户是否存在
	public boolean getUserByName(String username) {
		User user = null;
		user = userDao.getUserByName(username);
		return user==null ? true:false;
	}
	
	public int editPassword(String password,int id) {
		return userDao.updUser(password, id);
	}
	
}

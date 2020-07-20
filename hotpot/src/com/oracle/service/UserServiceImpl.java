package com.oracle.service;

import com.oracle.dao.UserDao;
import com.oracle.daoImpl.UserDaoImpl;
import com.oracle.entity.User;

/**
 * ҵ��� :
 *   ��������������  DAO�����ݵ�
 *   �������
 *
 */
public class UserServiceImpl  {
	
	UserDao userDao = new UserDaoImpl();
	
	//��֤��ǰ�� �û��Ƿ����ע��
	public boolean register(User user){
		boolean result = false;
		//���� ע����û��� ����ѯ �Ƿ�����
		User us = userDao.getUserByName(user.getUserName());
		if(us == null) {
			//user == null ��˵�����ݿ�û�����
			result = userDao.register(user);
		}
		return result;
	}
	
	//��¼����
	public User login(String userName,String password) {
		return userDao.selUser(userName, password);
	}
	
	//ͨ���û���ȥ��ѯ �û��Ƿ����
	public boolean getUserByName(String username) {
		User user = null;
		user = userDao.getUserByName(username);
		return user==null ? true:false;
	}
	
	public int editPassword(String password,int id) {
		return userDao.updUser(password, id);
	}
	
}

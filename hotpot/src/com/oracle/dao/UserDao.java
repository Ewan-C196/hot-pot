package com.oracle.dao;

import com.oracle.entity.User;

public interface UserDao {

	// 登录操作 根据用户名和 密码 进行查询 //登录 修改信息
	public User selUser(String userName, String password);

	// 注册操作 需要插入用户的所有信息， 所以你的入参 是一个 实体 User
	public boolean register(User user);

	// 根据 用户查询 ，如果重名了 就不让你注册
	public User getUserByName(String name);

	// 根据 用户id
	// 去删除数据 增（insert ） 删（delete） 改（update） 查（select）
	// 设计思想 1.数组 2.集合 优化 从前往后 ---》新手 后往前（目标）
	public void delUserByIds(int[] ids);

	public int selMaxId();

	public int updUser(String password, int id);

}

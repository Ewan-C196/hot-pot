package com.oracle.dao;

import com.oracle.entity.User;

public interface UserDao {

	// ��¼���� �����û����� ���� ���в�ѯ //��¼ �޸���Ϣ
	public User selUser(String userName, String password);

	// ע����� ��Ҫ�����û���������Ϣ�� ���������� ��һ�� ʵ�� User
	public boolean register(User user);

	// ���� �û���ѯ ����������� �Ͳ�����ע��
	public User getUserByName(String name);

	// ���� �û�id
	// ȥɾ������ ����insert �� ɾ��delete�� �ģ�update�� �飨select��
	// ���˼�� 1.���� 2.���� �Ż� ��ǰ���� ---������ ����ǰ��Ŀ�꣩
	public void delUserByIds(int[] ids);

	public int selMaxId();

	public int updUser(String password, int id);

}

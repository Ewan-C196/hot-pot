package com.oracle.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.oracle.dao.UserDao;
import com.oracle.entity.User;
import com.oracle.tools.DBTools;

public class UserDaoImpl implements UserDao {

	@Override
	public User selUser(String uName, String uPassword) {
		User user = null; // ʵ����������
		String sql = "select * from tb_user where uName = ? and uPassword = ?";
		// sb.toString().replaceFirst("and", "")
		try {
			// �����ǰ���ϵĳ�����0 ������� ��˵�� û�� �����
			Connection conn = DBTools.getConn();
			// ��ȡԤ�������
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, uName);
			ps.setString(2, uPassword);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				// Ϊ�� ��ֹ�����¼�� Ϊ�� ��ʡ�ռ�
				user = new User();
				user.setId(rs.getInt("uId"));// ORMӳ��˼��� ���ݿ����ֶ� ���� javaʵ������Խ��� ӳ��
				user.setUserName(rs.getString("uName"));
				user.setPassword(rs.getString("uPassword"));
				user.setuNumber(rs.getString("uNumber"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		// ��� ��ǰ���ϵĳ��� > 0 , ����һ����
		return user;
	}

	@Override
	public boolean register(User user) {

		String sql = "insert into tb_user(uId,uName,uPassword,uNumber) values(DEFAULT,?,?,?);";
		int a = 0;
		try {

			Connection conn = DBTools.getConn();

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getuNumber());

			a = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		// a �� �������ݿ� ��Ӱ������ ������ 0 ��ȷ �� С�� ���� 0 ���ǲ���ʧ��
		return a > 0 ? true : false;
	}

	@Override
	public User getUserByName(String userName) {
		User user = null; // ʵ����������

		String sql = "select * from tb_user where uName = ?";
		try {
			// �����ǰ���ϵĳ�����0 ������� ��˵�� û�� �����
			Connection conn = DBTools.getConn();
			// ��ȡԤ�������
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, userName);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				// Ϊ�� ��ֹ�����¼�� Ϊ�� ��ʡ�ռ�
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUserName(rs.getString("uName"));
				user.setuNumber(rs.getString("uNumber"));
				user.setPassword(rs.getString("uPassword"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// ��� ��ǰ���ϵĳ��� > 0 , ����һ����
		return user;
	}

	@Override
	public void delUserByIds(int[] ids) {
		Connection conn = DBTools.getConn();
		PreparedStatement ps = null;
		String sql = "delete from tb_user where id in (";
		StringBuilder sb = new StringBuilder(sql);
		for (int i = 0; i < ids.length; i++) {
			sb.append("?,");
		}
		// DELETE from tb_user where id in(?,?,
		// delete from tb_user where id in (?,?
		// String ���ĸ�����λ�ÿ�ʼ��ȡ���Ӽ��� ����ƵĽǶ�
		String sql1 = sb.substring(0, (sb.length() - 1));// ��ȡ ��û�з���ֵ �� String ������û�� �м��� 2
		StringBuilder sb1 = new StringBuilder(sql1);
		sb1.append(")");
		try {
			ps = conn.prepareStatement(sb1.toString());
			for (int i = 0; i < ids.length; i++) {
				ps.setInt((i + 1), ids[i]);
			}
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBTools.close(null, ps, conn);
		}
	}

	@Override
	public int selMaxId() {
		String sql = "select max(uId) maxId from tb_user ";
		int i = 0;
		try {
			// �����ǰ���ϵĳ�����0 ������� ��˵�� û�� �����
			Connection conn = DBTools.getConn();
			// ��ȡԤ�������
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				// Ϊ�� ��ֹ�����¼�� Ϊ�� ��ʡ�ռ�
				i = rs.getInt("maxId");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// ��� ��ǰ���ϵĳ��� > 0 , ����һ����
		return i;
	}

	@Override
	public int updUser(String password, int id) {
		int i = 0;
		Connection conn = DBTools.getConn();
		PreparedStatement ps = null;
		String sql = "update tb_user set uPassword=? where uId=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, password);
			ps.setInt(2, id);
			i = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBTools.close(null, ps, conn);
		}
		return i;
	}
}
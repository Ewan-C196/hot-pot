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
		User user = null; // 实例化对象了
		String sql = "select * from tb_user where uName = ? and uPassword = ?";
		// sb.toString().replaceFirst("and", "")
		try {
			// 如果当前集合的长度是0 的情况下 ，说明 没有 这个人
			Connection conn = DBTools.getConn();
			// 获取预编译对象
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, uName);
			ps.setString(2, uPassword);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				// 为了 防止错误登录， 为了 节省空间
				user = new User();
				user.setId(rs.getInt("uId"));// ORM映射思想的 数据库表的字段 ，与 java实体的属性进行 映射
				user.setUserName(rs.getString("uName"));
				user.setPassword(rs.getString("uPassword"));
				user.setuNumber(rs.getString("uNumber"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 如果 当前集合的长度 > 0 , 至少一个人
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
		// a 是 返回数据库 受影响行数 ，大于 0 正确 ， 小于 等于 0 就是插入失败
		return a > 0 ? true : false;
	}

	@Override
	public User getUserByName(String userName) {
		User user = null; // 实例化对象了

		String sql = "select * from tb_user where uName = ?";
		try {
			// 如果当前集合的长度是0 的情况下 ，说明 没有 这个人
			Connection conn = DBTools.getConn();
			// 获取预编译对象
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, userName);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				// 为了 防止错误登录， 为了 节省空间
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUserName(rs.getString("uName"));
				user.setuNumber(rs.getString("uNumber"));
				user.setPassword(rs.getString("uPassword"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 如果 当前集合的长度 > 0 , 至少一个人
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
		// String 从哪个索引位置开始截取，接几个 从设计的角度
		String sql1 = sb.substring(0, (sb.length() - 1));// 截取 有没有返回值 有 String 参数有没有 有几个 2
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
			// 如果当前集合的长度是0 的情况下 ，说明 没有 这个人
			Connection conn = DBTools.getConn();
			// 获取预编译对象
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				// 为了 防止错误登录， 为了 节省空间
				i = rs.getInt("maxId");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 如果 当前集合的长度 > 0 , 至少一个人
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
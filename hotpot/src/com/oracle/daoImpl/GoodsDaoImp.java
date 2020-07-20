package com.oracle.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.oracle.dao.GoodsDao;
import com.oracle.entity.Goods;
import com.oracle.tools.DBTools;

public class GoodsDaoImp implements GoodsDao{

	@Override
	public Goods[] getGoods() {
		Goods Goods[] = new Goods[50];
		Goods G = null;
		int i = 0;
		String sql = "select * from tb_dishes";
		try {
			// 如果当前集合的长度是0 的情况下 ，说明 没有 这个人
			Connection conn = DBTools.getConn();
			// 获取预编译对象
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				// 为了 防止错误登录， 为了 节省空间
				G = new Goods();
				G.setId(rs.getInt("Id"));// ORM映射思想的 数据库表的字段 ，与 java实体的属性进行 映射
				G.setName(rs.getString("Name"));
				G.setPrice(rs.getDouble("Price"));
				G.setRecommendation(rs.getInt("Recommendation"));
				Goods[i] = G;
				i++;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Goods;
	}

}

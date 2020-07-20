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
			// �����ǰ���ϵĳ�����0 ������� ��˵�� û�� �����
			Connection conn = DBTools.getConn();
			// ��ȡԤ�������
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				// Ϊ�� ��ֹ�����¼�� Ϊ�� ��ʡ�ռ�
				G = new Goods();
				G.setId(rs.getInt("Id"));// ORMӳ��˼��� ���ݿ����ֶ� ���� javaʵ������Խ��� ӳ��
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

package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.beans.ProductBean;
import jp.co.aforce.tool.SQL;

public class SortDAO extends DAO {

	public List<ProductBean> alllow() throws Exception {

		List<ProductBean> list = new ArrayList<>();

		Connection con = getConnection();

		String sql = SQL.SQL_KK04_S06;
		PreparedStatement st = con.prepareStatement(sql);

		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			ProductBean p = new ProductBean();

			p.setProduct_num(rs.getInt("product_num"));
			p.setProduct_name(rs.getString("product_name"));
			p.setProduct_price(rs.getInt("product_price"));
			p.setDescription(rs.getString("description"));
			p.setProduct_gr(rs.getString("product_gr"));

			list.add(p);

		}

		st.close();
		con.close();

		return list;

	}

	public List<ProductBean> allhigh() throws Exception {
		List<ProductBean> list = new ArrayList<>();

		Connection con = getConnection();

		String sql = SQL.SQL_KK04_S07;
		PreparedStatement st = con.prepareStatement(sql);

		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			ProductBean p = new ProductBean();

			p.setProduct_num(rs.getInt("product_num"));
			p.setProduct_name(rs.getString("product_name"));
			p.setProduct_price(rs.getInt("product_price"));
			p.setDescription(rs.getString("description"));
			p.setProduct_gr(rs.getString("product_gr"));

			list.add(p);

		}

		st.close();
		con.close();

		return list;

	}

	public List<ProductBean> skinlow() throws Exception {

		List<ProductBean> list = new ArrayList<>();

		Connection con = getConnection();

		String sql = SQL.SQL_KK04_S08;
		PreparedStatement st = con.prepareStatement(sql);

		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			ProductBean p = new ProductBean();

			p.setProduct_num(rs.getInt("product_num"));
			p.setProduct_name(rs.getString("product_name"));
			p.setProduct_price(rs.getInt("product_price"));
			p.setDescription(rs.getString("description"));
			p.setProduct_gr(rs.getString("product_gr"));

			list.add(p);

		}

		st.close();
		con.close();

		return list;

	}

	public List<ProductBean> skinhigh() throws Exception {
		List<ProductBean> list = new ArrayList<>();

		Connection con = getConnection();

		String sql = SQL.SQL_KK04_S09;
		PreparedStatement st = con.prepareStatement(sql);

		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			ProductBean p = new ProductBean();

			p.setProduct_num(rs.getInt("product_num"));
			p.setProduct_name(rs.getString("product_name"));
			p.setProduct_price(rs.getInt("product_price"));
			p.setDescription(rs.getString("description"));
			p.setProduct_gr(rs.getString("product_gr"));

			list.add(p);

		}

		st.close();
		con.close();

		return list;

	}

	public List<ProductBean> makelow() throws Exception {

		List<ProductBean> list = new ArrayList<>();

		Connection con = getConnection();

		String sql = SQL.SQL_KK04_S10;
		PreparedStatement st = con.prepareStatement(sql);

		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			ProductBean p = new ProductBean();

			p.setProduct_num(rs.getInt("product_num"));
			p.setProduct_name(rs.getString("product_name"));
			p.setProduct_price(rs.getInt("product_price"));
			p.setDescription(rs.getString("description"));
			p.setProduct_gr(rs.getString("product_gr"));

			list.add(p);

		}

		st.close();
		con.close();

		return list;

	}

	public List<ProductBean> makehigh() throws Exception {
		List<ProductBean> list = new ArrayList<>();

		Connection con = getConnection();

		String sql = SQL.SQL_KK04_S11;
		PreparedStatement st = con.prepareStatement(sql);

		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			ProductBean p = new ProductBean();

			p.setProduct_num(rs.getInt("product_num"));
			p.setProduct_name(rs.getString("product_name"));
			p.setProduct_price(rs.getInt("product_price"));
			p.setDescription(rs.getString("description"));
			p.setProduct_gr(rs.getString("product_gr"));

			list.add(p);

		}

		st.close();
		con.close();

		return list;

	}

}

package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import jp.co.aforce.beans.ItemBean;
import jp.co.aforce.beans.ProductBean;
import jp.co.aforce.tool.SQL;

public class ProductDAO extends DAO {

	public List<ProductBean> all() throws Exception {
		List<ProductBean> list = new ArrayList<>();

		Connection con = getConnection();

		String sql = SQL.SQL_KK04_S01;
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

	public List<ProductBean> search(String keyword) throws Exception {
		List<ProductBean> list = new ArrayList<>();

		Connection con = getConnection();

		String sql = SQL.SQL_KK04_S02;
		PreparedStatement st = con.prepareStatement(sql);

		st.setString(1, "%" + keyword + "%");
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

	public List<ProductBean> skin() throws Exception {

		List<ProductBean> list = new ArrayList<>();

		Connection con = getConnection();

		String sql = SQL.SQL_KK04_S03;
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

	public List<ProductBean> make() throws Exception {

		List<ProductBean> list = new ArrayList<>();

		Connection con = getConnection();

		String sql = SQL.SQL_KK04_S05;
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

	public ProductBean detail(String product_num) throws Exception {
		//DBとの接続
		Connection con = getConnection();

		String sql = SQL.SQL_KK04_S04;
		PreparedStatement st = con.prepareStatement(sql);

		//SQLパラメータ設定
		st.setString(1, product_num);

		//SQLの実行
		ResultSet rs = st.executeQuery();

		ProductBean p = new ProductBean();

		while (rs.next()) {
			p.setProduct_num(rs.getInt("product_num"));
			p.setProduct_name(rs.getString("product_name"));
			p.setProduct_price(rs.getInt("product_price"));
			p.setDescription(rs.getString("description"));
			p.setProduct_gr(rs.getString("product_gr"));

		}

		st.close();
		con.close();

		return p;

	}

	public int exist(String product_num) throws Exception {

		int count = 0;

		try {
			Connection con = getConnection();

			String sql = SQL.SQL_KK05_S01;
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, product_num);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				count = rs.getInt("count(*)");
			}

			st.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;
	}

	public int insert(int product_numint,
			String product_name,
			int product_priceint,
			String description,
			String product_gr) throws Exception {

		int line = 0;

		try {

			Connection con = getConnection();

			String sql = SQL.SQL_KK05_I01;
			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, product_numint);
			st.setString(2, product_name);
			st.setInt(3, product_priceint);
			st.setString(4, description);
			st.setString(5, product_gr);

			line = st.executeUpdate();
			st.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return line;

	}

	public ProductBean upsearch(String product_num) throws Exception {

		Connection con = getConnection();
		ProductBean p = new ProductBean();

		String sql = SQL.SQL_KK05_S02;
		PreparedStatement st = con.prepareStatement(sql);

		st.setString(1, product_num);

		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			p.setProduct_num(rs.getInt("product_num"));
			p.setProduct_name(rs.getString("product_name"));
			p.setProduct_price(rs.getInt("product_price"));
			p.setDescription(rs.getString("description"));
			p.setProduct_gr(rs.getString("product_gr"));

		}

		st.close();
		con.close();

		return p;

	}

	public int update(
			int product_numint,
			String product_name,
			int product_priceint,
			String description,
			String product_gr) throws Exception {

		int line = 0;

		try {
			Connection con = getConnection();

			String sql = SQL.SQL_KK05_U01;
			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, product_numint);
			st.setString(2, product_name);
			st.setInt(3, product_priceint);
			st.setString(4, description);
			st.setString(5, product_gr);

			line = st.executeUpdate();
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return line;

	}

	public int delete(int product_numint) throws Exception {
		int line = 0;

		Connection con = getConnection();
		String sql = SQL.SQL_KK05_D01;
		PreparedStatement st = con
				.prepareStatement(sql);

		st.setInt(1, product_numint);
		line = st.executeUpdate();

		st.close();
		con.close();

		return line;
	}

	public boolean purchase(List<ItemBean> cart, String pay) throws Exception {

		Connection con = getConnection();
		con.setAutoCommit(false);

		for (ItemBean item : cart) {
			PreparedStatement st = con.prepareStatement(
					"insert into hist_info values(?, ?, ?)");

			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd/hh/mm");
			String pdate = df.format(calendar.getTime());

			//			// 現在日時を取得
			//			LocalDateTime date = LocalDateTime.now();
			//			// 表示形式を指定
			//			DateTimeFormatter dtformat =
			//					DateTimeFormatter.ofPattern("yyyy/MM/dd/HH:mm");
			//
			//			String fdate = dtformat.format(date);

			ProductBean product = item.getProductbean();
			st.setInt(1, product.getProduct_num());
			st.setString(2, pay);
			st.setString(3, pdate);
			int line = st.executeUpdate();
			st.close();

			if (line != 1) {
				con.rollback();
				con.setAutoCommit(true);
				st.close();
				return false;
			}
		}

		con.commit();
		con.setAutoCommit(true);
		con.close();
		return true;

	}

}

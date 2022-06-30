package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.beans.UserBean;
import jp.co.aforce.tool.SQL;

public class MemberDAO extends DAO {

	//会員情報存在チェック
	public int exist(String member_id) throws Exception {

		int count = 0;

		try {
			Connection con = getConnection();

			String sql = SQL.SQL_KK01_S01;
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, member_id);

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

	//データベースへデータを登録するメソッド
	//KK-01-01
	public int insert(
			String member_id,
			String last_name,
			String first_name,
			String mail_address,
			String phone_number,
			int birth_yearint,
			int birth_monthint,
			int birth_dayint,
			String postal_code,
			String prefectures,
			String address,
			String building,
			String password) throws Exception {

		int line = 0;

		try {

			Connection con = getConnection();

			String sql = SQL.SQL_KK01_I01;
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, member_id);
			st.setString(2, last_name);
			st.setString(3, first_name);
			st.setString(4, mail_address);
			st.setString(5, phone_number);
			st.setInt(6, birth_yearint);
			st.setInt(7, birth_monthint);
			st.setInt(8, birth_dayint);
			st.setString(9, postal_code);
			st.setString(10, prefectures);
			st.setString(11, address);
			st.setString(12, building);
			st.setString(13, password);
			line = st.executeUpdate();
			st.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return line;

	}

	public UserBean upsearch(String member_id) throws Exception {
		Connection con = getConnection();
		UserBean b = new UserBean();

		String sql = SQL.SQL_KK02_S01;
		PreparedStatement st = con.prepareStatement(sql);

		st.setString(1, member_id);

		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			b.setLast_name(rs.getString("last_name"));
			b.setFirst_name(rs.getString("first_name"));
			b.setMail_address(rs.getString("mail_address"));
			b.setPhone_number(rs.getString("phone_number"));
			b.setBirth_year(Integer.parseInt(rs.getString("birth_year")));
			b.setBirth_month(Integer.parseInt(rs.getString("birth_month")));
			b.setBirth_day(Integer.parseInt(rs.getString("birth_day")));
			b.setPostal_code(rs.getString("postal_code"));
			b.setPrefectures(rs.getString("prefectures"));
			b.setAddress(rs.getString("address"));
			b.setBuilding(rs.getString("building"));
			b.setPassword(rs.getString("password"));
		}

		st.close();
		con.close();

		return b;

	}

	public int update(
			String member_id,
			String last_name,
			String first_name,
			String mail_address,
			String phone_number,
			int birth_yearint,
			int birth_monthint,
			int birth_dayint,
			String postal_code,
			String prefectures,
			String address,
			String building,
			String password) throws Exception {

		int line = 0;

		try {

			Connection con = getConnection();

			String sql = SQL.SQL_KK02_U01;
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, last_name);
			st.setString(2, first_name);
			st.setString(3, mail_address);
			st.setString(4, phone_number);
			st.setInt(5, birth_yearint);
			st.setInt(6, birth_monthint);
			st.setInt(7, birth_dayint);
			st.setString(8, postal_code);
			st.setString(9, prefectures);
			st.setString(10, address);
			st.setString(11, building);
			st.setString(12, password);
			st.setString(13, member_id);
			line = st.executeUpdate();
			st.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return line;
	}

	public int delete(String member_id) throws Exception {
		int line = 0;

		Connection con = getConnection();
		String sql = SQL.SQL_KK02_D01;
		PreparedStatement st = con
				.prepareStatement(sql);

		st.setString(1, member_id);
		line = st.executeUpdate();

		st.close();
		con.close();

		return line;

	}

}
package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.beans.UserBean;
import jp.co.aforce.tool.SQL;

public class LoginDAO extends DAO {

	public UserBean search(String member_id, String password) throws Exception {

		//DBとの接続
		Connection con = getConnection();

		String sql = SQL.SQL_KK03_S01;
		PreparedStatement st = con.prepareStatement(sql);

		st.setString(1, member_id);
		st.setString(2, password);
		ResultSet rs = st.executeQuery();

		//初期化
		//参照型はnullを入れられる
		UserBean b = null;

		//入力したIDとパスワードが存在するならsにDB値を設定
		//ないなら空

		while (rs.next()) {
			//存在するならオブジェクトを入れる
			b = new UserBean();//空のオブジェクトが入っている状態
			b.setMember_id(rs.getString("member_id"));
			b.setPassword(rs.getString("password"));
		}

		st.close();
		con.close();

		return b;

	}
}
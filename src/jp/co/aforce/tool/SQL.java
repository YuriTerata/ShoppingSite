package jp.co.aforce.tool;

public class SQL {

	//入力された条件に一致する会員情報テーブルのデータ件数を取得する。
	public static final String SQL_KK01_S01 = "select count(*) from member_info where member_id = ?;";

	//入力された値を会員情報テーブルに登録する。
	public static final String SQL_KK01_I01 = "insert into member_info values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

	//idをもとに会員情報検索
	public static final String SQL_KK02_S01 = "select * from member_info where member_id = ?;";

	//会員情報更新
	public static final String SQL_KK02_U01 = "update member_info set last_name = ?, first_name = ?,"
			+ "mail_address = ?, phone_number = ?, birth_year = ?, birth_month = ?,"
			+ "birth_day = ?, postal_code = ?, prefectures = ?, address = ?,"
			+ "building = ?, password = ? where member_id = ?;";

	//ログイン
	public static final String SQL_KK03_S01 = "select * from member_info where member_id = ? and password = ?;";

	//商品一覧
	public static final String SQL_KK04_S01 = "select * from product_info;";

	//商品検索
	public static final String SQL_KK04_S02 = "select * from product_info where product_name like ?;";

	//スキンケア商品一覧
	public static final String SQL_KK04_S03 = "select * from product_info where product_gr like '洗顔' or product_gr like '化粧水';";

	//商品詳細
	public static final String SQL_KK04_S04 = "select * from product_info where product_num = ?;";

	//メイク商品一覧
	public static final String SQL_KK04_S05 = "select * from product_info where product_gr like '下地' or product_gr like 'ファンデーション';";

	//全ての安い順
	public static final String SQL_KK04_S06 = "select * from product_info order by product_price asc;";

	//全ての高い順
	public static final String SQL_KK04_S07 = "select * from product_info order by product_price desc;";

	//スキンケア安い順
	public static final String SQL_KK04_S08 = "select * from product_info where product_gr like '洗顔' or product_gr like '化粧水' order by product_price asc;";

	//スキンケア高い順
	public static final String SQL_KK04_S09 = "select * from product_info where product_gr like '洗顔' or product_gr like '化粧水' order by product_price desc;";

	//メイク安い順
	public static final String SQL_KK04_S10 = "select * from product_info where product_gr like '下地' or product_gr like 'ファンデーション' order by product_price asc;";

	//メイク高い順
	public static final String SQL_KK04_S11 = "select * from product_info where product_gr like '下地' or product_gr like 'ファンデーション' order by product_price desc;";

	//商品登録
	public static final String SQL_KK05_I01 = "insert into product_info values(?, ?, ?, ?, ?);";

	//商品存在確認
	public static final String SQL_KK05_S01 = "select * from product_info where product_num = ?;";

	//番号をもとに商品情報検索
	public static final String SQL_KK05_S02 = "select * from product_info where product_num = ?;";

	//商品情報更新
	public static final String SQL_KK05_U01 = "update product_info set product_name = ?,description = ?, product_price = ?, product_gr = ? where product_num=?;";

	//商品情報削除
	public static final String SQL_KK05_D01 = "delete from product_info where product_num=?";

	public static final String SQL_KK02_D01 = "delete from member_info where member_id=?";

}

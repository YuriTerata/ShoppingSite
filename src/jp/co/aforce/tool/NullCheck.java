package jp.co.aforce.tool;

public class NullCheck {
	public static String getString(
			String member_id,
			String last_name,
			String first_name,
			String mail_address,
			String phone_number,
			String birth_year,
			String birth_month,
			String birth_day,
			String postal_code,
			String prefectures,
			String address,
			String building,
			String password) throws Exception {

		if (member_id.equals("")) {
			return "ID";
		}

		if (last_name.equals("")) {
			return "姓";
		}

		if (first_name.equals("")) {
			return "名";
		}

		if (mail_address.equals("")) {
			return "メールアドレス";
		}

		if (phone_number.equals("")) {
			return "電話番号";
		}

		if (birth_year.equals("")) {
			return "誕生年";
		}

		if (birth_month.equals("")) {
			return "誕生月";
		}

		if (birth_day.equals("")) {
			return "誕生日";
		}

		if (postal_code.equals("")) {
			return "郵便番号";
		}

		if (prefectures.equals("")) {
			return "都道府県";
		}

		if (address.equals("")) {
			return "市区町村・番地";
		}

		if (building.equals("")) {
			return "";
		}

		if (password.equals("")) {
			return "パスワード";
		}
		return "";
	}

	public static String getProduct(

			String product_num,
			String product_name,
			String product_price,
			String description,
			String product_gr

	) throws Exception {

		if (product_num.equals("")) {
			return "商品番号";
		}

		if (product_name.equals("")) {
			return "商品名";
		}

		if (product_price.equals("")) {
			return "商品価格";
		}

		if (description.equals("")) {
			return "商品説明";
		}

		if (product_gr.equals("")) {
			return "商品グループ";
		}

		return "";
	}

}

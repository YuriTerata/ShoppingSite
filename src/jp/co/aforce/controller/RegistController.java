package jp.co.aforce.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.dao.MemberDAO;
import jp.co.aforce.tool.Message;
import jp.co.aforce.tool.NullCheck;

@WebServlet("/RegistController")
public class RegistController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/views/top.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String page = request.getParameter("menu");

		try {
			if (page.equals("登録")) {

				MemberDAO dao = new MemberDAO();

				String member_id = request.getParameter("member_id");
				String last_name = request.getParameter("last_name");
				String first_name = request.getParameter("first_name");
				String mail_address = request.getParameter("mail_address");
				String phone_number = request.getParameter("phone_number");
				String birth_year = request.getParameter("birth_year");
				String birth_month = request.getParameter("birth_month");
				String birth_day = request.getParameter("birth_day");
				String postal_code = request.getParameter("postal_code");
				String prefectures = request.getParameter("prefectures");
				String address = request.getParameter("address");
				String building = request.getParameter("building");
				String password = request.getParameter("password");
				String str = "";

				try {
					str = NullCheck.getString(member_id,last_name, first_name, mail_address, phone_number,
							birth_year, birth_month, birth_day, postal_code, prefectures,
							address, building, password);
				} catch (Exception e1) {
					e1.printStackTrace();
				}

				if (!str.equals("")) {
					request.setAttribute("error", str + Message.W_CCM0001);
					request.setAttribute("last_name", last_name);
					request.getRequestDispatcher("/views/regist.jsp")
							.forward(request, response);
				} else {

					try {
						int birth_yearint = Integer.parseInt(birth_year);
						int birth_monthint = Integer.parseInt(birth_month);
						int birth_dayint = Integer.parseInt(birth_day);

						int count = dao.exist(member_id);
						if (count != 0) {
							//重複
							request.setAttribute("error", Message.E_WKK0001);
							request.getRequestDispatcher("/views/regist.jsp")
									.forward(request, response);

						} else {
							int line = dao.insert(member_id, last_name, first_name, mail_address, phone_number,
									birth_yearint, birth_monthint, birth_dayint, postal_code, prefectures,
									address, building, password);

							if (line != 0) {
								//登録成功
								request.setAttribute("success", Message.I_WKK0001);
								request.getRequestDispatcher("/views/regist.jsp")
										.forward(request, response);

							} else {
								request.setAttribute("last_name", last_name);
								request.setAttribute("error", Message.E_WKK0002);
								request.getRequestDispatcher("/views/regist.jsp")
										.forward(request, response);
							}
						}
					} catch (Exception e) {
						request.setAttribute("last_name", last_name);
						request.setAttribute("firsr_name",first_name);
						request.setAttribute("mail_address",mail_address);

						request.setAttribute("error", Message.E_WKK0002);
						request.getRequestDispatcher("/views/regist.jsp")
								.forward(request, response);
						e.printStackTrace();
					}

				}
			} else if (page.equals("戻る")) {
				request.getRequestDispatcher("/views/login.jsp").forward(request, response);

			}
		} catch (Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("/views/login.jsp").forward(request, response);
		}
	}
}

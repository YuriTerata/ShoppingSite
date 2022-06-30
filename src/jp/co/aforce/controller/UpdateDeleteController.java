package jp.co.aforce.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.UserBean;
import jp.co.aforce.dao.MemberDAO;
import jp.co.aforce.tool.Message;
import jp.co.aforce.tool.NullCheck;

@WebServlet("/UpdateDeleteController")
public class UpdateDeleteController extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/views/top.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String page = request.getParameter("menu");

		HttpSession session = request.getSession();
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

		//検索ボタン押下時
		if (page.equals("検索")) {

			try {
				UserBean b = dao.upsearch(member_id);

				if (b != null) {
					//成功

					session.setAttribute("member_id", member_id);
					request.setAttribute("bean", b);

					String se = request.getParameter("se");

					if (se.equals("削除")) {

						request.getRequestDispatcher("/views/delete.jsp").forward(request, response);
					} else if (se.equals("更新")) {
						request.getRequestDispatcher("/views/update.jsp").forward(request, response);

					}

				} else {
					//失敗
					request.setAttribute("msg", Message.E_WKK0005);
					request.getRequestDispatcher("/views/login.jsp").forward(request, response);
				}

			} catch (Exception e) {

				e.printStackTrace();
				request.setAttribute("msg", Message.E_WKK0000);
				request.getRequestDispatcher("views/update.jsp").forward(request, response);
			}

			//戻るボタン押下時
		} else if (page.equals("戻る")) {

			request.getRequestDispatcher("/views/logout.jsp").forward(request, response);

			//更新ボタン押下時
		} else if (page.equals("更新")) {

			try {
				str = NullCheck.getString(member_id, last_name, first_name, mail_address, phone_number,
						birth_year, birth_month, birth_day, postal_code, prefectures,
						address, building, password);
			} catch (Exception e1) {
				request.setAttribute("msg", Message.E_WKK0000);
				e1.printStackTrace();
			}

			if (!str.equals("")) {
				request.setAttribute("msg", str + Message.W_CCM0001);
				request.getRequestDispatcher("/views/update.jsp")
						.forward(request, response);
			} else {

				try {

					try {
						int birth_yearint = Integer.parseInt(birth_year);
						int birth_monthint = Integer.parseInt(birth_month);
						int birth_dayint = Integer.parseInt(birth_day);

						int line = dao.update(member_id, last_name, first_name, mail_address,
								phone_number, birth_yearint, birth_monthint, birth_dayint, postal_code, prefectures,
								address, building, password);

						if (line != 0) {
							//登録成功
							request.setAttribute("msg", Message.U_WKK0001);
							request.getRequestDispatcher("/views/update.jsp")
									.forward(request, response);

						} else {
							request.setAttribute("last_name", last_name);
							request.setAttribute("msg", Message.E_WKK0003);
							request.getRequestDispatcher("/views/update.jsp").forward(request, response);
						}
					}

					catch (Exception e) {
						e.printStackTrace();
						request.setAttribute("msg", Message.E_WKK0000);
						request.getRequestDispatcher("/views/update.jsp").forward(request, response);
					}

				} catch (Exception e) {
					request.setAttribute("msg", Message.E_WKK0000);
					request.getRequestDispatcher("/views/update.jsp")
							.forward(request, response);
					e.printStackTrace();
				}

			}
		} else if (page.equals("削除")) {

			try {

				try {
					int line = dao.delete(member_id);

					if (line != 0) {
						//登録成功
						request.setAttribute("msg", Message.D_WKK0001);
						request.getRequestDispatcher("/views/delete.jsp")
								.forward(request, response);

					} else {
						request.setAttribute("last_name", last_name);
						request.setAttribute("msg", Message.E_WKK0003);
						request.getRequestDispatcher("/views/delete.jsp").forward(request, response);
					}
				}

				catch (Exception e) {
					e.printStackTrace();
					request.setAttribute("msg", Message.E_WKK0000);
					request.getRequestDispatcher("/views/update.jsp").forward(request, response);
				}

			} catch (Exception e) {
				request.setAttribute("msg", Message.E_WKK0000);
				request.getRequestDispatcher("/views/update.jsp")
						.forward(request, response);
				e.printStackTrace();
			}

		}

	}
}

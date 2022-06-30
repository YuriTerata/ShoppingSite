package jp.co.aforce.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.UserBean;
import jp.co.aforce.dao.LoginDAO;
import jp.co.aforce.tool.Message;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/views/top.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String page = request.getParameter("menu");

		//入力値取得
		String member_id = request.getParameter("member_id");
		String password = request.getParameter("password");

		try {
			if (page.equals("ログイン")) {

				LoginDAO dao = new LoginDAO();
				UserBean b = dao.search(member_id, password);

				if (b != null) {
					HttpSession session = request.getSession();

					//管理者遷移
					if (member_id.contains("kaizer") && password.contains("kaizer")) {
						session.setAttribute("member_id", member_id);
						session.setAttribute("admin", "管理者");
						request.getRequestDispatcher("/views/admininsert.jsp").forward(request, response);

					} else {
						//ログイン成功
						session.setAttribute("member_id", member_id);
						request.getRequestDispatcher("/views/logout.jsp").forward(request, response);
					}
				} else {
					//ログイン失敗
					request.setAttribute("msg", Message.E_WKK0004);
					request.getRequestDispatcher("/views/login.jsp").forward(request, response);
				}

			} else if (page.contains("会員登録")) {

				request.getRequestDispatcher("/views/regist.jsp").forward(request, response);
			}

			else if (page.contains("購入履歴")) {

				request.getRequestDispatcher("/views/success.jsp").forward(request, response);
			}

			else if (page.contains("更新")) {

				request.getRequestDispatcher("/views/update.jsp").forward(request, response);
			}

			else if (page.contains("ログアウト")) {

				HttpSession session = request.getSession();
				session.invalidate();
				request.getRequestDispatcher("/views/top.jsp").forward(request, response);
			} else if (page.contains("削除")) {

				request.getRequestDispatcher("/views/delete.jsp").forward(request, response);
			}

		} catch (

		Exception e) {

			e.printStackTrace();
			request.setAttribute("msg", Message.E_WKK0000);
			request.getRequestDispatcher("views/login.jsp").forward(request, response);
		}
	}
}
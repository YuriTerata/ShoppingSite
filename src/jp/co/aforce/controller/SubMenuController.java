package jp.co.aforce.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SubMenuController")
public class SubMenuController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/views/top.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String page = request.getParameter("submenu");

		try {
			if (page.equals("account")) {

				HttpSession session = request.getSession();

				if (session.getAttribute("member_id") != null) {

					request.getRequestDispatcher("/views/logout.jsp").forward(request, response);
				} else {
					request.getRequestDispatcher("/views/login.jsp").forward(request, response);
				}

			} else if (page.equals("cart")) {
				request.getRequestDispatcher("/views/cart.jsp").forward(request, response);

			} else if (page.equals("search")) {
				request.getRequestDispatcher("/SearchController").forward(request, response);

			} else if (page.equals("商品入れ替え")) {
				request.getRequestDispatcher("/views/admininsert.jsp").forward(request, response);

			} else {
				//遷移失敗
				request.setAttribute("miss", "miss");
				request.getRequestDispatcher("/views/top.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("/views/top.jsp").forward(request, response);
		}
	}

}

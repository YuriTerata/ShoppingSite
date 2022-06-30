package jp.co.aforce.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PurchaseController")
public class PurchaseController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/views/top.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String page = request.getParameter("menu");

		try {

			if (page.equals("戻る")) {
				request.getRequestDispatcher("/view/cart.jsp").forward(request, response);
			} else if (page.equals("購入")) {
				try {

					request.getRequestDispatcher("/views/success.jsp").forward(request, response);

				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		} catch (

		Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("/views/top.jsp").forward(request, response);
		}

	}
}
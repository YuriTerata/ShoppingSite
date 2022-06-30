package jp.co.aforce.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.tool.Message;

@WebServlet("/AdminController")
public class AdminController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/views/top.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String page = request.getParameter("admin");

		try {
			if (page.equals("商品登録")) {

				request.getRequestDispatcher("/views/admininsert.jsp").forward(request, response);

			} else if (page.equals("商品更新")) {

				request.getRequestDispatcher("/views/adminupdate.jsp").forward(request, response);

			} else if (page.equals("商品削除")) {

				request.getRequestDispatcher("/views/admindelete.jsp").forward(request, response);

			}

		} catch (

		Exception e) {

			e.printStackTrace();
			request.setAttribute("error", Message.E_WKK0000);
			request.getRequestDispatcher("views/admininsert.jsp").forward(request, response);
		}
	}

}

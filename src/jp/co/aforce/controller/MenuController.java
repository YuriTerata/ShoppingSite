package jp.co.aforce.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MenuController")
public class MenuController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/views/top.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String page = request.getParameter("menu");

		try {
			if (page.equals("TOP PAGE")) {
				request.getRequestDispatcher("/views/top.jsp").forward(request, response);
			} else if (page.equals("SKIN CARE")) {
				request.getRequestDispatcher("/SkincareController").forward(request, response);
			} else if (page.equals("MAKE UP")) {
				request.getRequestDispatcher("/MakeupController").forward(request, response);
			} else if (page.equals("ALL ITEM")) {
				request.getRequestDispatcher("/AllProductController").forward(request, response);
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

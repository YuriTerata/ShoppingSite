package jp.co.aforce.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.ProductBean;
import jp.co.aforce.dao.ProductDAO;

@WebServlet("/SearchController")
public class SearchController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/views/top.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset = UTF-8");

		String keyword = request.getParameter("keyword");
		if (keyword == null)
			keyword = "";

		ProductDAO dao = new ProductDAO();

		try {
			List<ProductBean> list = dao.search(keyword);

			if (list.isEmpty()) {
				request.setAttribute("title", "検索結果");
				request.setAttribute("result", "0件");
				request.getRequestDispatcher("/views/allproduct.jsp").forward(request, response);

			} else {
				request.setAttribute("title", "検索結果");
				request.setAttribute("a", keyword);
				request.setAttribute("list", list);
				request.getRequestDispatcher("/views/allproduct.jsp").forward(request, response);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

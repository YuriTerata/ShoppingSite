package jp.co.aforce.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.ProductBean;
import jp.co.aforce.dao.ProductDAO;

@WebServlet("/AllProductController")
public class AllProductController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/views/top.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset = UTF-8");

		ProductDAO dao = new ProductDAO();
		HttpSession session = request.getSession();

		try {
			List<ProductBean> list = dao.all();
			request.setAttribute("title", "商品一覧");
			session.setAttribute("list", list);

			request.getRequestDispatcher("/views/allproduct.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

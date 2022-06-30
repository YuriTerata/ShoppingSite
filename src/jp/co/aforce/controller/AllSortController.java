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
import jp.co.aforce.dao.SortDAO;

@WebServlet("/AllSortController")
public class AllSortController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/views/top.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String sort = request.getParameter("sort");

		SortDAO dao = new SortDAO();
		HttpSession session = request.getSession();

		try {

			if (sort.equals("安い順")) {

				try {
					List<ProductBean> list = dao.alllow();
					request.setAttribute("title", "商品一覧");
					session.setAttribute("list", list);

					request.getRequestDispatcher("/views/allproduct.jsp").forward(request, response);

				} catch (Exception e) {
					e.printStackTrace();
				}

			} else if (sort.equals("高い順")) {

				try {
					List<ProductBean> list = dao.allhigh();
					request.setAttribute("title", "商品一覧");
					session.setAttribute("list", list);

					request.getRequestDispatcher("/views/allproduct.jsp").forward(request, response);

				} catch (Exception e) {
					e.printStackTrace();
				}

			} else if (sort.equals("")) {

				request.getRequestDispatcher("/AllProductController").forward(request, response);

			}

		} catch (Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("/views/login.jsp").forward(request, response);
		}
	}
}

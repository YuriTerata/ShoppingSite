package jp.co.aforce.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.ItemBean;
import jp.co.aforce.beans.ProductBean;

@WebServlet("/CartController")
public class CartController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/views/top.jsp").forward(request, response);

	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String page = request.getParameter("cart");

		HttpSession session = request.getSession();
		int total = 0;

		try {

			if (page.equals("戻る")) {
				request.getRequestDispatcher("CartController").forward(request, response);
			}

			else if (page.equals("カート")) {

				HttpSession session1 = request.getSession();

				if (session1.getAttribute("member_id") != null) {

					int product_num = Integer.parseInt(request.getParameter("product_num"));
					List<ItemBean> cart = (List<ItemBean>) session1.getAttribute("cart");

					if (cart == null) {
						cart = new ArrayList<ItemBean>();
						session1.setAttribute("cart", cart);
					}

					boolean existItem = true;
					for (ItemBean b : cart) {
						if (b.getProductbean().getProduct_num() == (product_num)) {
							b.setCount(b.getCount() + 1);
							existItem = false;
						}

						total = total + b.getProductbean().getProduct_price() * b.getCount();
						b.setTotal(b.getTotal());

					}

					session.setAttribute("total", total);

					if (existItem) {

						List<ProductBean> list = (List<ProductBean>) session1.getAttribute("list");

						for (ProductBean ProductBean : list) {
							if (ProductBean.getProduct_num() == (product_num)) {

								ItemBean b = new ItemBean();
								b.setProductbean(ProductBean);
								b.setCount(1);
								cart.add(b);
								total = total + ProductBean.getProduct_price();
							}

						}

					}
					session.setAttribute("total", total);
					request.getRequestDispatcher("/views/cart.jsp").forward(request, response);

				} else {
					request.getRequestDispatcher("/views/login.jsp").forward(request, response);
				}
			}

			else if (page.equals("削除")) {
				int product_num = Integer.parseInt(request.getParameter("product_num"));

				List<ItemBean> cart = (List<ItemBean>) session.getAttribute("cart");

				for (ItemBean b : cart) {

					if (b.getProductbean().getProduct_num() == product_num) {
						cart.remove(b);

						break;
					} else {
						total = total + b.getProductbean().getProduct_price() * b.getCount();
						b.setTotal(b.getTotal());

					}
				}
				session.setAttribute("total", total);
				request.getRequestDispatcher("/views/cart.jsp").forward(request, response);

			} else if (page.equals("購入")) {

				List<ItemBean> cart = (List<ItemBean>) session.getAttribute("cart");
				if (cart == null || cart.size() == 0) {

					request.getRequestDispatcher("/views/cart.jsp").forward(request, response);
				} else {
					request.getRequestDispatcher("/views/userinfo.jsp").forward(request, response);
				}
			} else if (page.equals("カートから購入した商品を削除")) {

				session.removeAttribute("cart");
				session.removeAttribute("total");
				request.getRequestDispatcher("/views/top.jsp").forward(request, response);

			}

		} catch (

		Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("/views/login.jsp").forward(request, response);
		}
	}

}

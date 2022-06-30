package jp.co.aforce.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.ProductBean;
import jp.co.aforce.dao.ProductDAO;
import jp.co.aforce.tool.Message;
import jp.co.aforce.tool.NullCheck;

@WebServlet("/AdminProductController")
public class AdminProductController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/views/top.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String page = request.getParameter("form");

		try {
			String product_num = request.getParameter("product_num");
			String product_name = request.getParameter("product_name");
			String product_price = request.getParameter("product_price");
			String description = request.getParameter("description");
			String product_gr = request.getParameter("product_gr");
			String str = "";

			HttpSession session = request.getSession();
			ProductDAO dao = new ProductDAO();

			if (page.equals("登録")) {

				try {
					str = NullCheck.getProduct(product_num, product_name, product_price, description, product_gr);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				if (!str.equals("")) {
					request.setAttribute("msg", str + Message.W_CCM0001);
					request.getRequestDispatcher("/views/admininsert.jsp")
							.forward(request, response);
				} else {
					try {
						int product_numint = Integer.parseInt(product_num);
						int product_priceint = Integer.parseInt(product_price);

						int count = dao.exist(product_num);
						if (count != 0) {
							//重複
							request.setAttribute("msg", Message.E_WKK0000);
							request.getRequestDispatcher("/views/admininsert.jsp")
									.forward(request, response);

						} else {
							int line = dao.insert(product_numint, product_name, product_priceint, description, product_gr);

							if (line != 0) {
								//登録成功
								request.setAttribute("msg", Message.I_WKK0002);
								request.getRequestDispatcher("/views/admininsert.jsp")
										.forward(request, response);

							} else {

								request.setAttribute("msg", Message.E_WKK0002);
								request.getRequestDispatcher("/views/admininsert.jsp")
										.forward(request, response);
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
						request.setAttribute("msg", Message.E_WKK0000);
						request.getRequestDispatcher("/views/admininsert.jsp")
								.forward(request, response);

					}

				}
			} else if (page.equals("検索")) {

				try {
					ProductBean b = dao.upsearch(product_num);

					if (b != null) {
						//成功

						session.setAttribute("product_num", product_num);
						request.setAttribute("b", b);
						String se = request.getParameter("se");

						if (se.equals("削除")) {

							request.getRequestDispatcher("/views/admindelete.jsp").forward(request, response);
						} else if (se.equals("更新")) {
							request.getRequestDispatcher("/views/adminupdate.jsp").forward(request, response);

						}
					} else {
						//失敗
						request.setAttribute("msg", Message.E_WKK0005);
						request.getRequestDispatcher("/views/adminupdate.jsp").forward(request, response);
					}

				} catch (Exception e) {

					e.printStackTrace();
					request.setAttribute("msg", Message.E_WKK0000);
					request.getRequestDispatcher("views/adminupdate.jsp").forward(request, response);
				}

			} else if (page.equals("更新")) {
				try {
					str = NullCheck.getProduct(product_num, product_name, product_price, description, product_gr);
				} catch (Exception e1) {
					request.setAttribute("msg", Message.E_WKK0000);
					e1.printStackTrace();
				}
				if (!str.equals("")) {
					request.setAttribute("msg", str + Message.W_CCM0001);
					request.getRequestDispatcher("/views/adminupdate.jsp")
							.forward(request, response);
				} else {

					try {

						int product_numint = Integer.parseInt(product_num);
						int product_priceint = Integer.parseInt(product_price);

						int line = dao.update(product_numint, product_name, product_priceint, description, product_gr);

						if (line != 0) {
							//登録成功
							request.setAttribute("msg", Message.U_WKK0001);
							request.getRequestDispatcher("/views/adminupdate.jsp")
									.forward(request, response);

						} else {

							request.getRequestDispatcher("/views/adminupdate.jsp").forward(request, response);
						}
					}

					catch (Exception e) {

						request.getRequestDispatcher("/views/adminupdate.jsp").forward(request, response);
					}

				}
			}

			else if (page.equals("戻る")) {

				request.getRequestDispatcher("/views/logout.jsp").forward(request, response);

			} else if (page.equals("削除")) {
				try {

					int product_numint = Integer.parseInt(product_num);

					int line = dao.delete(product_numint);

					if (line != 0) {
						//登録成功
						request.setAttribute("msg", Message.D_WKK0001);
						request.getRequestDispatcher("/views/admindelete.jsp")
								.forward(request, response);

					} else {

					}
				}

				catch (Exception e) {

					request.getRequestDispatcher("/views/adminupdate.jsp").forward(request, response);
				}

				request.getRequestDispatcher("/views/logout.jsp").forward(request, response);

			}
		} catch (Exception e) {
			request.setAttribute("msg", Message.E_WKK0000);
			request.getRequestDispatcher("/views/adminupdate.jsp")
					.forward(request, response);
			e.printStackTrace();
		}

	}
}

package me.lqlu.shoppingcart.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.lqlu.shoppingcart.dao.GoodsDao;
import me.lqlu.shoppingcart.model.Cart;
import me.lqlu.shoppingcart.model.Goods;

/**
 * Servlet implementation class Delete
 */
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GoodsDao goodsDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Delete() {
		goodsDao = GoodsDao.getInstance();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		}

		String id = request.getParameter("id");
		Goods g = goodsDao.findById(id);
		cart.delete(g);
		response.sendRedirect(request.getContextPath() + "/ShoppingCart");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

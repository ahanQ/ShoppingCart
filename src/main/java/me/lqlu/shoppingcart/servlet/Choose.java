package me.lqlu.shoppingcart.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.lqlu.shoppingcart.dao.GoodsDao;
import me.lqlu.shoppingcart.model.Goods;

/**
 * Servlet implementation class Choose
 */
public class Choose extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private GoodsDao goodsDao;
	
    /**
     * Default constructor. 
     */
    public Choose() {
    		goodsDao = GoodsDao.getInstance();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		List<Goods> goods = goodsDao.findAllGoods();
		request.setAttribute("goods", goods);
		request.getRequestDispatcher("Choose.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

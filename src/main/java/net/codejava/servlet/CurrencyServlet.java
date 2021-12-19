package net.codejava.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.codejava.dao.CurrencyListDAO;
import net.codejava.model.Currency;

/**
 * Servlet implementation class CurrencyServlet
 */
@WebServlet("/currencyServlet")
public class CurrencyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CurrencyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		  try {
				 List<Currency> exchangeRateInfo = CurrencyListDAO.getExchangeRateInfo();
				 request.setAttribute("ExchangeRateInfo", exchangeRateInfo); 
				
				
				 List<Currency> CurrencyList = CurrencyListDAO.getCurrencyList();
				 request.setAttribute("CurrencyList", CurrencyList); 
				 
			     PrintWriter out= response.getWriter(); 
			      out.println("<B><BR>User:" + request.getParameter("cname"));
			      out.println
			          (", Currency:" + request.getAttribute("cname") + "</B>");
			     // this.getServletContext().getRequestDispatcher("/jsp/welcome.jsp"). include(request, response);
			      
			      String nextJSP = "/index.jsp";
			      RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
			      dispatcher.forward(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

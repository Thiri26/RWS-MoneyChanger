package net.codejava.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.codejava.dao.CurrencyListDAO;
/**
 * Servlet implementation class MoneyChangerServlet
 */
@WebServlet("/moneyChangerServlet")
public class MoneyChangerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MoneyChangerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String yourName = request.getParameter("yourName");
		PrintWriter writer = response.getWriter();
		writer.println("<h1>Hello " + yourName + "</h1>");
		writer.close();
	}

	 public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	      // call DAO method to get the email and password
	    HashMap<String, String> map;
	    List CurrencyList;
		try {
			 CurrencyList = CurrencyListDAO.getExchangeRateInfo();
			// request.setAttribute("cname", map.get("cname"));
		     //request.setAttribute("country", map.get("country"));
		     
		     //System.out.print("inside servlert:"+request.getAttribute("cname"));
		     System.out.print("inside servlert:"+CurrencyList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    //from the map you will get the  email and password.then you need to set them in the attributes and get them in your jsp

	    

	}
	
}

package net.codejava.dao;
import net.codejava.dao.dbConnector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import net.codejava.model.Currency;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class CurrencyListDAO {
	
	
	
	public static  List<Currency> getExchangeRateInfo() throws SQLException {
		
		 dbConnector db=new dbConnector();
		 Connection con=db.getConnection();
		 Statement statement = con.createStatement();
		 List<Currency> result = new ArrayList<Currency>();
		 
		
	     
	    try {
	        PreparedStatement ps=con.prepareStatement("  SELECT cur.Currency_Name,  MAX(CASE WHEN Exchange_Type = 'Buy' THEN Rate END) Buy,MAX(CASE WHEN Exchange_Type = 'Sell' THEN Rate END) Sell\n"
	        		+ "  FROM moneychanger.Currency cur, moneychanger.ExchangeRate ex \n"
	        		+ "  where cur.Currency_Code=ex.currencycode_to\n"
	        		+ "  GROUP BY cur.Currency_Name");
	        
	        ResultSet rs = ps.executeQuery();       
	       
	        while(rs.next()){
	        	  String cname =rs.getString("Currency_Name");
	              double buy = rs.getDouble("Buy");
	              double sell = rs.getDouble("Sell");
	              
	              Currency currency = new Currency();
	              currency.setCurrencyName(cname);
	              currency.setBuy(buy);
	              currency.setSell(sell);
	              result.add(currency);
	  	     
	        }
	       // System.out.println(result);
    	    return result;
    	    
	    } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	        return null;
	    }       
	  }
	
	public static  List<Currency> getCurrencyList() throws SQLException {
		 dbConnector db=new dbConnector();
		 Connection con=db.getConnection();
		 List<Currency> currencyList = new ArrayList<Currency>();
		 
		
	     
	    try {
	        PreparedStatement ps=con.prepareStatement("select Currency_Name,Currency_Description from moneychanger.Currency order by Currency_Name;");
	        
	        ResultSet rs = ps.executeQuery();       
	       
	        while(rs.next()){
	        	  String cname =rs.getString("Currency_Name");
	        	  String cdesc =rs.getString("Currency_Description");
	              Currency currency = new Currency(cname,cdesc);
	              currencyList.add(currency);
	        }
	        
	       // System.out.println("currencyList"+currencyList);
   	        return currencyList;
   	    
	    } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	        return null;
	    }       
	} 
}

	   
	
 


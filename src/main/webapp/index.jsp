<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="java.sql.Connection" %>
<%@page import="net.codejava.dao.dbConnector" %>
<%@page import="java.sql.DriverManager" %>
<%@page import="java.util.List" %>
<%@page import="net.codejava.model.Currency" %>
<!DOCTYPE html>


<html>
<head>
<meta charset="UTF-8">
<title>Resort World Money Changer</title>
</head>
<body>
<script>

var tempAmt=0;
var exchangeRate=0

function convert() {
 
  var calculatedRate=0;
  var validNumber = new RegExp(/^\d*\.?\d*$/);
  var amount = document.getElementById("amt").value;
  
  if(amount<=0){
	  //alert("Please enter a valid amount")
	  document.getElementById("error").innerHTML = "Please enter a valid amount.";
  }
  else{
	  var rates = document.getElementsByName('rdogroup');
	  var rate_value;
	  for(var i = 0; i < rates.length; i++){
	      if(rates[i].checked){
	          rate_value = rates[i].value;
	      }
	  }
	  
	  var e = document.getElementById("currencyFrom");
	  var Fromvalue = e.options[e.selectedIndex].value;
	  var Fromtext = e.options[e.selectedIndex].text;
	  
	  var e = document.getElementById("currencyTo");
	  var Tovalue = e.options[e.selectedIndex].value;
	  var Toext = e.options[e.selectedIndex].text;
	  
	 
	  if(rate_value === "sell"){
		
		 if(Fromvalue === "SGD"){
			   switch (Tovalue.toLowerCase()) {
			    case "usd" :
			        calculatedRate=amount/1.3574
			        break;
			    case "hkd" :
			    	 calculatedRate=amount/0.1698
				     break;
			    case "jpy" :
			    	 calculatedRate=amount*83.1311
				     break;
			    default :
			        break;
				}
	      }
		 else if(Fromvalue === "USD"){
			   switch (Tovalue.toLowerCase()) {
			    case "sgd" :
			        calculatedRate=amount*1.3574
			        break;
			    case "hkd" :
			    	 calculatedRate=amount*7.80265 
				     break;
			    case "jpy" :
			    	 calculatedRate=amount*113.723
			    default :
			        break;
				}
	    }
		 else if(Fromvalue === "HKD"){
			   switch (Tovalue.toLowerCase()) {
			    case "sgd" :
			        calculatedRate=amount*0.1698
			        break;
			    case "usd" :
			    	 calculatedRate=amount*0.128162
				     break;
			    case "jpy" :
			    	 calculatedRate=amount*14.5748
			    default :
			        break;
				}
	  		}
		 else if(Fromvalue === "JPY"){
			   switch (Tovalue.toLowerCase()) {
			    case "sgd" :
			        calculatedRate=amount*0.0120
			        break;
			    case "usd" :
			    	 calculatedRate=amount*0.008
				     break;
			    case "hkd" :
			    	 calculatedRate=amount*0.0686
			  
			    default :
			        break;
				}
			}
	  }   
	  else{
		  calculatedRate=amount/1.3392
		  if(Fromvalue === "SGD"){
			   switch (Tovalue.toLowerCase()) {
			    case "usd" :
			        calculatedRate=amount/1.3392
			        break;
			    case "hkd" :
			    	 calculatedRate=amount/0.1738
				     break;
			    case "jpy" :
			    	 calculatedRate=amount/81.1214
				     break;
			    default :
			        break;
				}
	      }
		  else if(Fromvalue === "USD"){
			   switch (Tovalue.toLowerCase()) {
			    case "sgd" :
			    	calculatedRate=amount*1.3392
			        break;
			    case "hkd" :
			    	 calculatedRate=amount*7.80265 
				     break;
			    case "jpy" :
			    	 calculatedRate=amount*110.7188
				     break;
			    default :
			        break;
				}
	      }
		  
		  else if(Fromvalue === "HKD"){
			   switch (Tovalue.toLowerCase()) {
			    case "sgd" :
			        calculatedRate=amount*0.1738
			        break;
			    case "usd" :
			    	 calculatedRate=amount*0.118162
				     break;
			    case "jpy" :
			    	 calculatedRate=amount**12.4842
				     break;
			    default :
			        break;
				}
	 		}
		  else if(Fromvalue === "JPY"){
			   switch (Tovalue.toLowerCase()) {
			    case "sgd" :
			        calculatedRate=amount*0.0140
			        break;
			    case "usd" :
			    	 calculatedRate=amount*0.005
				     break;
			    case "hkd" :
			    	 calculatedRate=amount*0.0654
			  
			    default :
			        break;
				}
			}
	  }
	  
	  // Math.round(calculatedRate) 
	  tempAmt= Math.round(calculatedRate)
	  var exchangeRateText= amount + " "+ Fromvalue + "=" + calculatedRate.toFixed(2) + " "+  Tovalue
	  document.getElementById("calculatedRate").innerHTML = exchangeRateText;
   }
  
  
}


function validate(evt) {
	  var theEvent = evt || window.event;
	  var key = theEvent.keyCode || theEvent.which;
	  key = String.fromCharCode( key );
	  var regex = /[0-9]|\./;
	  if( !regex.test(key) ) {
	    theEvent.returnValue = false;
	    if(theEvent.preventDefault) theEvent.preventDefault();
	  }
	}
	
function proceed(){
		//  var retVal = prompt("Enter your name : ", "your name here");
			 var amount = document.getElementById("amt").value;
			 
			 var e = document.getElementById("currencyFrom");
			 var Fromvalue = e.options[e.selectedIndex].value;
			 
			 var e = document.getElementById("currencyTo");
			 var Tovalue = e.options[e.selectedIndex].value;
			 
			 var chars = '1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz',serialLength = 10,randomSerial = "",i,randomNumber;
		    
		    for (i = 0; i < serialLength; i = i + 1) {
		        randomNumber = Math.floor(Math.random() * chars.length);
		        randomSerial += chars.substring(randomNumber, randomNumber + 1);
		      }
		    alert('               Your transaction is successful.\n  Serial No: '
		    		+randomSerial+
		    		'\n  Amount Exchange:  '+ amount +" "+ Fromvalue +
		    		'\n  ' + 'Total:  '+ tempAmt +" "+Tovalue)
        
	}
</script>
 <%
 //System.out.print("inside jsp"+request.getAttribute("CurrencyList"));
 %>
 
   <h1>Money Changer</h1>
   <form action="currencyServlet" method="get">
     <div>
       <table border ="1" width="500" align="center">
         <tr bgcolor="00FF7F">
          <th><b>Currency</b></th>
          <th><b>We Buy</b></th>
          <th><b>We Sell</b></th>
         </tr>
      
        <%List<Currency> exRate = (List<Currency>)request.getAttribute("ExchangeRateInfo");
        for(Currency ex:exRate){%>
            <tr>
                <td><%= ex.getCurrencyName() %></td>
                <td><%= ex.getBuy() %></td>
                <td><%= ex.getSell()%></td>
            </tr>
            <%}%>
        </table> 
     </div>
    
     <div>
          
          <input type="radio" name="rdogroup" value="buy"/>Buy
          <input type="radio" name="rdogroup" value="sell" checked/>Sell
          
          <br>
          <br>
          
          Amount: <input type="number" name="amt" id="amt" onkeypress='validate(event)'>
        
           	<select name="currencyFrom" id="currencyFrom" onchange="convert()">
                   <%List<Currency> currency = (List<Currency>)request.getAttribute("CurrencyList");
                   for(Currency c:currency){%>
			            <option value=<%=c.getCurrencyName() %>><%=c.getCurrecnyDesc()%></option>
			        <%}%>
			</select>
   		    ~
   		 	<select name="currencyTo" id="currencyTo" onchange="convert()">
	    		  <%List<Currency> currency1 = (List<Currency>)request.getAttribute("CurrencyList");
	                   for(Currency c:currency1){%>
				        <option value=<%=c.getCurrencyName() %>><%=c.getCurrecnyDesc() %></option>
				    <%}%>
			</select>
	   
      </div>
      <p id="error" style="color:red;"></p>
      <br>
       <p id="calculatedRate"></p>
        
       <div>
      <!--  <input type="button" value="Convert" onclick="convert()"/> --> 
        <input type="submit" value="Proceed" onclick="proceed()" style="margin:center;"/>
      </div>
      
     
</form>
</body>
</html>

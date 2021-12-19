package net.codejava.model;

public class Currency {
	
	public int currencyCode;
	public String currencyName;
	public String currecnyDesc;
	public String courntry;
	public String exChangeType;
	public double rate;
	public double buy;
	public double sell;

	
	public Currency() {
		super();
	}

	
	
	public Currency(String cname,String cDesc ) {
		this.currencyName=cname;
		this.currecnyDesc=cDesc;
	}



	@Override
	public String toString() {
		return "Currency [currencyCode=" + currencyCode + ", currencyName=" + currencyName + ", courntry=" + courntry
				+ "]";
	}

	public int getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(int currencyCode) {
		this.currencyCode = currencyCode;
	}
	public String getCurrencyName() {
		return currencyName;
	}
	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}
	public String getCourntry() {
		return courntry;
	}
	public void setCourntry(String courntry) {
		this.courntry = courntry;
	}



	public String getExChangeType() {
		return exChangeType;
	}



	public void setExChangeType(String exChangeType) {
		this.exChangeType = exChangeType;
	}



	public double getRate() {
		return rate;
	}



	public void setRate(double rate) {
		this.rate = rate;
	}



	public double getBuy() {
		return buy;
	}



	public void setBuy(double buy) {
		this.buy = buy;
	}



	public double getSell() {
		return sell;
	}



	public void setSell(double sell) {
		this.sell = sell;
	}



	public String getCurrecnyDesc() {
		return currecnyDesc;
	}



	public void setCurrecnyDesc(String currecnyDesc) {
		this.currecnyDesc = currecnyDesc;
	}
	
	
	

}

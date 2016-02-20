package be;
import java.text.SimpleDateFormat;

import util.Const.Indicator;
/**
 * Trade's information
 * @author Richard Vega
 *
 */
public class TradeBE {

	private String cStockSymbol="";
	private Indicator cCod_indicator;
	private double nPrice=0.0;
	private int nQuantity=0;
	private long timestamp=0;
	
	/**
	 * Constructor
	 * @param cCod_indicator: indicator (BUY/SELL)
	 * @param nPrice: price
	 * @param nQuantity: quantity
	 * @param timestamp: timestamp of operation
	 */
	public TradeBE(String cStockSymbol,Indicator cCod_indicator, double nPrice, int nQuantity,
			long timestamp) {
		
		this.cStockSymbol = cStockSymbol;
		this.cCod_indicator = cCod_indicator;
		this.nPrice = nPrice;
		this.nQuantity = nQuantity;
		this.timestamp = timestamp;
	}
	
	// Getters 
	//	
	public String getcStockSymbol() {
		return cStockSymbol;
	}
	public Indicator getcCod_indicator() {
		return cCod_indicator;
	}
	public double getnPrice() {
		return nPrice;
	}	
	public int getnQuantity() {
		return nQuantity;
	}	
	public long getTimestamp() {
		return timestamp;
	}
	
	// Setters
	//
	public void setcStockSymbol(String cStockSymbol) {
		this.cStockSymbol = cStockSymbol;
	}
	public void setcCod_indicator(Indicator cCod_indicator) {
		this.cCod_indicator = cCod_indicator;
	}	
	public void setnPrice(double nPrice) {
		this.nPrice = nPrice;
	}	
	public void setnQuantity(int nQuantity) {
		this.nQuantity = nQuantity;
	}	
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		String cTimeStamp = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(timestamp);
		return "TradeBE [Stock symbol=" + cStockSymbol + ", Operation="
				+ cCod_indicator + ", Unit Price=" + nPrice + ", Quntity="
				+ nQuantity + ", Date/Time=" + cTimeStamp + "] Cost: "+nQuantity*nPrice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((cCod_indicator == null) ? 0 : cCod_indicator.hashCode());
		result = prime * result
				+ ((cStockSymbol == null) ? 0 : cStockSymbol.hashCode());
		long temp;
		temp = Double.doubleToLongBits(nPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + nQuantity;
		result = prime * result + (int) (timestamp ^ (timestamp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TradeBE other = (TradeBE) obj;
		if (cCod_indicator != other.cCod_indicator)
			return false;
		if (cStockSymbol == null) {
			if (other.cStockSymbol != null)
				return false;
		} else if (!cStockSymbol.equals(other.cStockSymbol))
			return false;
		if (Double.doubleToLongBits(nPrice) != Double
				.doubleToLongBits(other.nPrice))
			return false;
		if (nQuantity != other.nQuantity)
			return false;
		if (timestamp != other.timestamp)
			return false;
		return true;
	}
	
	
	
}

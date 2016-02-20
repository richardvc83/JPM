package be;
import util.Const.TypeStock;
/**
 * Stock's information.
 * @author Richard Vega
 *
 */
public class StockBE {
	
	private String cCod_symbol="";	
	private TypeStock cCod_type;
	private double nLast_dividend=0.0;
	private double nFixed_dividend=0.0;
	private double nPar_value=0.0;
		
	/**
	 * Constructor
	 * @param cCod_symbol: stock symbol.
	 * @param cCod_type: type of stock (common o preferred)
	 * @param nLast_dividend: last dividend.
	 * @param nFixed_dividend: fixed dividend.
	 * @param nPar_value: par value.
	 */
	public StockBE(String cCod_symbol, TypeStock cCod_type, double nLast_dividend, double nFixed_dividend, double nPar_value) {
		this.cCod_symbol     = cCod_symbol;
		this.cCod_type       = cCod_type;
		this.nLast_dividend  = nLast_dividend;
		this.nFixed_dividend = nFixed_dividend;
		this.nPar_value      = nPar_value;
	}
	
	// Getters
	//
	public String getcCod_symbol() {
		return cCod_symbol;
	}
	public TypeStock getcCod_type() {
		return cCod_type;
	}
	public double getnLast_dividend() {
		return nLast_dividend;
	}
	public double getnFixed_dividend() {
		return nFixed_dividend;
	}
	public double getnPar_value() {
		return nPar_value;
	}	
	
	// Setters
	//
	public void setcCod_symbol(String cCod_symbol) {
		this.cCod_symbol = cCod_symbol;
	}
	public void setcCod_type(TypeStock cCod_type) {
		this.cCod_type = cCod_type;
	}
	public void setnLast_dividend(double nLast_dividend) {
		this.nLast_dividend = nLast_dividend;
	}
	public void setnFixed_dividend(double nFixed_dividend) {
		this.nFixed_dividend = nFixed_dividend;
	}
	public void setnPar_value(double nPar_value) {
		this.nPar_value = nPar_value;
	}

	@Override
	public String toString() {
		return "StockBE [Stock Symbol=" + cCod_symbol + ", Type="
				+ cCod_type + ", Last Dividend=" + nLast_dividend
				+ ", Fixed Dividen=" + nFixed_dividend + ", Par Value="
				+ nPar_value + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((cCod_symbol == null) ? 0 : cCod_symbol.hashCode());
		result = prime * result
				+ ((cCod_type == null) ? 0 : cCod_type.hashCode());
		long temp;
		temp = Double.doubleToLongBits(nFixed_dividend);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(nLast_dividend);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(nPar_value);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		StockBE other = (StockBE) obj;
		if (cCod_symbol == null) {
			if (other.cCod_symbol != null)
				return false;
		} else if (!cCod_symbol.equals(other.cCod_symbol))
			return false;
		if (cCod_type != other.cCod_type)
			return false;
		if (Double.doubleToLongBits(nFixed_dividend) != Double
				.doubleToLongBits(other.nFixed_dividend))
			return false;
		if (Double.doubleToLongBits(nLast_dividend) != Double
				.doubleToLongBits(other.nLast_dividend))
			return false;
		if (Double.doubleToLongBits(nPar_value) != Double
				.doubleToLongBits(other.nPar_value))
			return false;
		return true;
	}
	
	
}

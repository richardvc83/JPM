package util;

public class Const {

	// Type of stocks
	public enum TypeStock {
		COMMON, PREFERRED
	}
	
	// Indicator of trade
	public enum Indicator {
		BUY, SELL
	}
	
	// Random price, so we are supponsing all the prices are positive
	public static final int minPrice=0;
	public static final int maxPrice=99;
	
	// default value
	public static final double zero=0.0;
}

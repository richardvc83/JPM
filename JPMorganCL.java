package cl;

import test.TestStock;
import test.TestTrade;

public class JPMorganCL {

	public static void main (String[] args) {
		TestStock testStock = new TestStock();
		TestTrade testTrade = new TestTrade();
		
		System.out.println("Technical Test for JP Morgan");
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		
		// Test for the first exercise
		System.out.println("Exercise A.I) Calculate the Dividend Yeld");		
		testStock.testDividendYeld();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		
		// Test for the second exercise
		System.out.println("Exercise A.II) Calculate the P/E Ratio");
		testStock.testPERatio();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		
		// Test for the third exercise
		System.out.println("Exercise A.III) Record a trade");
		testTrade.testBuySellStock();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		
		// Test for the fourth exercise
		System.out.println("Exercise A.IV) Calculate the Stock Price");
		testTrade.testStockPrice();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		
		// Test for the fifth exercise
		System.out.println("Exercise B) Calculate the GBCE All Share Index using the Geometric Mean");
		testTrade.testGBCE();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	}
}

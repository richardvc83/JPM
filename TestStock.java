package test;

import util.Const;
import util.Const.TypeStock;
import be.StockBE;
import bl.StockBL;
import bl.StockImplBL;

public class TestStock {

	/**
	 * Test Dividend Yeld
	 */
	public void testDividendYeld() {
		StockBL stockBL = new StockImplBL();
		double nMarketPrice = stockBL.getRandomMarketPrice(Const.minPrice, Const.maxPrice);
		System.out.println("Market price: "+nMarketPrice);
		System.out.println("");
		System.out.println("");
		
		
		StockBE stock1 = new StockBE("TEA",TypeStock.COMMON,0,0,100); 
		double dividend1=stockBL.getDividendYield(stock1,nMarketPrice);
		System.out.println("Stock1: "+stock1.toString());		
		System.out.println("Dividend of stock1: "+dividend1);
		
		System.out.println("");
		System.out.println("");
		
		StockBE stock2 = new StockBE("GIN",TypeStock.PREFERRED,8,2,100); 
		double dividend2=stockBL.getDividendYield(stock2,nMarketPrice);
		System.out.println("Stock2: "+stock2.toString());		
		System.out.println("Dividend of stock2: "+dividend2);		
	}
	
	/**
	 * Test PE Ratio
	 */
	public void testPERatio() {
		StockBL stockBL = new StockImplBL();
		double nMarketPrice = stockBL.getRandomMarketPrice(Const.minPrice, Const.maxPrice);
		System.out.println("Market price: "+nMarketPrice);
		System.out.println("");
		System.out.println("");
		
		StockBE stock1 = new StockBE("TEA",TypeStock.COMMON,0,0,100);
		double nPERatio1=stockBL.getPERatio(stock1, nMarketPrice);
		System.out.println("Stock1: "+stock1.toString());
		System.out.println("P/E Ratio of stock1: "+nPERatio1);
		
		System.out.println("");
		System.out.println("");
		
		StockBE stock2 = new StockBE("GIN",TypeStock.PREFERRED,8,2,100); 
		double nPERatio2=stockBL.getPERatio(stock2, nMarketPrice);
		System.out.println("Stock2: "+stock2.toString());
		System.out.println("P/E Ratio of stock2: "+nPERatio2);
	}
	
}

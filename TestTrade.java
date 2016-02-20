package test;

import java.util.ArrayList;
import java.util.List;

import util.Const;
import util.Const.TypeStock;
import be.StockBE;
import be.TradeBE;
import bl.StockBL;
import bl.StockImplBL;
import bl.TradeBL;
import bl.TradeImplBL;

public class TestTrade {

	/**
	 * Method for testing the trades.
	 */
	public void testBuySellStock() {
		TradeBL tradeBL = new TradeImplBL();
		List<TradeBE> listTrade = new ArrayList<TradeBE>();
		
		testBuyStock(listTrade);
		testSellStock(listTrade);
		tradeBL.seeTradeList(listTrade);
	}
	
	public void testStockPrice() {
		TradeBL tradeBL = new TradeImplBL();
		List<TradeBE> listTrade = new ArrayList<TradeBE>();
		
		testBuyStock(listTrade);
		testSellStock(listTrade);
		tradeBL.seeTradeList(listTrade);
		System.out.println();
		System.out.println("Stock Price "+tradeBL.getStockPrice(listTrade));
	}
	
	/**
	 * Mehtod for testing the GBCE All Share Index
	 */
	public void testGBCE() {
		TradeBL tradeBL = new TradeImplBL();
		List<TradeBE> listTrade = new ArrayList<TradeBE>();
		
		testBuyStock(listTrade);
		testSellStock(listTrade);
		tradeBL.seeTradeList(listTrade);
		System.out.println();
		System.out.println("Geometric Mean "+tradeBL.getGeometricMean(listTrade));
	}
	
	//
	// Private methods
	
	/**
	 * Method for testing the buy of stock and record the trade
	 * @param listTrede a list of trades
	 */
	private void testBuyStock(List<TradeBE> listTrade) {
		TradeBL tradeBL = new TradeImplBL();
		StockBL stockBL = new StockImplBL();
		
		double price = stockBL.getRandomMarketPrice(Const.minPrice, Const.maxPrice);
		int quantity = (int) stockBL.getRandomMarketPrice(Const.minPrice, Const.maxPrice);
		StockBE stock1 = new StockBE("TEA",TypeStock.COMMON,0,0,100); 
		listTrade.add(tradeBL.buyStock(stock1, price, quantity, System.currentTimeMillis()));
				
		price = stockBL.getRandomMarketPrice(Const.minPrice, Const.maxPrice);
		quantity = (int) stockBL.getRandomMarketPrice(Const.minPrice, Const.maxPrice);
		StockBE stock2 = new StockBE("GIN",TypeStock.PREFERRED,8,2,100); 
		listTrade.add(tradeBL.buyStock(stock2, price, quantity, System.currentTimeMillis()));
	}
		
	/**
	 * Method for testing the sell of stock and record the trade.
	 * @param listTrade a lista of trades
	 */
	private void testSellStock(List<TradeBE> listTrade) {
		TradeBL tradeBL = new TradeImplBL();
		StockBL stockBL = new StockImplBL();
		
		double price = stockBL.getRandomMarketPrice(Const.minPrice, Const.maxPrice);	
		int quantity = (int) stockBL.getRandomMarketPrice(Const.minPrice, Const.maxPrice);
				
		StockBE stock1 = new StockBE("POP",TypeStock.COMMON,0,0,100); 
		listTrade.add(tradeBL.sellStock(stock1, price, quantity, System.currentTimeMillis()));
				
		price = stockBL.getRandomMarketPrice(Const.minPrice, Const.maxPrice);
		quantity = (int) stockBL.getRandomMarketPrice(Const.minPrice, Const.maxPrice);
		StockBE stock2 = new StockBE("ALE",TypeStock.PREFERRED,8,2,100); 
		listTrade.add(tradeBL.sellStock(stock2, price, quantity, System.currentTimeMillis()));
	}
}

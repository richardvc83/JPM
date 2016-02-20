package bl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import util.Const;
import be.StockBE;
import be.TradeBE;

public class TradeImplBL implements TradeBL{

	/**
	 * Method to buy stock
	 * @param stock
	 * @param nPrice: price market
	 * @param nQuantity: quantity of shares.
	 * @param timestamp: timestamp of transaction
	 * @return 
	 * 
	 */
	public TradeBE buyStock(StockBE stock, double nPrice, int nQuantity, long timestamp){
		return new TradeBE(stock.getcCod_symbol(), Const.Indicator.BUY, nPrice, nQuantity, timestamp);
	}
	
	/**
	 * Method to buy stock
	 * @param stock
	 * @param nPrice: price market
	 * @param nQuantity: quantity of shares.
	 * @param timestamp: timestamp of transaction
	 * @return 
	 * 
	 */
	public TradeBE sellStock(StockBE stock, double nPrice, int nQuantity, long timestamp){
		return new TradeBE(stock.getcCod_symbol(), Const.Indicator.SELL, nPrice, nQuantity, timestamp);
	}
	
	/**
	 * Method to get Geometric Mean
	 * @param listTrade
	 * @return
	 */
	public double getGeometricMean(List<TradeBE> listTrade) {
		return calculateGeometricMean(listTrade);
	}

	/**
	 * MEthod to get Stock Price
	 * @param listTrade
	 * @return
	 */
	public double getStockPrice(List<TradeBE> listTrade) {		
		return calculateStockPrice(listTrade);
	}
	
	public void seeTradeList(List<TradeBE> listTrade) {
		seeTrades(listTrade);
	}
	
	// Private Methods with the business logic
	
	/**
	 * This method calculate the Geometric Mean of a List of Trades.
	 * @param listTrade
	 * @return nGeometricMean
	 */
	private double calculateGeometricMean(List<TradeBE> listTrade) {
		double nGeometricMean=Const.zero;
		
		if (listTrade.size()>0) {
			// Initizalize variable to multiply the price
			double nPriceMultiply=1.0;
			
			Iterator<TradeBE> iter = listTrade.iterator();
			while(iter.hasNext()){
				TradeBE tradeBE = (TradeBE)iter.next();
				nPriceMultiply *= (tradeBE.getnPrice());
			}
			nGeometricMean=Math.pow(nPriceMultiply, 1.0/listTrade.size());
		}
		return nGeometricMean;
	}
	
	/**
	 * This method calculate the Stock Price of a List of Trades.
	 * @param listTrade
	 * @return nStockPrice
	 */
	private double calculateStockPrice(List<TradeBE> listTrade) {
		double nStockPrice=Const.zero;
		
		List<TradeBE> filteredListTrade = filterList(listTrade);
		
		if (filteredListTrade.size()>0) {
			// Initialize variables to sum quantity and product of price and quantity
			double nSumQuatity = Const.zero;
			double nPriceQuantity=Const.zero;
			
			Iterator<TradeBE> iter = filteredListTrade.iterator();
			while(iter.hasNext()){
				TradeBE tradeBE = (TradeBE)iter.next();
				nSumQuatity +=tradeBE.getnQuantity();
				nPriceQuantity += tradeBE.getnPrice()*tradeBE.getnQuantity();
			}
			nStockPrice=nPriceQuantity/nSumQuatity;
		} else {
			System.out.println("There is no trades in the last 15 minutes");
		}
		return nStockPrice;
	}
	
	/**
	 * This method print the information of a Trade's List
	 * @param listTrade
	 */
	private void seeTrades(List<TradeBE> listTrade) {
		if (listTrade.size()>0) {
			System.out.println("List of trades: ");
			Iterator<TradeBE> iter = listTrade.iterator();
			while(iter.hasNext()){
				TradeBE tradeBE = (TradeBE)iter.next();
				System.out.println(tradeBE.toString());
			}
		} else {
			System.out.println("There is not trades.");			
		}
	}
	
	/**
	 * This method filter the trades in the last 15 minutes (90000 miliseconds)
	 * @param listTrade
	 * @return filterTrade
	 */
	private List<TradeBE> filterList(List<TradeBE> listTrade) {
		List<TradeBE> filteredListTrade=new ArrayList<TradeBE>();
		final long deadLine=System.currentTimeMillis()-Const.deadLine;
		
		Iterator<TradeBE> iter = listTrade.iterator();
		while(iter.hasNext()){
			TradeBE tradeBE = (TradeBE)iter.next();
			if (tradeBE.getTimestamp()>deadLine) {
				filteredListTrade.add(tradeBE);
			}
		}
		return filteredListTrade;
	}
}

package bl;

import java.util.List;

import be.StockBE;
import be.TradeBE;

public interface TradeBL {

	public TradeBE buyStock(StockBE stock, double price, int quantity, long timestamp);
	public TradeBE sellStock(StockBE stock, double price, int quantity, long timestamp);
	public double getGeometricMean(List<TradeBE> listTrade);
	public double getStockPrice(List<TradeBE> listTrade);
	public void seeTradeList(List<TradeBE> listTrade);
}

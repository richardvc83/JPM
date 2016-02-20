package bl;

import be.StockBE;

public interface StockBL {

	public double getDividendYield(StockBE stock, double nMarketPrice);
	public double getPERatio(StockBE stock, double nMarketPrice);
	public double getRandomMarketPrice(int min, int max);
}

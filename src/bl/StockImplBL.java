package bl;

import java.util.Random;

import be.StockBE;
import util.Const;
import util.Const.TypeStock;

public class StockImplBL implements StockBL {

	@Override
	public double getDividendYield(StockBE stock, double nMarketPrice) {
		double nDividendYield=Const.zero;
		if (nMarketPrice>Const.zero) {
			if (TypeStock.COMMON.equals(stock.getcCod_type())) {
				nDividendYield=getDividendYieldCommon(stock,nMarketPrice);
			} else if (TypeStock.PREFERRED.equals(stock.getcCod_type())) {
				nDividendYield=getDividendYieldPreferred(stock,nMarketPrice);
			}
		}
		return nDividendYield;
	}

	@Override
	public double getPERatio(StockBE stock, double nMarketPrice) {
		double nPERatio=Const.zero;
		if (stock.getnLast_dividend()>Const.zero) {
			nPERatio=calculatePERatio(stock, nMarketPrice);
		}
		return nPERatio;
	}

	@Override
	public double getRandomMarketPrice(int min, int max) {
		Random r = new Random();
		return min + (max - min) * r.nextDouble();
	}

	// Private methods 
	private double getDividendYieldPreferred(StockBE stock, double nMarketPrice) {
		return stock.getnFixed_dividend()*stock.getnPar_value()/nMarketPrice;
	}
	
	private double getDividendYieldCommon(StockBE stock, double nMarketPrice) {
		return stock.getnLast_dividend()/nMarketPrice;
	}
	
	private double calculatePERatio(StockBE stock, double nMarketPrice) {
		return nMarketPrice/stock.getnLast_dividend();
	}	
}

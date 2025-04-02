package org.yourcompany.javamonkey;

import java.util.ArrayList;
import java.util.List;

public class Portfolio {
    private List<Stock> stocks;

    public Portfolio() {
        this.stocks = new ArrayList<>();
    }

    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    public List<Stock> getStocks() {
        return stocks;
    }
}

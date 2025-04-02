package org.yourcompany.javamonkey;

import java.util.Arrays;
import java.util.List;

public class PortfolioGenerator {

    public static Portfolio generatePortfolio(UserProfile userProfile) {
        Portfolio portfolio = new Portfolio();

        List<Stock> availableStocks = Arrays.asList(
                new Stock("Apple", "AAPL", 28.5, 0.6, 12.3),
                new Stock("Tesla", "TSLA", 75.4, 0, 25.6),
                new Stock("Pfizer", "PFE", 15.2, 4.2, 5.1),
                new Stock("Duke Energy", "DUK", 18.7, 3.8, 4.4),
                new Stock("Nike", "NKE", 33.6, 1.1, 10.2)
        );

        for (Stock stock : availableStocks) {
            if (userProfile.getRiskTolerance() > 7 && stock.getGrowthRate() > 10) {
                portfolio.addStock(stock);
            } else if (userProfile.getRiskTolerance() <= 7 && stock.getPeRatio() < 30) {
                portfolio.addStock(stock);
            }
        }

        return portfolio;
    }
}

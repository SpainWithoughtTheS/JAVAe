package org.yourcompany.javamonkey;

public class PortfolioDisplay {
    public static void displayPortfolio(Portfolio portfolio) {
        System.out.println("Generated Portfolio:");
        for (Stock stock : portfolio.getStocks()) {
            System.out.println(stock.getName() + " (" + stock.getPeRatio() + " PE, " + stock.getGrowthRate() + "% Growth)");
        }
    }
}

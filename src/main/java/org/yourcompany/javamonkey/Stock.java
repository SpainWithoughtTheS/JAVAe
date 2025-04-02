package org.yourcompany.javamonkey;

public class Stock {
    private String name;
    private String ticker;
    private double peRatio;
    private double dividendYield;
    private double growthRate;

    public Stock(String name, String ticker, double peRatio, double dividendYield, double growthRate) {
        this.name = name;
        this.ticker = ticker;
        this.peRatio = peRatio;
        this.dividendYield = dividendYield;
        this.growthRate = growthRate;
    }

    public String getName() {
        return name;
    }

    public String getTicker() {
        return ticker;
    }

    public double getPeRatio() {
        return peRatio;
    }

    public double getDividendYield() {
        return dividendYield;
    }

    public double getGrowthRate() {
        return growthRate;
    }

    @Override
    public String toString() {
        return String.format("Stock{name='%s', ticker='%s', P/E=%.2f, Yield=%.2f%%, Growth=%.2f%%}",
                name, ticker, peRatio, dividendYield, growthRate);
    }
}

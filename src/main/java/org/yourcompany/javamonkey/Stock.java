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

    public double getPeRatio() {
        return peRatio;
    }

    public double getGrowthRate() {
        return growthRate;
    }
}

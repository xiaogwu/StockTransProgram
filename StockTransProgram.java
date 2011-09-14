/* Xiao G. Wu
 * CS111A - Assignment 3
 * 09/09/2011
 */

/** This class displays the amount of profit or loss from a stock transaction */

public class StockTransProgram
{
    /** Main method */

    public static void main(String[] args)
    {
        // Named Constants
        final int SHARES = 1000; // Shares purchased and sold
        final double COST = 32.87; // Initial purchase price of shares
        final double COMMISSION = 0.02; // Commission percentage
        final double MIN_PRICE = 34.00; // Minimum sell price
        final double MAX_PRICE = 35.00; // Maximum sell price

        // Variables
        double profit = 0.0;
        double stockPrice = 0.0;

        // Get current stock price
        stockPrice = currentStockPrice(MIN_PRICE, MAX_PRICE);
        // Calculate profit or loss
        profit = calculateProfit(SHARES, COST, stockPrice, COMMISSION);

        // Print out current selling price
        System.out.printf("Selling at current stock price: $%.2f\n", stockPrice);
        // Print out profit or loss
        if (profit > 0.0)
            System.out.printf("Joe's profit is $%.2f\n", profit);
        else
            System.out.printf("Joe's loss is ($%.2f)\n", -profit); // Negate negative profit for presentation
    }

    /** This method returns the currentStockPrice based on min max range args */
    public static double currentStockPrice(double minPrice, double maxPrice)
    {
        // Use Math random number generator to set current stock price between min max range
        return minPrice + (Math.random() * ((maxPrice - minPrice) +1));
    }

    /** This method returns the profit or loss from the stock transaction */
    public static double calculateProfit(int shares, double purchasePrice, double sellingPrice, double commission)
    {
        double totalCost = 0.0;
        double actualReturn = 0.0;

        // Calculate cost
        totalCost = shares * purchasePrice;
        //totalCost = totalCost + (totalCost * commission);
        totalCost += totalCost * commission;

        // Calculate return
        actualReturn = shares * sellingPrice;
        //actualReturn = actualReturn - (actualReturn * commission);
        actualReturn -= actualReturn * commission;

        // Return final profit or loss
        return actualReturn - totalCost;
    }
}



public class ProfitAndLoss {
	public static void main(String[] args) {
		int costPrice = 129, sellingPrice = 191;
		int profit = sellingPrice - costPrice;
		double profitPercentage = (profit * 100)/ costPrice;
		System.out.println("The Cost Price is INR " + costPrice + " and Selling price is INR " + sellingPrice);
		System.out.println("The Profit is INR " + profit + " and the Profit Percentage is " + profitPercentage);
	}
}



public class DiscountedAmountAndPrice {
	public static void main(String[]args) {
		int fee=25000;
		int discountPercent=10;
		int discount=(fee*discountPercent)/100;
		int finalFee=fee-discount;
		System.out.println("The dis"
				+ "count amount is INR: "+discount+" and final discounted fee is INR: "+finalFee);
	
	}
}

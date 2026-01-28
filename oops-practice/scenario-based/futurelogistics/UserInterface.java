package com.scenariobased.oops.futurelogistics;

import java.util.Scanner;

public class UserInterface {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Utility utility = new Utility();

		System.out.println("Enter the Goods Transport Details");
		String input = sc.next();

		String transportId = input.split(":")[0];

		if (!utility.validatTransportId(transportId)) {
			System.out.println("Please provide a valid record");
			return;
		}

		GoodsTransport goodsTransport = utility.parseDetails(input);

		String vehicle = goodsTransport.vehicleSelection();
		float totalCharge = goodsTransport.calculateTotalCharge();

		System.out.println("Transporter id : " + goodsTransport.getTransportId());
		System.out.println("Date of transport : " + goodsTransport.getTransportDate());
		System.out.println("Rating of the transport : " + goodsTransport.getTransportRating());

		if (goodsTransport instanceof BrickTransport brick) {
			System.out.println("Quantity of Bricks: " + brick.getBrickQuantity());
			System.out.println("Brick Price: " + brick.getBrickPrice());
		} else if (goodsTransport instanceof TimberTransport timber) {

			System.out.println("Type of the timber : " + timber.getTimberType());
			System.out.println("Timber price per kilo : " + timber.getTimberPrice());
		}

		System.out.println("Vehicle for transport : " + vehicle);
		System.out.println("Total charge : " + totalCharge);

		sc.close();
	}
}

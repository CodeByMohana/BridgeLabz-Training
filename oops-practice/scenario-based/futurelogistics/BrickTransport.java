package com.scenariobased.oops.futurelogistics;

public class BrickTransport extends GoodsTransport {

	private float brickSize;
	private int brickQuantity;
	private float brickPrice;

	public BrickTransport(String transportId, String transportDate, int transportRating, float brickSize,
			int brickQuantity, float brickPrice) {
		super(transportId, transportDate, transportRating);
		this.brickSize = brickSize;
		this.brickQuantity = brickQuantity;
		this.brickPrice = brickPrice;
	}

	public float getBrickSize() {
		return brickSize;
	}

	public void setBrickSize(float brickSize) {
		this.brickSize = brickSize;
	}

	public int getBrickQuantity() {
		return brickQuantity;
	}

	public void setBrickQuantity(int brickQuantity) {
		this.brickQuantity = brickQuantity;
	}

	public float getBrickPrice() {
		return brickPrice;
	}

	public void setBrickPrice(float brickPrice) {
		this.brickPrice = brickPrice;
	}

	@Override
	public String vehicleSelection() {
		if (brickQuantity < 300) {
			return "Truck";
		} else if (brickQuantity <= 500) {
			return "Lorry";
		} else {
			return "MonsterLorry";
		}
	}

	@Override
	public float calculateTotalCharge() {

		float price = brickSize * brickQuantity;
		float tax = price * 0.3f;

		String vehicle = vehicleSelection();
		float vehiclePrice = 0;

		if (vehicle.equalsIgnoreCase("Truck")) {
			vehiclePrice = 1_000;
		} else if (vehicle.equalsIgnoreCase("Lorry")) {
			vehiclePrice = 1_700;
		} else {
			vehiclePrice = 3_000;
		}

		float discountPercent = 0;

		if (transportRating == 5) {
			discountPercent = 0.2f;
		} else if (transportRating == 3 || transportRating == 4) {
			discountPercent = 0.1f;
		}

		float discount = price * discountPercent;

		return (price + vehiclePrice + tax) - discount;
	}

}

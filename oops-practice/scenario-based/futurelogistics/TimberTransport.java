package com.scenariobased.oops.futurelogistics;

public class TimberTransport extends GoodsTransport {

	private float timberLength;
	private float timberRadius;
	private String timberType;
	private float timberPrice;

	public TimberTransport(String transportId, String transportDate, int transportRating, float timberLength,
			float timberRadius, String timberType, float timberPrice) {
		super(transportId, transportDate, transportRating);
		this.timberLength = timberLength;
		this.timberRadius = timberRadius;
		this.timberType = timberType;
		this.timberPrice = timberPrice;
	}

	@Override
	public String vehicleSelection() {
		float area = (float) (2 * 3.147 * timberRadius * timberLength);

		if (area < 250) {
			return "Truck";
		} else if (area >= 250 && area <= 400) {
			return "Lorry";
		} else {
			return "MonsterLorry";
		}
	}

	@Override
	public float calculateTotalCharge() {
		float volume = (float) (3.147 * timberRadius * timberRadius * timberLength);
		float timberTypeValue = 0;
		
		if(timberType.equalsIgnoreCase("Premium")) {
			timberTypeValue = 0.25f;
		}else if(timberType.equalsIgnoreCase("NonPremium")) {
			timberTypeValue = 0.15f;
		}
		float price = volume * timberPrice * timberTypeValue;
		
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

	public float getTimberLength() {
		return timberLength;
	}

	public void setTimberLength(float timberLength) {
		this.timberLength = timberLength;
	}

	public float getTimberRadius() {
		return timberRadius;
	}

	public void setTimberRadius(float timberRadius) {
		this.timberRadius = timberRadius;
	}

	public String getTimberType() {
		return timberType;
	}

	public void setTimberType(String timberType) {
		this.timberType = timberType;
	}

	public float getTimberPrice() {
		return timberPrice;
	}

	public void setTimberPrice(float timberPrice) {
		this.timberPrice = timberPrice;
	}

}

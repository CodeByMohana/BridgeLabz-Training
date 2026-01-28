package com.scenariobased.oops.futurelogistics;

public class Utility {
	public GoodsTransport parseDetails(String input) {
		String[] data = input.split(":");

		String transportId = data[0];
		String transportDate = data[1];
		int transportRating = Integer.parseInt(data[2]);
		String transportType = data[3];

		if (transportType.equalsIgnoreCase("BrickTransport")) {
			
			float brickSize = Float.parseFloat(data[4]);
			int brickQuantity = Integer.parseInt(data[5]);
			float brickPrice = Float.parseFloat(data[6]);

			return new BrickTransport(transportId, transportDate, transportRating, brickSize, brickQuantity,
					brickPrice);
		} else if (transportType.equalsIgnoreCase("TimberTransport")) {
			
			float timberLength = Float.parseFloat(data[4]);
			float timberRadius = Float.parseFloat(data[5]);
			String timberType = data[6];
			float timberPrice = Float.parseFloat(data[7]);

			return new TimberTransport(transportId, transportDate, transportRating, timberLength, timberRadius,
					timberType, timberPrice);
		}
		return null;
	}

	public boolean validatTransportId(String transportId) {
		if(transportId.matches("RTS[0-9]{3}[A-Z]")) {
			return true;
		}
		System.out.println("Transport id " + transportId + " is invalid");
		return false;
	}

	public String findObjectType(GoodsTransport goodsTransport) {
		
		if(goodsTransport instanceof BrickTransport) {
			return "BrickTransport";
		}
		
		if(goodsTransport instanceof TimberTransport) {
			return "TimberTransport";
		}
		return "Unknown";

	}
}

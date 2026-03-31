package com.oop.gcrcodebase.inheritance;

import java.time.LocalDate;

class Order {
	String orderId;
	LocalDate orderDate;

	public Order(String orderId, LocalDate orderDate) {
		this.orderId = orderId;
		this.orderDate = orderDate;
	}

	public String getOrderStatus() {
		return "Order Placed";
	}

}

class ShippedOrder extends Order {
	String trackingNumber;

	public ShippedOrder(String orderId, LocalDate orderDate, String trackingNumber) {
		super(orderId, orderDate);
		this.trackingNumber = trackingNumber;
	}

	@Override
	public String getOrderStatus() {
		return "Order Shipped with Tracking Number: " + trackingNumber;
	}

}

class DeliveredOrder extends ShippedOrder{
	LocalDate deliveryDate;

	public DeliveredOrder(String orderId, LocalDate orderDate, String trackingNumber, LocalDate deliveryDate) {
		super(orderId, orderDate, trackingNumber);
		this.deliveryDate = deliveryDate;
	}
	@Override
	public String getOrderStatus() {
		return "Order delivered on: " + deliveryDate + " with tracking number: " + trackingNumber;
	}
	
}
public class OnlineRetailOrderManagement {
	public static void main(String[] args) {
		Order order = new Order("ORD001", LocalDate.of(2025, 6, 28));
		ShippedOrder shipped = new ShippedOrder("ORD002", LocalDate.of(2025, 6, 27), "TRK123456");
		DeliveredOrder delivered = new DeliveredOrder("ORD003", LocalDate.of(2025, 6, 25), "TRK654321",
				LocalDate.of(2025, 6, 30));

		System.out.println("Order Status 1: " + order.getOrderStatus());
		System.out.println("Order Status 2: " + shipped.getOrderStatus());
		System.out.println("Order Status 3: " + delivered.getOrderStatus());
	}
}

package com.multithreading;

class Chef extends Thread {

	private String dish;
	private double cookTime;

	public Chef(String name, String dish, double cookTime) {
		super(name);
		this.dish = dish;
		this.cookTime = cookTime;
	}

	@Override
	public void run() {

		try {
			System.out.println(getName() + " started preparing " + dish);

			int[] progress = { 25, 50, 75, 100 };

			for (int p : progress) {
				Thread.sleep((long) (cookTime * 1000 / 4));
				System.out.println(getName() + " preparing " + dish + ": " + p + "% complete");
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class Restaurant {

    public static void main(String[] args) throws Exception {

        Chef c1 = new Chef("Chef-1", "Pizza", 3);
        Chef c2 = new Chef("Chef-2", "Pasta", 2);
        Chef c3 = new Chef("Chef-3", "Salad", 1);
        Chef c4 = new Chef("Chef-4", "Burger", 2.5);

        c1.start();
        c2.start();
        c3.start();
        c4.start();

        c1.join();
        c2.join();
        c3.join();
        c4.join();

        System.out.println("Kitchen closed - All orders completed");
    }
}


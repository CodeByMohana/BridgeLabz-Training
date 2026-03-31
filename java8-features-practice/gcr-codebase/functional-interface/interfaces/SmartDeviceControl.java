package com.java8practice.functionalinterface.interfaces;


interface SmartDevice {
	void turnOn();

	void turnOff();
}


class Light implements SmartDevice {

	@Override
	public void turnOn() {
		System.out.println("Lights are turned On");
	}

	@Override
	public void turnOff() {
		System.out.println("Lights are turned off");
	}

}

class AC implements SmartDevice {

	@Override
	public void turnOn() {
		System.out.println("AC is turned On");
	}

	@Override
	public void turnOff() {
		System.out.println("AC is turned off");
	}

}

class TV implements SmartDevice {

	@Override
	public void turnOn() {
		System.out.println("TV is turned On");
	}

	@Override
	public void turnOff() {
		System.out.println("TV os turned off");

	}

}

public class SmartDeviceControl {

	public static void main(String[] args) {

		SmartDevice light = new Light();
		light.turnOn();
		light.turnOff();

		SmartDevice ac = new AC();
		ac.turnOn();
		ac.turnOff();

		SmartDevice tv = new TV();
		tv.turnOn();
		tv.turnOff();

	}

}

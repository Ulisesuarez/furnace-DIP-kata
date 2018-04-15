package org.mvpigs.furnaceDIP.types;

public class RoomTemperature {
	
	private double temperature = 0;
	
	public RoomTemperature(double temperature){
		this.temperature = temperature;
	}
	public RoomTemperature(){}
	public double getTemperature() {
		return this.temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	
	public void incrementTemperature(double increment){
		this.temperature += increment;
	}

}

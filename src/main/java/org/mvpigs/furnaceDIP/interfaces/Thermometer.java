package org.mvpigs.furnaceDIP.interfaces;

import org.mvpigs.furnaceDIP.types.RoomTemperature;

public interface Thermometer {
	
	public double read(RoomTemperature temperature);
}

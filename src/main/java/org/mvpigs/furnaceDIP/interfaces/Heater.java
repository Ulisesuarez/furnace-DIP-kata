package org.mvpigs.furnaceDIP.interfaces;

import org.mvpigs.furnaceDIP.types.RoomTemperature;

public interface Heater {
	
	public void engage(RoomTemperature temperature);
	public void disengage(RoomTemperature temperature);

}

package org.mvpigs.furnaceDIP.hardware;

import com.google.inject.Singleton;
import org.mvpigs.furnaceDIP.interfaces.Thermometer;
import org.mvpigs.furnaceDIP.types.RoomTemperature;

@Singleton
public class RemoteCommandSensor implements Thermometer {

	public double read(RoomTemperature temperature){
		return temperature.getTemperature();
	}

}

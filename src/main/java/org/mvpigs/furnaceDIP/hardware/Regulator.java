package org.mvpigs.furnaceDIP.hardware;

import com.google.inject.Inject;
import org.mvpigs.furnaceDIP.injector.Force;
import org.mvpigs.furnaceDIP.interfaces.Heater;
import org.mvpigs.furnaceDIP.interfaces.Regulable;
import org.mvpigs.furnaceDIP.interfaces.Thermometer;
import org.mvpigs.furnaceDIP.types.RegulatorDisplayCodes;
import org.mvpigs.furnaceDIP.types.RoomTemperature;

public class Regulator implements Regulable{

	private Thermometer t ;
	private Heater h;
	private double minTemp;
	private double maxTemp ;
	private RoomTemperature temperature;
	private RegulatorDisplayCodes code;

    @Inject
	public Regulator(Thermometer t, Heater h){
	    this.t = t;
	    this.h = h;
    }
    @Inject
    public void setTemperature(RoomTemperature temperature) {
        this.temperature = temperature;
    }
    public void setMinTemp(double minTemp) {
        this.minTemp = minTemp;
    }

    public void setMaxTemp(double maxTemp) {
        this.maxTemp = maxTemp;
    }


    public void regulate() {

		while (t.read(temperature) < maxTemp) {
			code = RegulatorDisplayCodes.HEATING;
			h.engage(temperature);
			message();
		}
		while (t.read(temperature) > minTemp) {
			code = RegulatorDisplayCodes.WAITING;
			h.disengage(temperature);
			message();
		}
	}

	public void message() {
		switch (code) {
			case HEATING:
			System.out.println("Calentando => temperatura " + temperature.getTemperature());
				break;
			case WAITING:
				System.out.println("Apagado => temperatura " + temperature.getTemperature());
				break;
			default:
				System.out.println("Algo raro sucede...");
				break;
		}
	}

}

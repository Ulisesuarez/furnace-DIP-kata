package org.mvpigs.furnaceDIP.injector;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import org.mvpigs.furnaceDIP.hardware.GasHeater;
import org.mvpigs.furnaceDIP.hardware.RemoteCommandSensor;
import org.mvpigs.furnaceDIP.interfaces.Heater;
import org.mvpigs.furnaceDIP.interfaces.Thermometer;
import org.mvpigs.furnaceDIP.otherstuff.Jedi;
import org.mvpigs.furnaceDIP.types.RoomTemperature;

public class RegulatorModule extends AbstractModule{

    @Override
    protected void configure() {
        bind(Thermometer.class).to(RemoteCommandSensor.class);
        bind(Heater.class).to(GasHeater.class);
        bind(Heater.class).annotatedWith(Force.class).to(Jedi.class);


    }

    @Provides
    RoomTemperature provideRoomTemperature() {
        RoomTemperature roomTemperature = new RoomTemperature();
// movemos la configuracion del objeto desde el main a este modulo
        roomTemperature.setTemperature(15);
        return roomTemperature;
    }
}

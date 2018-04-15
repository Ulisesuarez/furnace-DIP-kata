package org.mvpigs.furnaceDIP.main;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.mvpigs.furnaceDIP.hardware.GasHeater;
import org.mvpigs.furnaceDIP.hardware.Regulator;
import org.mvpigs.furnaceDIP.hardware.RemoteCommandSensor;
import org.mvpigs.furnaceDIP.injector.RegulatorModule;
import org.mvpigs.furnaceDIP.interfaces.Heater;
import org.mvpigs.furnaceDIP.interfaces.Thermometer;
import org.mvpigs.furnaceDIP.otherstuff.Jedi;
import org.mvpigs.furnaceDIP.types.RoomTemperature;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	final double minTemp = 15.0;
        final double maxTemp = 21.0;

        Injector injector = Guice.createInjector(new RegulatorModule());

        /*
         * Now that we've got the injector, we can build objects.
         * El codigo equivalente es:
         * Heater heater = new GasHeater();
         * Thermometer thermometer = new RemoteCommandSensor();
         * Regulador regulator = new Regulador(Thermometer, GasHeater);
         */
        Regulator regulador = injector.getInstance(Regulator.class);
        regulador.setMaxTemp(maxTemp);
        regulador.setMinTemp(minTemp);
        System.out.println( "Arrancando..." );
        regulador.regulate();


    }
}

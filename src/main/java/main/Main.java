package main;

import core.InitCore;
import core.InitProviderTS;
import core.Mediador;
import core.Provider;
import views.ReportView;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class Main {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
		//** Aca creo la vista
		//devuelvo el string
		//se lo paso por parametro al init core
		String pluginsImplPath = "plugins";
		String US = "US1";
		String pluginImpl = "pluginImpl";

		InitProviderTS initProviderTS = new InitProviderTS();
		Provider provider = initProviderTS.init(new String[]{US, pluginsImplPath});

		ReportView view = new ReportView(provider);
		
}

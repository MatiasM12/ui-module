package main;

import core.InitProviderTS;
import core.Provider;
import views.ReportView;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;


public class Main {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
		//** Aca creo la vista
		//devuelvo el string
		//se lo paso por parametro al init core
		String pluginsImplPath = "Factory";
		String US = "US1";
		String pluginImpl = "PluginWithTimerFactory";

		InitProviderTS initProviderTS = new InitProviderTS();
		Provider provider = initProviderTS.init(new String[]{US,"",pluginsImplPath});

		ReportView view = new ReportView(provider);
	}
		
}

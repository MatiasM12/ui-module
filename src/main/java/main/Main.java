package main;

import coreInicialization.ObservableTSInit;
import core.ObservableTS;
import views.ReportView;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;


public class Main {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
		//** Aca creo la vista
		//devuelvo el string
		//se lo paso por parametro al init core
		String repo = "Repo";
		String US = "US1";
		String plugin = "PluginWithTimer";
		String pluginPath = "plugins";

		ObservableTSInit init = new ObservableTSInit();
		ObservableTS observableTS = init.init(new String[]{repo,US, plugin, pluginPath});
		ReportView view = new ReportView(observableTS);
	}
		
}

package main;

import coreInicialization.Core;
import views.ReportView;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import Interfaces.Observable;

public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
		// ** Aca creo la vista
		// devuelvo el string
		// se lo paso por parametro al init core
		String pluginPath = "plugins";
		String ImplPlugin = "DefaultTS";
		String us = "core-module";
		String url = "MatiasM12";
		Core core = new Core();
		Observable observableTS = core.init(new String[] { url, us, ImplPlugin, pluginPath });
		ReportView view = new ReportView(observableTS, core);

	}
}

package main;

import coreInicialization.Core;
import views.ReportView;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import Interfaces.Observable;
import controllers.TSController;


public class Main {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
		//** Aca creo la vista
		//devuelvo el string
		//se lo paso por parametro al init core
		String pluginPath = "plugins";
    	String ImplPlugin = "TSWithCategories"; 
    	String us = "US1";
    	String url = "url";
		Observable observableTS = new Core().init(new String[] {url,us,ImplPlugin,pluginPath});
		ReportView view = new ReportView(observableTS);

		
	}
}

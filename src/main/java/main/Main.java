package main;

import core.ObservableTS;
import coreInicialization.ObservableInit;
import views.ReportView;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import Interfaces.Observable;


public class Main {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
		//** Aca creo la vista
		//devuelvo el string
		//se lo paso por parametro al init core
		String pluginPath = "plugins";
    	String ImplPlugin = "OriginImp.timerTS";
    	String us = "US1";
    	String url = "url";
		Observable observableTS = new ObservableInit().init(new String[] {url,us,ImplPlugin,pluginPath});
		ReportView view = new ReportView(observableTS);
	}
}

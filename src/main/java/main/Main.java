package main;

import core.InitCore;
import core.Mediador;
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
		String findersImplPath = "plugins";
		String trackerImp = "TrackerHub";
		String url = "www.github.com";
		
		
		ObservableFactory f = new ObservableFactory();
		Observable o = f.createObservable(args[1]);
		ReportView view = new ReportView(o);
		
}

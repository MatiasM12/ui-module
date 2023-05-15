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
		
		ReportView view = new ReportView();
		InitCore initCore = new InitCore(url,findersImplPath);
		Mediador m = initCore.init(trackerImp);
		m.addObserver(view);

 		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				m.newChanges();
			}
		}, new Date(), 5000); 
	}
}

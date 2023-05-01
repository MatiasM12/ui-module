package main;

import core.Core;
import core.InitCore;
import views.ReportView;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import controllers.Controlador;

public class Main {
	static String trackerDirectoryPath = "C:\\Users\\Nicol\\git\\core-module2\\bin\\main\\InterfacesImpl";
	static String trackerImpl = "InterfacesImpl.DefaultReportTracker";
	static String reportDirectoryPath = "reportPath";

	public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
		//** Aca creo la vista
		//devuelvo el string
		//se lo paso por parametro al init core
		ReportView view = new ReportView();
		Controlador c = new Controlador(view);
		
		/*
		while(view.getClickSi()==false) {
			System.out.println("");
			continue;
		};
		System.out.println("Pase");*/
		
		InitCore initCore = new InitCore(trackerDirectoryPath);
		Core core = initCore.init(trackerImpl,reportDirectoryPath);
		core.subscribe(view);

		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				try {
					core.refresh();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		}, new Date(), 5000);
	}
}

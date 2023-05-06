package main;

import core.InitCore;
import core.NewCore;
import core.TestResult;
import views.ReportView;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class Main {
	static String trackerDirectoryPath = "C:\\Users\\Nicol\\git\\core-module2\\bin\\main\\InterfacesImpl";
	static String trackerImpl = "InterfacesImpl.DefaultReportTracker";
	static String reportDirectoryPath = "C:\\Users\\Nicol\\OneDrive\\Escritorio\\Nueva carpeta (2)";
	public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
		//** Aca creo la vista
		//devuelvo el string
		//se lo paso por parametro al init core
		ReportView view = new ReportView();
		InitCore initCore = new InitCore();
		NewCore c = new NewCore();
 		
	}
}

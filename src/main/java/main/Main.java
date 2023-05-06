package main;

import core.InitCore;
import core.NewCore;
import views.ReportView;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;


public class Main {
	static String trackerDirectoryPath = "C:\\Users\\Usuario\\IntelliJ-Workspace\\VALKIRIA\\core-module\\plugins";
	//static String trackerImpl = "InterfacesImpl.DefaultReportTracker";
	//static String reportDirectoryPath = "C:\\Users\\Nicol\\OneDrive\\Escritorio\\Nueva carpeta (2)";
	public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
		ReportView view = new ReportView();
		InitCore initCore = new InitCore();
		NewCore core = initCore.init(trackerDirectoryPath, "", "");
		core.addObserver(view);
	}
}

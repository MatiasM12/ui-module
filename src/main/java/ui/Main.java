package ui;

import java.util.ArrayList;

import Controllers.ReportController;
import Views.ReportView;
import core.Init;
import core.Observer;
import core.Report;
import core.ReportUpdater;

public class Main {

	 public static void main(String[] args) {

		ArrayList<Observer> observers = new ArrayList<Observer>();   	
		Report report = new Report(observers, 100, null);
		ReportUpdater updater = new ReportUpdater(report);
		
		ReportController controller = new ReportController(updater);
		report.addObserver(controller);
		
		ReportView view = new ReportView(controller);
		view.createWindow();
		
		
		//yo creo que esto esta re mal jaja
		Init init = new Init();
		init.checker.addObserver(updater);
		

	 }
}

package main;

import controllers.ReportController;
import core.App;
import views.ReportView;

public class Main {

	 public static void main(String[] args) {

		App pvCore = new App();
		pvCore.initChecker();
		
		ReportView view = new ReportView();
		
		ReportController controller = new ReportController(pvCore.updater,view);
		pvCore.report.addObserver(controller);
		
		view.initWindow();
		
	 }

}

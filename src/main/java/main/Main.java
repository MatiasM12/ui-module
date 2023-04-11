package main;

import controllers.ReportController;
import core.App;
import views.ReportView;

public class Main {

	 public static void main(String[] args) {

		App pv = new App();
		pv.initChecker();
		
		ReportView view = new ReportView();
		
		ReportController controller = new ReportController(pv.updater,view);
		pv.report.addObserver(controller);
		
		view.initWindow();
		
	 }


}

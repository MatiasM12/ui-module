package ui;

import java.util.ArrayList;

import Controllers.ReportController;
import Views.ReportView;
import core.Core;

public class Main {

	 public static void main(String[] args) {

		//yo creo que esto esta re mal jaja
		Core core = new Core();
		core.init();
		
		ReportController controller = new ReportController(core.updater);
		core.report.addObserver(controller);
		
		ReportView view = new ReportView(controller);
		view.createWindow(core);//yo creo que esto esta re mal jaja
		

	 }
}

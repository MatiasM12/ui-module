package main;

import controllers.ReportController;
import core.PvCore;
import core.ReportContainerAssembler;
import core.ReportResultAssembler;
import views.ReportView;

public class Main {

	 public static void main(String[] args) {

		ReportResultAssembler reportAssembler = new ReportResultAssembler();
		ReportContainerAssembler containerAssembler = new ReportContainerAssembler();
		PvCore pv = new PvCore();
		pv.init(reportAssembler, containerAssembler);
		
		ReportView view = new ReportView();
		
		ReportController controller = new ReportController(containerAssembler.container,view);
		
		//le llegue el update
		pv.update();
	 }

}

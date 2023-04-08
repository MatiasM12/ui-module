package Controllers;

import core.Observer;
import core.ReportUpdater;

public class ReportController implements Observer {

	public ReportUpdater updater;
	
	public ReportController(ReportUpdater updater) {
		super();
		this.updater = updater;
	}

	public void updateReport() {
		updater.updateReport();
	}
	
	public void update() {
		System.out.println("actualizo controlador");
	}
}

package controllers;

import core.Observer;
import core.ReportUpdater;
import views.ReportView;

public class ReportController implements Observer {

	public ReportUpdater updater;
	public ReportView view;
	
	public ReportController(ReportUpdater updater, ReportView view) {
		super();
		this.updater = updater;
		this.view = view;
	}

	public void updateReport() {
		updater.updateReport();
	}
	
	public void update() {
		view.refresh(updater.report);
		System.out.println("actualizo controlador");
	}
}

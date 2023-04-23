package controllers;

import java.util.Map;

import core.Observer;
import core.PvCore;
import core.ReportResult;
import views.ReportView;

public class ReportController implements Observer {

	private ReportView view;
	private PvCore core;
	
	public ReportController(ReportView vista, PvCore core){
		this.view = vista;
		this.core = core;

			//5 El controlador se suscribe como Observador del modelo
		this.core.addObserver(this);
	}
 
	@Override //FIXME: 23/04/2023
	public void update() {
		ReportResult reporte = this.core.getReport();
	}
}

package controllers;

import java.util.HashMap;
import java.util.Map;

import core.AcceptanceTest;
import core.Observer;
import core.ReportsContainer;
import views.ReportView;

public class ReportController implements Observer {

	public ReportsContainer container;
	public ReportView view;
	
	public ReportController(ReportsContainer container, ReportView view) {
		super();
		this.container = container;
		this.view = view;
		container.addObserver(this);
	}
 
	@Override
	public void update() {
		Map<String,Boolean> testList = new HashMap<String,Boolean>();
		for(AcceptanceTest test : container.reports.get(0).getTests()) {
		      testList.put(test.testAcceptance,test.result);
		}
		view.setDinamicPanels(testList);
	}
}

package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import Interfaces.Observable;
import Interfaces.Observer;
import Interfaces.TestSummary;
import core.TSResultDefault;
import views.ReportView;

public class TSController implements Observer{

	private ReportView view;
	private Observable observableTS;
	private TestSummary ts; // esto nose s debveria ir aca pero lo puse para probar
	
	public TSController(ReportView view, Observable observableTS){
		this.view = view;
		this.observableTS = observableTS;
		observableTS.addObserver(this);
	}
 

	@Override
	public void update(TestSummary ts) {
		this.ts = ts;// para probar tambien
		
	}
	
	public Map<String,Boolean> applyFilter(String category) { 
		Map<String, Boolean> filteredMap = new HashMap<>();
		Map<String,Boolean> ca =((TSResultDefault)ts).getCA();
		if(category == "Todos") return ca;
		List<String> keys = ((TSResultDefault)ts).getCAsByCategory(category);
        filteredMap.putAll(ca);
        filteredMap.keySet().retainAll(keys);
		return filteredMap;
	}

	public Set<String> getCategories() {
		if(((TSResultDefault) ts).getListOfCategories() != null) return (((TSResultDefault)ts).getListOfCategories());
		return null;
	}

	public String getUS() {
		return ((TSResultDefault)ts).getUS();
	}
	
	
}

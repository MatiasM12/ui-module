package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		//aca deberia aplicar el filtro, esta mal solo lo hice apra probar
		if(selectedFilter() == "Todos") return ((TSResultDefault)ts).getCA();
		Map<String,String> categories =((TSResultDefault)ts).getAllCategories();
		List<String> keys = new ArrayList<>();
        for (String key : categories.keySet()) {
            if (categories.get(key).equals(category)) {
                keys.add(key);
            }
        }
        Map<String,Boolean> ca =((TSResultDefault)ts).getCA();
        Map<String, Boolean> filteredMap = new HashMap<>();
        for (String key : keys) {
            if (ca.containsKey(key)) {
                filteredMap.put(key, ca.get(key));
            }
        }
        view.removeElementsOfPanel();
        
        view.lblNewLabel.setText(((TSResultDefault)ts).getUS());
		if(getCategories(ts) != null ) view.setFilters(getCategories(ts));
		view.setDinamicPanels(filteredMap);
		return filteredMap;
	}

	private String selectedFilter() {
	    if (view.comboBox.getSelectedItem() != null) return view.comboBox.getSelectedItem().toString();
	    return "";
	}
	
	

	public ArrayList<String> getCategories(TestSummary ts) {
		if(((TSResultDefault) ts).getAllCategories() != null) return new ArrayList<String>(((TSResultDefault)ts).getAllCategories().values());
		return null;
	}
	
	
}

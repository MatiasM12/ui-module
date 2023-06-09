package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import Interfaces.Observable;
import Interfaces.Observer;
import Interfaces.TestSummary;
import core.TSResultDefault;
import coreInicialization.Core;
import views.ReportView;

public class TSController implements Observer{

	private ReportView view;
	private Observable observableTS;
	private TestSummary ts; // esto nose s debveria ir aca pero lo puse para probar
	private Core core;
	
	public TSController(ReportView view, Observable observableTS, Core core){
		this.view = view;
		this.observableTS = observableTS;
		observableTS.addObserver(this);
		this.core = core;
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
//		if(((TSResultDefault) ts).getListOfCategories() != null) return (((TSResultDefault)ts).getListOfCategories());
//		return null;
		return (((TSResultDefault)ts).getListOfCategories());
	}

	public String getUS() {
		return ((TSResultDefault)ts).getUS();
	}
	
	public String[] getPlugins() {
		return core.getImplementationNames();
	}
	
	//fixme El repo no deberia estar harcodeado
	public Boolean changePlugin(String selectedPlugin) throws FileNotFoundException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
		return core.initImplementation(selectedPlugin, "", ((TSResultDefault)ts).getUS()).isSuccess();
	}
	
	
}

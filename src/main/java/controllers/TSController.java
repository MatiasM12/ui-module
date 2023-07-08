package controllers;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import Interfaces.Observable;
import Interfaces.Observer;
import Interfaces.TestSummary;
import core.TSResultDefault;
import coreInicialization.Core;

public class TSController implements Observer {

	private TestSummary ts; 
	private Core core;

	public TSController(Observable observableTS, Core core) {
		observableTS.addObserver(this);
		this.core = core;
	}

	@Override
	public void update(TestSummary ts) {
		this.ts = ts;
	}

	public Map<String, Boolean> applyFilter(String category) {
		Map<String, Boolean> filteredMap = new HashMap<>();
		Map<String, Boolean> ca = ((TSResultDefault) ts).getCA();
		if (category == "Todos")
			return ca;
		List<String> keys = ((TSResultDefault) ts).getCAsByCategory(category);
		filteredMap.putAll(ca);
		filteredMap.keySet().retainAll(keys);
		return filteredMap;
	}

	public Set<String> getCategories() {
		return (((TSResultDefault) ts).getListOfCategories());
	}

	public String getUS() {
		return ((TSResultDefault) ts).getUS();
	}

	public String[] getPlugins() {
		return core.getImplementationNames();
	}

	// fixme El repo no deberia estar harcodeado
	public String changePlugin(String selectedPlugin,String us) throws FileNotFoundException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
		return core.initImplementation(selectedPlugin, "",us).responseMsg;
	}

}

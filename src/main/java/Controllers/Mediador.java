package Controllers;

import Views.BotonTest;
import Views.PvViews;
import Views.Vista;
import core.Acceptance_test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class Mediador implements Observer {
	PvViews vista1;
	Acceptance_test repoTestFinder;
    public Mediador(PvViews pvViews, Acceptance_test coreX) {
        this.vista1 = pvViews;
        this.repoTestFinder = coreX;
        this.vista1.initialize(this,coreX);
        this.vista1.suscribirseAlCore();
        this.suscribirseAlCore();
        this.activarListeners();
       // coreX.notification();
    }

    private void suscribirseAlCore(){
        this.repoTestFinder.attach(this);
    }

    @Override
    public void update(Observable o, Object arg) {
    	if((char)arg=='A') {
    		String elementosVista = this.repoTestFinder.getUS()+"\n"
    				+this.repoTestFinder.getPackage()+"\n"
    				+this.repoTestFinder.getClasses()+"\n"
    				+this.repoTestFinder.getSuccesRate()+"\n"
    				+this.repoTestFinder.getFailures()+"\n"
    				+this.repoTestFinder.getIgnored()+"\n"
    				+this.repoTestFinder.getTestQuantity()+"\n";
    			//	+this.repoTestFinder.getValidationTest();
    		vista1.setJTextArea(elementosVista);
    	}
    }
    public void activarListeners() {
    	System.out.println("sad");
    	this.vista1.getBtn().addActionListener(new BotonTest(this));
    }
    
    
    
    public void buscarTest() {
    	this.repoTestFinder.buscarTest();
    	
    }
    
}

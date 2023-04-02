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
    	
    }
    
    
    public void activarListeners() {
    	System.out.println("sad");
    	this.vista1.getBtn().addActionListener(new BotonTest(this.repoTestFinder));
    }
}

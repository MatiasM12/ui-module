package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import views.ListenerBtn;
import views.ReportView;

public class Controlador{
	
	
	ReportView view;
	
	public Controlador(ReportView r) {
		this.view = r;
		this.activarListeners();
		
	}
	
	 public void activarListeners() {
	    	System.out.println("sad");
	    	this.view.getBtn().addActionListener(new ListenerBtn(this.view));
	    }
	
	
	
	
	
	
	
	
}

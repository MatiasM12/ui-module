package Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controllers.Mediador;
import core.Report;

public class BotonTest implements ActionListener {

	Mediador modelo;
	
	public BotonTest(Mediador modelo){
		this.modelo = modelo;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e);
		this.modelo.buscarTest();
	}

}

package Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import core.Acceptance_test;

public class BotonTest implements ActionListener {

	Acceptance_test modelo;
	
	public BotonTest(Acceptance_test modelo){
		this.modelo = modelo;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e);
		this.modelo.buscarTest();
	}

}

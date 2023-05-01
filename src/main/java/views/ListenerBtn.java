package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerBtn implements ActionListener {
 
	ReportView v;
	
	public ListenerBtn(ReportView view) {
		this.v = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.v.ocultarPantalla();
		this.v.setBtnTrue();
		
	}

	
}

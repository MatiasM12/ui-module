package Views;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Controllers.Mediador;
import core.Acceptance_test;
import core.RepoTestFinder;

public class PvViews  implements Observer{

	private JFrame frame;
	protected Mediador controller;
    protected Acceptance_test  repoTestFinder;
    JTextArea textfield1;
    JButton btn;
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the application.
	 */
	public PvViews() {
		
	}

	public void initialize(Mediador controller,Acceptance_test  repoTestFinder) {
		this.controller = controller;
		this.repoTestFinder = repoTestFinder;
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 500);	
		textfield1=new JTextArea();
		textfield1.setBounds(50,10,0,0);
		btn = new JButton();
		
		btn.setBounds(0,400,450,100);
		
		frame.add(btn);
		frame.add(textfield1);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
		
		
	//	this.frame.setVisible(true);
	}
	
	public void suscribirseAlCore(){
	        this.repoTestFinder.attach(this);
	}
	public void update(Observable o, Object arg) {
		
		
	}

	
	public JButton getBtn() {
		return this.btn;
	}
	
	public void setJTextArea(String texto) {
		this.textfield1.setText(texto);
	}
	
	
	
	
	


}

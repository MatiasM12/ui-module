package Views;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Controllers.ReportController;
import core.Core;

import java.awt.Container;

public class ReportView extends JFrame {

	private static final long serialVersionUID = 1L;
    public ReportController controller;

    public ReportView(ReportController controller) {
        this.controller = controller;
    }

    public void notifyController() {
    	controller.updateReport();
    }
	
	public void createWindow(Core core) {
		setTitle("Proyecto Valquiria");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JButton btnStart;
        btnStart = new JButton("Iniciar");
        btnStart.setBounds(150, 100, 100, 30);
        
        JLabel labelTest = new JLabel("Test aprobado");
        labelTest.setVisible(false);
        
        add(btnStart);
        add(labelTest);
        
        btnStart.addActionListener(e -> {
            System.out.println("¡Botón Iniciar presionado!");
            btnStart.setVisible(false);
            labelTest.setVisible(true);
            core.initChecker();//yo creo que esto esta re mal jaja
            notifyController();
        });
        
        setVisible(true);
	}
	
	public void displayReport() {
		
	}
}

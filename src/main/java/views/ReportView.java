package views;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import core.Report;


public class ReportView extends JFrame  {

	private static final long serialVersionUID = 1L;
    public JLabel labelTest;
	
    public ReportView() {
    }
    
    public void refresh(Report newReport) {
    	labelTest.setText("Test 2 = aprobado");
    	repaint();
    }

	public void initWindow() {
		setTitle("Proyecto Valquiria");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        labelTest = createLabel();
        add(labelTest);
        labelTest.setHorizontalAlignment(SwingConstants.CENTER);
        
        setVisible(true);
	}

	public JLabel createLabel() {
		labelTest = new JLabel("Test 1 = aprobado");
		return labelTest;
	}
	
	public void displayReport() {
		
	}


}

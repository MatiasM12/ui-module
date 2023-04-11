package views;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import core.Report;

public class ReportView extends JFrame  {

	private static final long serialVersionUID = 1L;
	public JLabel labelSuccessRate;
    public JLabel labelTest;
	
    public ReportView() {
    }
    
    public void refresh(Report newReport) {
    	labelSuccessRate.setText(String.valueOf(newReport.successRate)+"%");
    	labelTest.setText(newReport.testList.toString());
    	repaint();
    }

	public void initWindow() {
		setTitle("Proyecto Valquiria");
        setSize(600, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        labelSuccessRate = createLabel(labelSuccessRate,"100 %");
        labelTest = createLabel(labelTest,"Name = Test 1, SuccessRate = true");
        
        add(labelSuccessRate);
        add(labelTest);
        
        labelTest.setBounds(0, 250, 300, 50);
        labelSuccessRate.setBounds(140, 150, 300, 50);
        labelTest.setHorizontalAlignment(SwingConstants.CENTER);
        labelSuccessRate.setHorizontalAlignment(SwingConstants.CENTER);
        
        setVisible(true);
	}

	public JLabel createLabel(JLabel label,String text) {
		label = new JLabel(text);
		return label;
	}

}

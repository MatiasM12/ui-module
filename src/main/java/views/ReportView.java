package views;

import java.awt.EventQueue;
import java.awt.Image;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.util.Set;
import javax.swing.border.LineBorder;

import core.Observer;
import core.TestResult;
//import core.ReportResult;
import javax.swing.JTextField;
import javax.swing.JButton;



public class ReportView implements Observer {

	private JFrame frame;
	private JLabel titulo;

	

	public ReportView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		ImageIcon icon = new ImageIcon("icon.png");
		Image image = icon.getImage();
		frame.setIconImage(image);
		frame.setTitle("Proyecto Valquiria");
		frame.setBounds(700, 300, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		titulo = new JLabel("");
		titulo.setBounds(10, 11, 352, 14);
		frame.getContentPane().add(titulo);
		this.frame.setVisible(true);			
	
	}
	public void  setDinamicPanels(Set<TestResult> testResultSet){
		Iterator<TestResult> it = testResultSet.iterator();
		int i = 0;
		while(it.hasNext()){
			TestResult testResult = it.next();
			
			JPanel panel = new JPanel();
			panel.setBounds(10, 50*(i+1), 404, 36);
			panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			frame.getContentPane().add(panel);
			panel.setLayout(null);
			
			JLabel tituloCritero = new JLabel("CA "+(i+1)+" : "+testResult.name);
			tituloCritero.setBounds(0, 0, 217, 14);
			panel.add(tituloCritero);
			
			JPanel panel_1 = new JPanel();
		
			if(testResult.result)
				panel_1.setBackground(Color.GREEN);
			else
				panel_1.setBackground(Color.RED);
			panel_1.setBounds(384, 0, 20, 36);
			panel.add(panel_1);
			
			panel_1.repaint();
            panel.repaint();
			
			i++;
		}
		
	}
	public void setTitle(String title) {
		
		titulo = new JLabel("");
		titulo.setBounds(10, 11, 352, 14);
		frame.getContentPane().add(titulo);
		this.titulo.setText(title);
		
	}
	@Override
	public void update(Object object) {
		this.eliminarElementosPanel();
		Set<TestResult> r = (Set<TestResult>) object;
		this.setTitle("Hola");
		this.setDinamicPanels(r);
	}
	
	public void eliminarElementosPanel() {
		frame.getContentPane().removeAll();
		frame.repaint();
	}
	

	

	
	
	
	
	
	
	
}
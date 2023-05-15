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
import javax.swing.border.LineBorder;

import core.Observer;
import javax.swing.JTextField;
import javax.swing.JButton;



public class ReportView implements Observer {

	private JFrame frame;

	

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
		this.frame.setVisible(true);			
	
	}
	public void  setDinamicPanels(Map<String,String> test){
		Iterator<String> it = test.keySet().iterator();
		int i = 0;
		while(it.hasNext()){
			String key = it.next();
			
			JPanel panel = new JPanel();
			panel.setBounds(10, 50*(i+1), 404, 36);
			panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			frame.getContentPane().add(panel);
			panel.setLayout(null);
			
			JLabel tituloCritero = new JLabel(key);
			tituloCritero.setBounds(0, 0, 217, 14);
			panel.add(tituloCritero);
			
			JPanel panel_1 = new JPanel();
		
			if(test.get(key).equals("PASS"))
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
	@Override
	public void update(Object object) {
		this.eliminarElementosPanel();
		Map <String,String> map= (HashMap<String,String>) object;
		this.setDinamicPanels(map);
	}
	
	public void eliminarElementosPanel() {
		frame.getContentPane().removeAll();
		frame.repaint();
	}
	

	

	
	
	
	
	
	
	
}
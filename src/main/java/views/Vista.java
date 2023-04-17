package views;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class Vista {

	private JFrame frame;
	private JLabel titulo;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista window = new Vista();			
					window.setTitle("USER STORY, ACTUALIZACION DE REPORTES");
					ArrayList<String> arr = new ArrayList<String>();
					arr.add("Criterio 1 Iniciar Core ");
					arr.add("Criterio 2 Buscar Reporte nuevo");
					arr.add("Criterio 3 Crear Reporte ");
					arr.add("Criterio 4 Devolver Reporte");
					window.setDinamicPanels(arr, arr.size());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Vista() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		titulo = new JLabel("User Story");
		titulo.setBounds(10, 11, 112, 14);
		frame.getContentPane().add(titulo);
		this.frame.setVisible(true);
	}

	
	
	public void  setDinamicPanels(ArrayList<String> tituloCriterio, int z){
		for(int i =0; i<z;i++){
			
			JPanel panel = new JPanel();
			panel.setBounds(10, 50*(i+1), 404, 36);
			panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			frame.getContentPane().add(panel);
			panel.setLayout(null);
			
			JLabel tituloCritero = new JLabel(tituloCriterio.get(i));
			tituloCritero.setBounds(0, 0, 117, 14);
			panel.add(tituloCritero);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(Color.GREEN);
			panel_1.setBounds(384, 0, 20, 36);
			panel.add(panel_1);
		}
		
	}
	
	
	public void setTitle(String title) {
		this.titulo.setText(title);
		
	}
	
	
	
}

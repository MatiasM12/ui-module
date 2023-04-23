package views;

import controllers.ReportController;
import core.Observer;
import core.PvCore;

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

public class ReportView implements Observer {

	private JFrame frame;
	private JLabel titulo;

	private ReportController controlador;
	

	public ReportView(PvCore core) {
			//3 La vista se suscribe como observador del modelo (attach).
		core.addObserver(this);

			//4 La vista crea el controlador, pasandose como referencia a si mismo y al modelo
		this.controlador = new ReportController(this, core);


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
					
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {		
					setTitle("User Story: Actualizacion de reportes");
					Map<String,Boolean> map = new HashMap<String,Boolean>();
					map.put("Iniciar Core", true);
					map.put("Buscar Reporte nuevo", true);
					map.put("Crear Reporte ", true);
					map.put("Devolver Reporte", true);
					setDinamicPanels(map);
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
		});
	}

	
	
	public void  setDinamicPanels(Map<String,Boolean> test){
		Iterator<String> it = test.keySet().iterator();
		int i = 0;
		while(it.hasNext()){
			String key = it.next();
			
			JPanel panel = new JPanel();
			panel.setBounds(10, 50*(i+1), 404, 36);
			panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			frame.getContentPane().add(panel);
			panel.setLayout(null);
			
			JLabel tituloCritero = new JLabel("CA "+(i+1)+" : "+key);
			tituloCritero.setBounds(0, 0, 217, 14);
			panel.add(tituloCritero);
			
			JPanel panel_1 = new JPanel();
		
			if(test.get(key) == true)
				panel_1.setBackground(Color.GREEN);
			else
				panel_1.setBackground(Color.RED);
			panel_1.setBounds(384, 0, 20, 36);
			panel.add(panel_1);
			
			i++;
		}
		
	}
	
	
	public void setTitle(String title) {
		this.titulo.setText(title);
		
	}


	@Override
	public void update() {
		//traer datos de reporte
		System.out.println("Soy la ventana de la UI ejecutando update()");
	}
}
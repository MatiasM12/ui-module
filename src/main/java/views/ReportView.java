package views;

import java.awt.Image;
import java.util.Iterator;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;

import core.TSResultDefault;
import Interfaces.Observable;
import Interfaces.Observer;
import Interfaces.TestSummary;
import java.awt.Font;

public class ReportView implements Observer {

	private JFrame frame;
	private JLabel lblNewLabel;

	public ReportView(Observable observable) {
		initialize();
		observable.addObserver(this);
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
		frame.setBounds(700, 300, 445, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 11, 107, 22);
		frame.getContentPane().add(lblNewLabel);
		this.frame.setVisible(true);

	}

	public void setDinamicPanels(Map<String, Boolean> test) {
		Iterator<String> it = test.keySet().iterator();
		int i = 0;
		while (it.hasNext()) {
			String key = it.next();

			JPanel panel = new JPanel();
			panel.setBounds(10, 50 * (i + 1), 404, 36);
			panel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
			frame.getContentPane().add(panel);
			panel.setLayout(null);

			JLabel tituloCritero = new JLabel(key);
			tituloCritero.setBounds(10, 10, 217, 14);
			panel.add(tituloCritero);

			JPanel panel_1 = new JPanel();

			if (test.get(key))
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

	public void removePanelElemnts() {
		frame.getContentPane().removeAll();
		frame.repaint();
	}

	@Override
	public void update(TestSummary ts) {
		lblNewLabel.setText(((TSResultDefault) ts).getUS());
		this.setDinamicPanels(((TSResultDefault) ts).getCA());
	}
}

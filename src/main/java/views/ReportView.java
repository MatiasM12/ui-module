package views;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;

import core.TSResultDefault;
import coreInicialization.Core;
import Interfaces.Observable;
import Interfaces.Observer;
import Interfaces.TestSummary;
import controllers.TSController;

import java.awt.Font;

public class ReportView implements Observer {

	public JFrame frame;
	public JLabel lblNewLabel;
	public JComboBox<Object> comboBox,comboBox_Plugins;
	private TSController controller;
	private JPanel panel_1, panel;

	public ReportView(Observable observable, Core core) {
		this.controller = new TSController(observable, core);
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
		frame.setBounds(700, 300, 442, 390);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 11, 107, 22);
		frame.getContentPane().add(lblNewLabel);

		comboBox = new JComboBox<>();
		comboBox.setBounds(300, 15, 110, 22);
		frame.getContentPane().add(comboBox);
		comboBox.addActionListener(new ActionListener() {
			Boolean flag = true;

			@Override
			public void actionPerformed(ActionEvent e) {
				if (flag) {
					flag = false;
				} else {
					String selectedItem = (String) comboBox.getSelectedItem();
					applyFilter(selectedItem);
					comboBox.setSelectedItem(selectedItem);
				}
			}
		});

		comboBox_Plugins = new JComboBox<>();
		comboBox_Plugins.setBounds(166, 13, 130, 27);
		frame.getContentPane().add(comboBox_Plugins);
		comboBox_Plugins.addActionListener(new ActionListener() {
			Boolean flag = true;
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedItem = (String) comboBox_Plugins.getSelectedItem();
				try {
					if (flag)
						flag = false;
					else {
						Boolean b = controller.changePlugin(selectedItem);
						if (b == false) {
							JOptionPane.showMessageDialog(null,
									"Hubo un error en la conexion, se reflejan los ultimos resultados obtenidos.");
						} else
							comboBox_Plugins.setSelectedItem(selectedItem);
					}
				} catch (FileNotFoundException | ClassNotFoundException | InvocationTargetException
						| InstantiationException | IllegalAccessException | NoSuchMethodException e1) {
					e1.printStackTrace();
				}
			}
		});
		this.frame.setVisible(true);
	}

	public void setDinamicPanels(Map<String, Boolean> test) {
		Iterator<String> it = test.keySet().iterator();
		int i = 0;
		while (it.hasNext()) {
			String key = it.next();

			panel = new JPanel();
			panel.setBounds(10, 50 * (i + 1), 404, 36);
			panel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
			frame.getContentPane().add(panel);
			panel.setLayout(null);

			JLabel tituloCritero = new JLabel(key);
			tituloCritero.setBounds(10, 10, 217, 14);
			panel.add(tituloCritero);

			panel_1 = new JPanel();

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

	public void setFilters(Set<String> valuesList) {
		comboBox.removeAllItems();
		comboBox.addItem("Todos");
		for (String key : valuesList) {
			comboBox.addItem(key);
		}
	}

	public void setPlugins(String[] valuesList) {
		comboBox_Plugins.removeAllItems();
		for (String key : valuesList) {
			comboBox_Plugins.addItem(key);
		}
	}

	public void applyFilter(String selectedItem) {
		Map<String, Boolean> filter = controller.applyFilter(selectedItem);
		updatePane(filter);
	}

	private void updatePane(Map<String, Boolean> tests) {
		removeElementsOfPanel();
		setDinamicPanels(tests);
		setUs(getUS());
		frame.getContentPane().add(comboBox_Plugins);
		frame.getContentPane().add(comboBox);
		frame.getContentPane().add(lblNewLabel);
		frame.repaint();
	}

	public void removeElementsOfPanel() {
		frame.getContentPane().removeAll();
	}

	@Override
	public void update(TestSummary ts) {

		setPlugins(controller.getPlugins());
		setFilters(controller.getCategories());
		updatePane(((TSResultDefault) ts).getCA());

	}

	public void setUs(String string) {
		lblNewLabel.setText(string);
	}

	public String getUS() {
		return controller.getUS();
	}
}

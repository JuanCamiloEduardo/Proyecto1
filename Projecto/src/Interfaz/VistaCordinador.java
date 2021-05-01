package Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class VistaCordinador extends JFrame {

	private JPanel contentPane;
	private JTextField textField;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaCordinador frame = new VistaCordinador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public VistaCordinador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(21, 26, 319, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(92, 23, 307, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Cargar Informacion Banner ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(102, 62, 239, 32);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Estudiantes a cargo:");
		lblNewLabel_1.setBounds(21, 105, 122, 25);
		contentPane.add(lblNewLabel_1);
		String [] queries = {"Nombre","Nombre","Nombre","Nombre","Nombre","Nombre","Nombre","Nombre","Nombre","Nombre","Nombre","Nombre","Nombre","Nombre","Nombre","Nombre","Nombre" };
		JList list = new JList(queries);
		list.setBounds(31, 129, 368, 98);
		contentPane.add(list);
		
	}
}

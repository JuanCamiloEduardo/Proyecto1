package Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Menu extends JFrame implements ActionListener {
	private JPanel contentPane;
	private static Menu frame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tipo de Usuario");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 43));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(67, 33, 300, 119);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Estudiante");
		btnNewButton.setBounds(77, 163, 138, 41);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(this);
		btnNewButton.setActionCommand("Estudiante");
		
		JButton btnNewButton_1 = new JButton("Cordinador");
		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setActionCommand("Cordinador");

		btnNewButton_1.setBounds(260, 163, 138, 39);
		contentPane.add(btnNewButton_1);
	}
	
	public void actionPerformed(ActionEvent pEvento) 
	{
		String comando = pEvento.getActionCommand( );
		if (comando.equals("Estudiante")) {
		VentanaEstudiante est=new VentanaEstudiante();
		est.setVisible(true);
		frame.setVisible(false);}
		
		else if (comando.equals("Cordinador")) {
			vistaCoordinador cord=new vistaCoordinador();
			cord.setVisible(true);
			frame.setVisible(false);}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

package Interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OpcionesNorteCord extends JPanel implements ActionListener
{
	private JLabel Nombre;
	private JTextField Campo;
	private JButton Grado;
	public OpcionesNorteCord() {
		setLayout(new GridLayout(1,3));
		
		Nombre=new JLabel("Nombre");
		Campo= new JTextField ();
		Grado= new JButton("CargarInfoBanner");
		Grado.addActionListener(this);
		Grado.setActionCommand("CBanner");
		add(Nombre);
		add(Campo);
		add(Grado);
	}
	public void actionPerformed(ActionEvent pEvento) 
	{
	
	}
	
}
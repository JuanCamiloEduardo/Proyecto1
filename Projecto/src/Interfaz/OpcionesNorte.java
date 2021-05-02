package Interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Consola.Consola;
import Sistema.Estudiante;


public class OpcionesNorte extends JPanel implements ActionListener
{
	private JLabel Nombre;
	private JTextField Campo;
	private JButton Grado;
	public OpcionesNorte() 
	{

		setLayout(new GridLayout(1,3));
		
		Nombre=new JLabel("Nombre");
		Campo= new JTextField ();
		Grado= new JButton("Grado");
		Grado.addActionListener(this);
		Grado.setActionCommand("BGrado");
		add(Nombre);
		add(Campo);
		add(Grado);
	}
	public void actionPerformed(ActionEvent pEvento) 
	{	
		ArrayList<String> Cambio=new ArrayList<String>();
		 Cambio=Consola.SoyCandidato();

		VentanaE NuevaVentana= new VentanaE(Cambio);
		
		NuevaVentana.setVisible(true);
		
	}
	
}

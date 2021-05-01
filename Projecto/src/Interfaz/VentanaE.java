package Interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class VentanaE extends JDialog {
	private JLabel Graduarse;
	private JTextField Puede;
	private JLabel RequisitosCumplidos;
	private JList ListaCumplidos;
	private JLabel RequisitosFaltantes;
	private JList ListaFaltantes;

	
	public VentanaE () 
	{
		setSize(700,400);
		setLocationRelativeTo(null);
		setTitle("Requisitos Grado");
		setLayout(new GridLayout(3,2));
		String [] queries = {"Nombre","Nombre","Nombre","Nombre","Nombre","Nombre","Nombre","Nombre","Nombre","Nombre","Nombre","Nombre","Nombre","Nombre","Nombre","Nombre","Nombre" };
		ListaCumplidos= new JList(queries);
		JScrollPane jsp = new JScrollPane(ListaCumplidos);
		RequisitosCumplidos=new JLabel("Requisitos Cumplidos");
		Graduarse=new JLabel("Puede Graduarse");
		Puede=new JTextField();
		String [] fal = {"Nombre","Nombre","Nombre","Nombre","Nombre" ,"Nombre","Nombre","Nombre","Nombre","Nombre","Nombre","Nombre","Nombre","Nombre","Nombre","Nombre"};
		ListaFaltantes= new JList(fal);
		JScrollPane ListaFaltantes2 = new JScrollPane(ListaFaltantes);

		RequisitosFaltantes=new JLabel("Requsitos por Cumplir");
		add(Graduarse);
		add(Puede);
		add(RequisitosCumplidos);
		add(RequisitosFaltantes);
		add(jsp);
		add(ListaFaltantes2);


	}
	
}

package Interfaz;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class VentanaE extends JDialog {
	private JLabel Graduarse;
	private JTextField Puede;
	private JList ListaCumplidos;
	private JLabel RequisitosFaltantes;
	private JList ListaFaltantes;

	
	public VentanaE () 
	{
		setSize(700,400);
		setLocationRelativeTo(null);
		setTitle("Requisitos Grado");
		setLayout(new GridLayout(2,1));
		String [] queries = {"Nombre","Nombre","Nombre","Nombre","Nombre","Nombre","Nombre","Nombre","Nombre","Nombre","Nombre","Nombre","Nombre","Nombre","Nombre","Nombre","Nombre" };
		ListaCumplidos= new JList(queries);
		JScrollPane jsp = new JScrollPane(ListaCumplidos);
		Graduarse=new JLabel("Puede Graduarse");
		Puede=new JTextField();
		String [] fal = {"Nombre","Nombre","Nombre","Nombre","Nombre" ,"Nombre","Nombre","Nombre","Nombre","Nombre","Nombre","Nombre","Nombre","Nombre","Nombre","Nombre"};
		ListaFaltantes= new JList(fal);
		JScrollPane ListaFaltantes2 = new JScrollPane(ListaFaltantes);

		RequisitosFaltantes=new JLabel("Requsitos Faltantes/Cumplidos");
		add(Graduarse);
		add(Puede);
		add(RequisitosFaltantes);
		add(jsp);



	}
	
}

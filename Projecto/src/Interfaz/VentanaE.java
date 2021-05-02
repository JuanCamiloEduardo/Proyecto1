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
	private JLabel RequisitosFaltantes;
	private JList ListaFaltantes;

	public JList getListaCumplidaos(){
		return ListaFaltantes;
	}
	public VentanaE (String[] Lista) 
	{
		setSize(700,400);
		setLocationRelativeTo(null);
		setTitle("Requisitos Grado");
		ListaFaltantes= new JList(Lista);
		setLayout(new GridLayout(2,1));
		JScrollPane jsp = new JScrollPane(ListaFaltantes);
		Graduarse=new JLabel("Puede Graduarse");
		Puede=new JTextField();
		

		RequisitosFaltantes=new JLabel("Requsitos Faltantes/Cumplidos");
		add(Graduarse);
		add(Puede);
		add(RequisitosFaltantes);
		add(jsp);



	}
	
}

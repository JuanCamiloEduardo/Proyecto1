package Interfaz;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class VentanaE extends JDialog {
	private JLabel Graduarse;
	private JLabel Puede;
	private JLabel RequisitosFaltantes;
	private JList ListaFaltantes;

	public JList getListaCumplidaos(){
		return ListaFaltantes;
	}
	public VentanaE (ArrayList<String> Cambio,String Nombre) 
	{
		setSize(700,400);
		setLocationRelativeTo(null);
		setTitle("Requisitos Grado");
		String Ultimo=Cambio.get(Cambio.size()-1);
		Cambio.remove(Cambio.size()-1);
		String[] Lista=Cambio.toArray(new String[Cambio.size()]);
		ListaFaltantes= new JList(Lista);
		setLayout(new GridLayout(2,1));
		JScrollPane jsp = new JScrollPane(ListaFaltantes);
		Graduarse=new JLabel("Puede Graduarse");
		Puede=new JLabel("EL estudiante"+" "+Nombre+" "+Ultimo);
		

		RequisitosFaltantes=new JLabel("Requisitos Faltantes/Cumplidos");
		add(Graduarse);
		add(Puede);
		add(RequisitosFaltantes);
		add(jsp);
		


	}
	
}
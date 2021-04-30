package Interfaz;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

public class OpcionesEste extends JPanel {
	private JLabel MateriasPlaneadas;
	private JList ListaPlaneadas;
	public OpcionesEste()
	{
		setLayout(new GridLayout(2,1));
		String [] queries = {"Nombre","Nombre","Nombre","Nombre","Nombre" };
		ListaPlaneadas= new JList(queries);
		MateriasPlaneadas=new JLabel("Materias Planeadas");
		add(MateriasPlaneadas);
		add(ListaPlaneadas);
		
	}

}

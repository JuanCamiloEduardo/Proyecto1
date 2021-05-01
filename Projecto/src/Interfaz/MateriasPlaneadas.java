package Interfaz;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class MateriasPlaneadas extends JPanel {

	private JList ListaPlaneadas;
	public MateriasPlaneadas()
	{
		setLayout(new GridLayout(2,1));
		String [] queries = {"Nombre","Nombre","Nombre","Nombre","Nombre","Nombre","Nombre","Nombre","Nombre","Nombre" };
		
		ListaPlaneadas= new JList(queries);
		Dimension dimension = ListaPlaneadas.getPreferredSize();
		JScrollPane jsp = new JScrollPane(ListaPlaneadas);
		jsp.setPreferredSize(dimension);

		JLabel MateriasPlaneadas = new JLabel("Materias Planeadas");
		add(MateriasPlaneadas);
		add(jsp);
		
	}
	
}

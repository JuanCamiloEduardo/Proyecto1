package Interfaz;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Consola.Consola;
import Sistema.Estudiante;
import Sistema.InformacionMateria;
import Sistema.Pensum;

public class MateriasVistas extends JPanel {
	
	private JList ListaPlaneadas;
	private DefaultListModel model= new DefaultListModel();
	private int uno = 1;
	private String largo;

	public MateriasVistas() 
	{
		
		setLayout(new GridLayout(2, 1));
		/*
		 * String [] queries =
		 * {"Nombre","Nombre","Nombre","Nombre","Nombre","Nombre","Nombre","Nombre",
		 * "Nombre","Nombre" };
		 */
		ListaPlaneadas = new JList(model);
		Dimension dimension = ListaPlaneadas.getPreferredSize();
		JScrollPane jsp = new JScrollPane(ListaPlaneadas);
		jsp.setPreferredSize(dimension);

		JLabel MateriasPlaneadas = new JLabel("Materias Vistas");
		add(MateriasPlaneadas);
		add(jsp);

	}
	


	public void Actualizar(String Union) {
		Consola c = new Consola();
		c.CrearPensum();
		Pensum materias = c.getSistemas();
		if(uno==1)
		{
			uno=2;
			largo=Union;
		}
		else if(uno!=1)
		{
			largo=largo+","+Union;
		}
		c.CodigoMaterias(largo);
		Estudiante Informacion = c.getAlumno();
		ArrayList<InformacionMateria> Materias = Informacion.getMateriasPasadas();
		int tamano = Materias.size();
		InformacionMateria Info = Materias.get(tamano - 1);
		String Nombre = Info.getNombre();
		DefaultListModel model=(DefaultListModel) ListaPlaneadas.getModel();
		model.addElement(Nombre);
		}
		
	}


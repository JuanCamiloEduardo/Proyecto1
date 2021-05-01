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

	public MateriasVistas() 
	{
		
		setLayout(new GridLayout(2, 1));
		/*
		 * String [] queries =
		 * {"Nombre","Nombre","Nombre","Nombre","Nombre","Nombre","Nombre","Nombre",
		 * "Nombre","Nombre" };
		 */
		
		model.addElement("Nombre");
		model.addElement("Nombre");
		model.addElement("Nombre");
		model.addElement("Nombre");
		model.addElement("Nombre");
		model.addElement("Nombre");
		model.addElement("Nombre");
		ListaPlaneadas = new JList(model);
		Dimension dimension = ListaPlaneadas.getPreferredSize();
		JScrollPane jsp = new JScrollPane(ListaPlaneadas);
		jsp.setPreferredSize(dimension);

		JLabel MateriasPlaneadas = new JLabel("Materias Vistas");
		add(MateriasPlaneadas);
		add(jsp);

	}
	
	//Jhan carlos---------------------------------------
	//this methos show the Jlist empty when the program is initialize
	public DefaultListModel cleanJList() 
	{
		
		DefaultListModel modelo = new DefaultListModel();
		ListaPlaneadas.setModel(modelo);
		return modelo; 
	}
	//------------------------------

	public void Actualizar(String Union) {
		Consola c = new Consola();
		if (uno == 1) {
			uno = 2;
			c.CrearPensum();
			Pensum materias = c.getSistemas();
			c.CodigoMaterias(materias, Union);
		} else if (uno != 1) {
			Pensum materias = c.getSistemas();
			c.ActualizarAlumno(materias, Union);
		}
		Estudiante Informacion = c.getAlumno();
		ArrayList<InformacionMateria> Materias = Informacion.getMateriasPasadas();
		int tamano = Materias.size();
		InformacionMateria Info = Materias.get(tamano - 1);
		String Nombre = Info.getNombre();
		DefaultListModel model=(DefaultListModel) ListaPlaneadas.getModel();
		model.addElement(Nombre);
		System.out.println(Nombre);
		}
		
	}


package Interfaz;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class OpcionesCentroCord extends JPanel {
private JLabel Titulo;
private JList Estudiantes;
public OpcionesCentroCord() {
	setLayout(new GridLayout(6,1));
	Titulo=new JLabel("Estudiantes a cargo:   ");
	String [] queries = {"Nombre","Nombre","Nombre","Nombre","Nombre","Nombre"};
	Estudiantes= new JList(queries);
	JScrollPane jsp = new JScrollPane(Estudiantes);
	
	add(Titulo);
	add(jsp);
	
	
}
}

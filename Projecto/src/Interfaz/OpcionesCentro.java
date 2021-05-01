package Interfaz;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class OpcionesCentro extends JPanel
{
	private JLabel MateriasPlaneadas;
	private MateriasPlaneadas Planeadas;
	private MateriasVistas Vistas;
	private Promedio Promedio;
	public OpcionesCentro()
	{
		setLayout(new GridLayout(1,3));
		Planeadas=new MateriasPlaneadas();
		Vistas= new MateriasVistas();
		Promedio = new Promedio();
		
		add(Vistas);
		add(Planeadas);
		add(Promedio);
		
	}
	public MateriasVistas getVistas() {
		return Vistas;
	}
	
}

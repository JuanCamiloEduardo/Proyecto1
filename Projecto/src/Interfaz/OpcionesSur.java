package Interfaz;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class OpcionesSur extends JPanel{
	private OpcioneSI izquierda;
	private OpcioneSC centro;
	private OpcionesSD derecha;
	private MateriasVistas Vistas;
	public OpcionesSur(MateriasVistas vistas) 
	{
		setLayout(new GridLayout(1,3));
		izquierda=new OpcioneSI();
		centro=new OpcioneSC(vistas);
		derecha=new OpcionesSD();
		add(izquierda);
		add(centro);
		add(derecha);
	}
	
}

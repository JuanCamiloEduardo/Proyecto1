package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


import Consola.Consola;
import Sistema.Estudiante;
import Sistema.InformacionMateria;


public class VentanaEstudiante extends JFrame{
	private OpcionesNorte norte;
	private OpcionesSur sur;
	private OpcionesCentro centro;
	private MateriasVistas vistas;
	public VentanaEstudiante () 
	{
		setSize(700,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Vista Estudiante");
		setLayout(new BorderLayout());
		norte = new OpcionesNorte();
		add(norte,BorderLayout.NORTH);
		centro = new OpcionesCentro();
		add(centro,BorderLayout.CENTER);
		vistas=centro.getVistas();
		sur = new OpcionesSur(vistas);
		add(sur,BorderLayout.SOUTH);		;

		
		
		/*oeste = new OpcionesOeste();
		add(oeste,BorderLayout.WEST);*/
	}
	public static void main (String [] args ) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );
		VentanaEstudiante ventana= new VentanaEstudiante() ;
		ventana.setVisible(true);
	}
	
}

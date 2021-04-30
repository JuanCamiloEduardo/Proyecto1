package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;





public class VentanaEstudiante extends JFrame{
	private OpcionesNorte norte;
	private OpcionesSur sur;
	private OpcionesCentro centro;
	private OpcionesEste este;
	private OpcionesOeste oeste;
	
	public VentanaEstudiante () 
	{
		setSize(700,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Vista Estudiante");
		setLayout(new BorderLayout());
		
		norte = new OpcionesNorte();
		add(norte,BorderLayout.NORTH);
		sur = new OpcionesSur();
		add(sur,BorderLayout.SOUTH);
		
		centro = new OpcionesCentro();
		add(centro,BorderLayout.CENTER);
		

		este = new OpcionesEste();
		add(este,BorderLayout.EAST);
		
		/*oeste = new OpcionesOeste();
		add(oeste,BorderLayout.WEST);*/
	}
	public static void main (String [] args ) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );
		VentanaEstudiante ventana= new VentanaEstudiante() ;
		ventana.setVisible(true);
	}
	
}

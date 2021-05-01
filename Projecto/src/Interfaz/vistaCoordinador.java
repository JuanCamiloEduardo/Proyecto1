package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;





public class vistaCoordinador extends JFrame{
	private OpcionesNorteCord norte;
	
	private OpcionesCentroCord centro;

	
	public vistaCoordinador () 
	{
		setSize(700,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Vista Coordinador");
		setLayout(new BorderLayout());
		
		norte = new OpcionesNorteCord();
		add(norte,BorderLayout.NORTH);
		
		
		centro = new OpcionesCentroCord();
		add(centro,BorderLayout.CENTER);
		

		
		
	}
	public static void main (String [] args ) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );
		vistaCoordinador ventana= new vistaCoordinador() ;
		ventana.setVisible(true);
	}
	
}

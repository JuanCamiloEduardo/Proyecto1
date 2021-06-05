package Interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import Consola.Consola;

public class Requisitos extends JDialog
{

	private JLabel Requisitos;
	private JLabel Extracreditarse;
	private JList Listarequisitos;
	public Requisitos(String[] requisitos) 
	{
		
		setSize(700,400);
		setLayout(new BorderLayout());
		double credito=Consola.getPGA();
		if (credito<4.0) 
		{
			Extracreditarse=new JLabel("No puede extracreditarse");
		}
		else
		{
			Extracreditarse=new JLabel("Puede extracreditarse");
		}
		Requisitos=new JLabel("Requisitos");
		Requisitos.setBounds(21, 26, 319, 14);
		Listarequisitos=new JList(requisitos);
		add(Requisitos,BorderLayout.NORTH);
		add(Listarequisitos,BorderLayout.CENTER);
		add(Extracreditarse,BorderLayout.SOUTH);
	}
	
}

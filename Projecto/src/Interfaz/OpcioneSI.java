package Interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Consola.Consola;
import Sistema.Estudiante;
import Sistema.InformacionMateria;

public class OpcioneSI extends JPanel implements ActionListener
{
	private JLabel InfoMaterias;
	private JLabel Codigo;
	private JTextField CampoCodigo;
	private JLabel NuevaNota;
	private JTextField CampoNuevaNota;
	private JButton Actualizar;
	private Consola Alumno;
	
	public OpcioneSI()
	{
		setLayout(new GridLayout(6,1));
		InfoMaterias=new JLabel("Actualizar Info Materias");
		Codigo = new JLabel("Codigo: ");
		CampoCodigo= new JTextField();
		NuevaNota= new JLabel("Nueva nota:");
		CampoNuevaNota= new JTextField();
		Actualizar=new JButton("Actualizar");
		Actualizar.addActionListener(this);
		Actualizar.setActionCommand("Actualizar");
		add(InfoMaterias);
		add(Codigo);
		add(CampoCodigo);
		add(NuevaNota);
		add(CampoNuevaNota);
		add(Actualizar);
	}
	public void actionPerformed(ActionEvent pEvento) 
	{
		String CampoNota=CampoNuevaNota.getText();
		CampoNuevaNota.setText("");
		double Anota=Double.parseDouble(CampoNota);
		String Codigo=CampoCodigo.getText();
		CampoCodigo.setText("");
		Estudiante Informacion=Alumno.getAlumno();
		ArrayList<InformacionMateria> Materias = Informacion.getMateriasPasadas();
		for (int i=0;i<Materias.size();i++)
		{
			
			InformacionMateria Nombre = Materias.get(i);
			String Info=Nombre.getCodigo();
			if(Info.equals(Codigo))
			{
				Nombre.setNota(Anota);
			}
		}
	}
}

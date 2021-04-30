package Interfaz;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OpcioneSI extends JPanel
{
	private JLabel InfoMaterias;
	private JLabel Codigo;
	private JTextField CampoCodigo;
	private JLabel NuevaNota;
	private JTextField CampoNuevaNota;
	private JButton Actualizar;
	
	public OpcioneSI()
	{
		setLayout(new GridLayout(6,1));
		InfoMaterias=new JLabel("Actualizar Info Materias");
		Codigo = new JLabel("Codigo: ");
		CampoCodigo= new JTextField();
		NuevaNota= new JLabel("Nueva nota:");
		CampoNuevaNota= new JTextField();
		Actualizar=new JButton("Actualizar");
		add(InfoMaterias);
		add(Codigo);
		add(CampoCodigo);
		add(NuevaNota);
		add(CampoNuevaNota);
		add(Actualizar);
	}
}

package Interfaz;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OpcioneSC extends JPanel
{
	private JLabel RegistrarMaterias;
	private JLabel Codigo;
	private JLabel Semestre;
	private JTextField CampoSemestre;
	private JLabel Nota;
	private JTextField CampoCodigo;
	private JLabel CampoNota;
	private JTextField CampoNuevaNota;
	private JButton Registrar;
	
	public OpcioneSC()
	{
		setLayout(new GridLayout(8,1));
		RegistrarMaterias=new JLabel("Registrar Materias");
		Codigo = new JLabel("Codigo: ");
		CampoCodigo= new JTextField();
		Semestre=new JLabel("Semestre:");
		CampoSemestre=new JTextField();
		Nota=new JLabel("Nota");
		CampoNuevaNota= new JTextField();
		Registrar=new JButton("Registrar");
		add(RegistrarMaterias);
		add(Codigo);
		add(CampoCodigo);
		add(Semestre);
		add(CampoSemestre);
		add(Nota);
		add(CampoNuevaNota);
		add(Registrar);
	}
}

package Interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Interfaz.MateriasVistas;

public class OpcioneSC extends JPanel implements ActionListener
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
	private MateriasVistas Roberto;
	
	public OpcioneSC()
	{;
		setLayout(new GridLayout(8,1));
		RegistrarMaterias=new JLabel("Registrar Materias");
		Codigo = new JLabel("Codigo: ");
		CampoCodigo= new JTextField();
		Semestre=new JLabel("Semestre:");
		CampoSemestre=new JTextField();
		Nota=new JLabel("Nota");
		CampoNuevaNota= new JTextField();
		Registrar=new JButton("Registrar");
		Registrar.addActionListener(this);
		Registrar.setActionCommand("Registrar");
		add(RegistrarMaterias);
		add(Codigo);
		add(CampoCodigo);
		add(Semestre);
		add(CampoSemestre);
		add(Nota);
		add(CampoNuevaNota);
		add(Registrar);
	}
	public void actionPerformed(ActionEvent pEvento) 
	{
		String ACodigo=CampoCodigo.getText();
		String ASemestre=CampoSemestre.getText();
		String Anota=CampoNuevaNota.getText();
		String Union=ACodigo+","+ASemestre+","+Anota;
		CampoCodigo.setText("");
		CampoSemestre.setText("");
		CampoNuevaNota.setText("");
		new MateriasVistas().Actualizar(Union);
	}
}

package Interfaz;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OpcionesSD extends JPanel {
	private JLabel PlanearQ;
	private JLabel Codigo;
	private JTextField CampoCodigo;
	private JButton Planear;
	private JButton Quitar;
	private JLabel Semestre;
	private JTextField CampoSemestre;
	public OpcionesSD()
	{
		setLayout(new GridLayout(7,1));
		PlanearQ=new JLabel("Planear/Quitar Materias");
		Codigo = new JLabel("Codigo: ");
		CampoCodigo= new JTextField();
		Semestre=new JLabel("Semestre:");
		CampoSemestre=new JTextField();
		Planear=new JButton("Planear");
		Quitar=new JButton("Quitar");
		add(PlanearQ);
		add(Codigo);
		add(CampoCodigo);
		add(Semestre);
		add(CampoSemestre);
		add(Planear);
		add(Quitar);
	}
}

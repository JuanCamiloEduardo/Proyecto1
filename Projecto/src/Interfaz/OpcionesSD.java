package Interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Consola.Consola;

public class OpcionesSD extends JPanel  implements ActionListener {
	private JLabel PlanearQ;
	private JLabel Codigo;
	private JTextField CampoCodigo;
	private JButton Planear;
	private JButton Quitar;
	private JButton Registrar;
	private int uno=1;
	private String largo;
	public OpcionesSD()
	{
		setLayout(new GridLayout(6,1));
		PlanearQ=new JLabel("Planear/Quitar Materias");
		Codigo = new JLabel("Codigo: ");
		CampoCodigo= new JTextField();
		Registrar=new JButton("Resgistrar");
		Registrar.addActionListener(this);
		Registrar.setActionCommand("Registrar");
		Planear=new JButton("Planear");
		Planear.addActionListener(this);
		Planear.setActionCommand("Planear");
		add(PlanearQ);
		add(Codigo);
		add(CampoCodigo);
		add(Registrar);
		add(Planear);
	}
	public void actionPerformed(ActionEvent pEvento) 
	{
		String comando = pEvento.getActionCommand( );
		
		if(comando.equals("Planear"))
		{
			
			ArrayList<String> requisitos=Consola.splitplanear(largo);
			String[] Lista=requisitos.toArray(new String[requisitos.size()]);
			Requisitos dialog = new Requisitos(Lista);
			dialog.setVisible(true);

		}	
		else if (comando.equals("Registrar"))
		{
			String ACodigo=CampoCodigo.getText();
			CampoCodigo.setText("");
			if (uno==1)
			{
				 largo=ACodigo;
				 uno+=1;
			}
			else
			{
				 largo=largo+","+ACodigo;
			}
			
		}
	}
}

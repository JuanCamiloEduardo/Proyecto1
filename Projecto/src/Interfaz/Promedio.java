package Interfaz;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Promedio extends JPanel {
	private JButton Promediob;
	
	private JLabel Pga;
	private JLabel semestresegunc;
	private JLabel PgaR;
	private JLabel semestreseguncR;
	private JList creditos;
	public Promedio() 
	{
		setLayout(new GridLayout(6,1));
		Promediob=new JButton("Promedio");
		Pga=new JLabel("PGA:  ");
		semestresegunc=new JLabel("Semestre Segun Creditos:  ");
		PgaR= new JLabel("0");
		semestreseguncR= new JLabel("0");
		String [] queries = {"1...","2...","3...","4..."};
		creditos= new JList(queries);
		JScrollPane jsp = new JScrollPane(creditos);
		add(Promediob);
		add(Pga);
		add(PgaR);

		add(semestresegunc);
		add(semestreseguncR);
		add(jsp);
		
		
		
	}
}

package Interfaz;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import Consola.Consola;
public class VentanaP extends JDialog
{
	private JLabel Pga;
	private JLabel semestresegunc;
	private JLabel PgaR;
	private JLabel semestreseguncR;
	private JList creditos;
	public VentanaP(ArrayList<String> Promedio) 
	{
		setLayout(new GridLayout(5,1));
		setSize(700,400);
		Pga=new JLabel("PGA:  ");
		semestresegunc=new JLabel("Total Creditos:  ");
		PgaR= new JLabel(Consola.getPGA()+"");
		String[] Lista=Promedio.toArray(new String[Promedio.size()]);
		semestreseguncR= new JLabel(Consola.getCreditos()+"");
		creditos= new JList(Lista);
		JScrollPane jsp = new JScrollPane(creditos);
		add(Pga);
		add(PgaR);

		add(semestresegunc);
		add(semestreseguncR);
		add(jsp);
	}
}


package Interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import Consola.Consola;

public class Promedio extends JPanel implements ActionListener {
	private JButton Promediob;
	private JButton Excepciones;
	public Promedio() 
	{
		setLayout(new GridLayout(1,1));
		Promediob=new JButton("Promedio");
		Promediob.addActionListener(this);
		Promediob.setActionCommand("Promedio");
		add(Promediob);


		
	}
	public void actionPerformed(ActionEvent pEvento) 
	{

		Consola.Todo();
		ArrayList<String> Promedio=Consola.getArraySemestres();
		VentanaP Nueva=new VentanaP(Promedio);
		Nueva.setVisible(true);
		

	}
}

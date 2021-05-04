package Interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;

public class Excepciones extends JDialog 
{
	private JLabel Titulo;
	private JLabel Largo;
	private JLabel Largo2;
	private JLabel Largo3;
	private JLabel Largo4;
	private JLabel Largo5;
	private JLabel Largo6;
	private JLabel Largo7;
	private JLabel Largo8;
	private JList Lista;
	public Excepciones() 
	{
		setSize(1000,400);
		setLocationRelativeTo(null);
		setTitle("Excepciones");
		setLayout(new GridLayout(2,1));
		Titulo=new JLabel("Excepciones");
		String[] Hola=("Estas son para que el programa pueda comprender a que tipo de materia se refiere:Es muy importante que primero ingrese las materias que ha visto antes de utilizar las otras funcionalidades del programa:El curso de Escritura Universitaria 1 y 2 se hacen bajo el codigo LENG-1511 y LENG-1512:Para los cursos de Libre Eleccion se hace bajo el codigo CELE-Numero:Para los Cursos y CBUS Tipo Epsilon y Tipo E escribirlo como EPSI-Numero y TPOE-Numero:Para la electiva de matematicas,biologia y quimica se hace bajo EMBQ:Si ya aprobo el curso de LENG-1156 o presento y valido un examen externo  para cumplir el requisito de Lectura de Ingles digite el codigo LENG-2999:Si ya aprobo algun curso de idiomas nivel 10 o presento y valido un examen externo  para cumplir el requisito de Segunda Lengua digite el codigo LENG-3999:En caso de querer planear una materia el usuario debera:Primero registrar las materias que quiere ver esto llenando el codigo y presionando el boton de registrar:Segundo darle al boton de Planear despues de darle al boton de Planear el sistema arrojara el resultadlo pero borrara el registro de las anteriores materias registradas").split(":");
		JList yu=new JList(Hola);
		add(Titulo);
		add(yu);
	}

}

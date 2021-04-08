package Consola;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import Sistema.Estudiante;
import Sistema.InformacionMateria;
import Sistema.Pensum;
import Sistema.Reader;

public class Consola {
	static File archivo=new File("Data/PENSUM.csv");

	public static void main(String[] args)
	{
		Reader lector=new Reader();
		ArrayList<InformacionMateria> ListadoMaterias=lector.cargarRecords(archivo);
		Pensum Sistemas=new Pensum(ListadoMaterias);
		Estudiante Alumno=CodigoMaterias(Sistemas);
		   
		
		
	}
	
	public static Estudiante CodigoMaterias(Pensum materiasPensum) 
	{     
		Scanner sc = new Scanner (System.in);
		System.out.print("Digite los codigos de las materias que ha visto separadas por coma  (MATE1203,MATE1145,....)");
		String Codigos=sc.nextLine();
		String[] ListaCodigos=Codigos.split(",");
		ArrayList<InformacionMateria> MateriasEstudiante=new ArrayList<InformacionMateria>() ;
		for (int j = 0; j < materiasPensum.getMateriasPensum().size(); j++)
		{
		String Codigo =materiasPensum.getMateriasPensum().get(j).getCodigo();
		int i = 0;
		while (i < ListaCodigos.length)
		{
		if (Codigo.equals(ListaCodigos[i])) 
		{
			MateriasEstudiante.add(materiasPensum.getMateriasPensum().get(j));
		}
		i++; 
	
		}
		
		}
		Estudiante alumno=new Estudiante(MateriasEstudiante);
		return alumno;
		
	}
	

}

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
		
		boolean repetidor=false;

	do
	{
		Scanner sc = new Scanner (System.in);
		System.out.print("Hola ,digite que tipo de usuario es estudiante(1) o cordinador(2)");
		String Opcion=sc.nextLine();
		if(Opcion.equals("1")) 
		{
			System.out.print("Que accion quiere realizar \n");
			System.out.print("1-Registrar cursos \n");
			System.out.print("2-Planear cursos \n");
			System.out.print("3-Mirar reporte de nota \n");
			System.out.print("4-Soy candidato a grado \n");
			System.out.print("5-Volver al menu principal \n");
			System.out.print("6-Cerrar aplicacion \n");
			String AccionEstudiante=sc.nextLine();
			Reader lector=new Reader();
			ArrayList<InformacionMateria> ListadoMaterias=lector.cargarRecords(archivo);
;
			if (AccionEstudiante.equals("1")) 
			{
				Pensum Sistemas=new Pensum(ListadoMaterias);
				Estudiante Alumno=CodigoMaterias(Sistemas);
			}
			else if (AccionEstudiante.equals("2")) 
			{
				
			}
			else if (AccionEstudiante.equals("3")) 
			{
				
			}
			else if (AccionEstudiante.equals("4")) 
			{
				
			}
			else if (AccionEstudiante.equals("5")) 
			{
				repetidor=true;
			}
			else if (AccionEstudiante.equals("6")) 
			{
				repetidor=false;
			}
		}
		else if(Opcion.equals("2"))
		{
			System.out.print("Que accion quiere realizar \n");
			System.out.print("1-Revisar avance estudiante \n");
			System.out.print("2-Volver al menu principal \n");
			System.out.print("3-Cerrar aplicacion");
			String AccionCordinador=sc.nextLine();
			if(AccionCordinador.equals("1"))
			{
				
			}
			else if (AccionCordinador.equals("2"))
			{
				repetidor=true;
			}
			else if (AccionCordinador.equals("3"))
			{
				repetidor=false;
			}
		}
	}while(repetidor);
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

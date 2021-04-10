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
			
			if (AccionEstudiante.equals("1")) 
			{
				ArrayList<String> nuevo= new ArrayList<String>();
				nuevo.add("hola");
				nuevo.add("hola");
				System.out.println(nuevo);
				Pensum Sistemas=new Pensum(ListadoMaterias);
				Estudiante Alumno=CodigoMaterias(Sistemas);
				System.out.print("Opcion 4");
				String Opcion2=sc.nextLine();
				
			 if (Opcion2.equals("2")) 
			{
				
			}
			else if (AccionEstudiante.equals("3")) 
			{
				
			}
			else if (Opcion2.equals("4")) 
			{
				Alumno.verificarAvance(Sistemas);
				Alumno.cumplioCbus();
				
			}
			else if (AccionEstudiante.equals("5")) 
			{
				
				repetidor=true;
			}
			else if (AccionEstudiante.equals("6")) 
			{
				repetidor=false;
			}
		}}
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
	
	{   String[] listavacia = new String[0];
		InformacionMateria Escritura1LE=new InformacionMateria(2,"Escritura Universitaria 1","LITE-1621",listavacia,listavacia,8);
		InformacionMateria Escritura2LE=new InformacionMateria(2,"Escritura Universitaria 2","LITE-1622",listavacia,listavacia,8);
		InformacionMateria Escritura1LT=new InformacionMateria(2,"Escritura Universitaria 1","LENG-1511",listavacia,listavacia,8);
		InformacionMateria Escritura2LT=new InformacionMateria(2,"Escritura Universitaria 1","LENG-1512",listavacia,listavacia,8);
		
		
		
		
		
		InformacionMateria BiologiaCelular=new InformacionMateria(3,"Biología Celular","MBIO-1100",listavacia,listavacia,16);
		InformacionMateria Quimica=new InformacionMateria(3,"QUIMICA","QUIM-1103",listavacia,listavacia,16);
		String[] ListaP=new String[1];
		ListaP[0]="ISIS-2503";
		String[] ListaS=new String[1];
		ListaS[0]="ISIS-2403";
		InformacionMateria ProgramaciónConTecnologíasWeb=new InformacionMateria(3,"ProgramaciónConTecnologíasWeb","ISIS-3710",ListaP,listavacia,16);
		InformacionMateria SistemasEmpresariales=new InformacionMateria(3,"Sistemas Empresariales","ISIS3425",ListaS,listavacia,16);
		
		
		
		


		Scanner sc = new Scanner (System.in);
		System.out.print("Digite los codigos de las materias que ha visto separadas por coma  (MATE-1203,MATE-1145,....) ");
		String Codigos=sc.nextLine();
		String[] ListaCodigos=Codigos.split(",");
		ArrayList<InformacionMateria> MateriasEstudiante=new ArrayList<InformacionMateria>() ;
		for (int j = 0; j < materiasPensum.getMateriasPensum().size(); j++)
		{
		String Codigo =materiasPensum.getMateriasPensum().get(j).getCodigo();
		int i = 0;
		while (i < ListaCodigos.length)
		{
		if (Codigo.equals(ListaCodigos[i])||ListaCodigos[i].substring(0,5).equals(Codigo))
		{
			
			if( Codigo.equals("LITE-1621") )
			{			MateriasEstudiante.add(Escritura1LT);

			}
			
			if( Codigo.equals("LITE-1622") )
			{			MateriasEstudiante.add(Escritura2LT);

			}

			else if( Codigo.equals("LENG-1511") )
			{			MateriasEstudiante.add(Escritura1LE);

			}
			else if( Codigo.equals("LENG-1512") )
			{			MateriasEstudiante.add(Escritura2LE);

			}
			else if( Codigo.equals("MBIO-1100") )
			{			MateriasEstudiante.add(Quimica);}
			else if (Codigo.equals("QUIM-1103")) {
				MateriasEstudiante.add(BiologiaCelular);}
			else if (Codigo.equals("ISIS-3710")) {
				MateriasEstudiante.add(SistemasEmpresariales);}
			else if (Codigo.equals("ISIS3425")) {
				MateriasEstudiante.add(ProgramaciónConTecnologíasWeb);

			}
		MateriasEstudiante.add(materiasPensum.getMateriasPensum().get(j));
		

			
			
		}
		i++; 
	
		}
		
		}
		Estudiante alumno=new Estudiante(MateriasEstudiante);
		System.out.println(MateriasEstudiante.toString());
		return alumno;	
	}
	

}

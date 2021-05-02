package Consola;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import Sistema.Estudiante;
import Sistema.InformacionMateria;
import Sistema.Pensum;
import Sistema.Reader;

public class Consola {
	private static Estudiante Alumno;
	private static Pensum Sistemas;
	private static ArrayList<String> RetornoGrado;
	public Pensum getSistemas() 
	{
		return Sistemas;
	}
	static File archivo=new File("Data/PENSUM.csv");
	
	public void CrearPensum() 
	{	
		Reader lector=new Reader();
		ArrayList<InformacionMateria> ListadoMaterias=lector.cargarRecords(archivo);
		Sistemas=new Pensum(ListadoMaterias);
		
	}
	public static void main(String[] args)
	{
		///Metodo Main aca se ejecutan las funciones para el estudiante y cordinador.
		
		boolean repetidor=false;

	do
	{
		Scanner sc = new Scanner (System.in);
		System.out.print("Hola ,digite que tipo de usuario es estudiante(1) o cordinador(2) \n");
		String Opcion=sc.nextLine();
		try {
		int transformacion=Integer.parseInt(Opcion);
		
		if(transformacion==1) 
		{  	
			System.out.print("Registre sus cursos \n");
			System.out.print("Exepciones \nEstas son para que el programa pueda comprender a que tipo de materia se refiere \nEl curso de Escritura Universitaria 1 y 2 se hacen bajo el codigo LENG-1511 y LENG-1512 \nPara los cursos de Libre Eleccion se hace bajo el codigo CELE-Numero \nPara los Cursos y CBUS Tipo Epsilon y Tipo E escribirlo como EPSI-Numero y TPOE-Numero \nPara la electiva de matematicas,biologia y quimica se hace bajo EMBQ\nSi ya aprobo el curso de LENG-1156 o presento y valido un examen externo  para cumplir el requisito de Lectura de Ingles digite el codigo LENG-2999\nSi ya aprobo algun curso de idiomas nivel 10 o presento y valido un examen externo  para cumplir el requisito de Segunda Lengua digite el codigo LENG-3999\n");
			Reader lector=new Reader();
			ArrayList<InformacionMateria> ListadoMaterias=lector.cargarRecords(archivo);
			ArrayList<String> nuevo= new ArrayList<String>();
			Pensum Sistemas=new Pensum(ListadoMaterias);
			//////////////////////////////////
			String CodigosREW = null;
			Estudiante Alumno=null/*CodigoMaterias(Sistemas,CodigosREW)*/;
			/////////////////////////////////
			boolean repetidor2=true;
			do {

			System.out.print("--------------------------------------------- \n");
			System.out.print("--------------------------------------------- \n");
			System.out.print("Que accion quiere realizar \n");
			System.out.print("1-Planear cursos \n");
			System.out.print("2-Mirar reporte de nota \n");
			System.out.print("3-Soy candidato a grado \n");
			System.out.print("4-Cerrar aplicacion \n");
			System.out.print("--------------------------------------------- \n");
			System.out.print("---------------------------------------------\n");
			String Opcion2=sc.nextLine();
			int transformacion2=Integer.parseInt(Opcion2);

			 if (transformacion2==1) 
			{
				 System.out.print("Utilize el siguiente formato para planear materias (MATE-1203,MATE-1503,.....)");
			}
			else if (transformacion2==2) {
					
					ArrayList<InformacionMateria> Copia=CopiaryEliminar(Alumno.getMateriasPasadas());
					double TotalPromedioAcumulado=0;
					double TotalCreditos=0;
					ArrayList<ArrayList> ListaSemestres=AgregarSemestre(Alumno);
					for (int i = 0; i <ListaSemestres.size(); i++)
					{
						ArrayList<InformacionMateria> Semestre=ListaSemestres.get(i);
						int TituloSemestre=i+1;
						double[] Valores= RegistroNotas(Semestre,TituloSemestre);
						double PromedioAcumulado=Valores[0];
						double Creditos=Valores[1];
	
						TotalPromedioAcumulado+=PromedioAcumulado;
						TotalCreditos+=Creditos;
						
					}
					double NotaFinal=TotalPromedioAcumulado/TotalCreditos;
					String hola=Double.toString(NotaFinal);
					if (hola.equals("NaN")) 
					{
						 NotaFinal=0;
					}
					System.out.print("Total Promedio Acumulado "+NotaFinal +"\n");
					Devolver(Copia,Alumno);
			}
			
			else if (transformacion2==3) 
			{
				boolean MateriasFaltantes=Alumno.verificarAvance(Sistemas);
				boolean CBUS= Alumno.cumplioCbus();
				boolean Ingles=Alumno.Ingles();
				boolean SegundaLengua=Alumno.SegundoLenguaje();
				boolean CURSOLIBRE=Alumno.cumpleCele();

				if (MateriasFaltantes && CBUS && Ingles && SegundaLengua && CURSOLIBRE)
				{
					System.out.print("El estudiante es candidato a grado \n");
					
				}
				
				else
				{
					System.out.print("El estudiante no es candidato a grado \n");

				}
			}
			else if (transformacion2==4) 
			{
				
				repetidor=false;
				repetidor2=false;
			}
			else 
			{
				System.out.print("Introduzca uno de  un numero entre 1 y 4 \n");
				repetidor2=true;
			}
				}while(repetidor2);
			}
		else if(transformacion==2)
		{ 
			boolean repetidor3=true;
			do {
		
			System.out.print("Que accion quiere realizar \n");
			System.out.print("1-Revisar avance estudiante \n");
			System.out.print("2-Cerrar aplicacion");
			String AccionCordinador=sc.nextLine();
			int transformacion3=Integer.parseInt(AccionCordinador);
			if(transformacion3==1)
			{
				
			}
			else if (transformacion3==2)
			{
				repetidor=false;
				repetidor3=false;
			}
			else 
			{
				System.out.print("Introduzca uno de  un numero entre 1 y 2 \n");
				repetidor3=true;
			}
			}while(repetidor3);
		}
		else 
		{
			repetidor=true;
		}
		}catch(Exception Error) {
			System.out.print("Introdusca un numero entre 1 y 2 \n");
			repetidor=true;
		}
		
	}while(repetidor);
	}
	
	
	
	public static Estudiante getAlumno() 
	{
		return Alumno;
	}

	public static ArrayList<String> SoyCandidato()
	{
		boolean MateriasFaltantes=Alumno.verificarAvance(Sistemas);
		boolean CBUS= Alumno.cumplioCbus();
		boolean Ingles=Alumno.Ingles();
		boolean SegundaLengua=Alumno.SegundoLenguaje();
		boolean CURSOLIBRE=Alumno.cumpleCele();

		if (MateriasFaltantes && CBUS && Ingles && SegundaLengua && CURSOLIBRE)
		{
			System.out.print("El estudiante es candidato a grado \n");
			
		}
		
		else
		{
			System.out.print("El estudiante no es candidato a grado \n");

		}
		RetornoGrado=Alumno.getRetornoGrado();
		return RetornoGrado;
	}
	public static ArrayList<String> planearhorarioPrerequisitos(/*ArrayList<InformacionMateria> materiasPasadas,ArrayList<InformacionMateria> Pensum,*/ArrayList<String> CodigosPlaneados  ) 
	{	/*
	Esta funcion es la que se encarga de revisar si cumplimos con los correquisitos al planear  una materia
	*/
		ArrayList<InformacionMateria> materiasPasadas=Alumno.getMateriasPasadas();
		ArrayList<InformacionMateria> Pensum=Sistemas.getMateriasPensum();
		ArrayList<String> retorno =new ArrayList<String>();
		boolean pre= true;
        ArrayList<String> codigosMateriasPasadas= new ArrayList<String>();
        
        for (int a = 0; a < materiasPasadas.size(); a++)
        {codigosMateriasPasadas.add(materiasPasadas.get(a).getCodigo());
        }
        ArrayList<String> codigosMateriasPensum= new ArrayList<String>();
        for (int b = 0; b < Pensum.size(); b++)
        {codigosMateriasPensum.add(Pensum.get(b).getCodigo());
        }
        
        for (int j = 0; j < CodigosPlaneados.size(); j++)
        {
            String codigoPlaneado = CodigosPlaneados.get(j);
            for (int k = 0; k < Pensum.size(); k++)
            {
            	

                if (Pensum.get(k).getCodigo().equals(codigoPlaneado))
                {
                   //String[] Correquisitos=Pensum.get(k).getCorrequisitos();
                	


                    String[] Prerrequisitos=Pensum.get(k).getPrerequisitos();
                    for (int l = 0; l < Prerrequisitos.length; l++)
                    {
                    	

                    
                    if (!codigosMateriasPasadas.contains(Prerrequisitos[l])) {
                    	/*System.out.println("No puede ver:"+codigoPlaneado+" Hasta que vea el Prerrequisito: "+Prerrequisitos[l]);*/
						retorno.add("No puede ver:"+codigoPlaneado+" Hasta que vea el Prerrequisito: "+Prerrequisitos[l]);
                    	pre=false;
                    }
                    
                    
                   
                    }
                    if (pre==true) {
					retorno.add("Cumple con los prerrequistos de la materia:"+codigoPlaneado+" revise los correquisitos para saber si podrá inscribirla.");                      
}
                    
    }
                
    }
}
       return retorno; }

	
	
	
	
	
	public static ArrayList<String> planearhorarioCorequisitos(/*ArrayList<InformacionMateria> materiasPasadas,ArrayList<InformacionMateria> Pensum,*/ArrayList<String> CodigosPlaneados  ) 
	{	/*
	Esta funcion es la que se encarga de  decirnos si el estudiante ha cumplido con los correquisitos para mirar una materia el proximo semestre
	*/
		ArrayList<InformacionMateria> materiasPasadas=Alumno.getMateriasPasadas();
		ArrayList<InformacionMateria> Pensum=Sistemas.getMateriasPensum();
		 ArrayList<String> retorno= new ArrayList<String>();

		boolean co= true;
        int contadorCorre=0;
        ArrayList<String> codigosMateriasPasadas= new ArrayList<String>();
        
        for (int a = 0; a < materiasPasadas.size(); a++)
        {codigosMateriasPasadas.add(materiasPasadas.get(a).getCodigo());
        }
        ArrayList<String> codigosMateriasPensum= new ArrayList<String>();
        for (int b = 0; b < Pensum.size(); b++)
        {codigosMateriasPensum.add(Pensum.get(b).getCodigo());
        }
        
        for (int j = 0; j < CodigosPlaneados.size(); j++)
        {
            String codigoPlaneado = CodigosPlaneados.get(j);
            for (int k = 0; k < Pensum.size(); k++)
            {
            	

                if (Pensum.get(k).getCodigo().equals(codigoPlaneado))
                {
                   String[] Correquisitos=Pensum.get(k).getCorrequisitos();
                	


                    for (int l = 0; l < Correquisitos.length; l++)
                    {

                    
                    	if (!codigosMateriasPasadas.contains(Correquisitos[l])&&!CodigosPlaneados.contains(Correquisitos)&& Correquisitos.length>1) {
                    		retorno.add(("No cumple con los correquisitos para poder  planear la materia:"+codigoPlaneado+" sin antes planear o haber visto: "+Correquisitos[l]));
                    		co=false;
                    	}
                    	
                    	
                    	
                    	
                    	

        }
                    if (co==true) {
					  retorno.add(("Cumple con los Correquistos de la materia:"+codigoPlaneado+" revise los Prerrequisitos para saber si podrá inscribirla."));
                  	  

                    	
                    }

                }}}
return retorno;}
	
	public static  ArrayList<String>  planearhorario(/*ArrayList<InformacionMateria> materiasPasadas,ArrayList<InformacionMateria> Pensum,*/ArrayList<String> CodigosPlaneados  ) 
	{
		/*
		 Esta funcion es la que se encarga de decirnos si el estudiante ha cumplido con los requisitos para mirar una materia el proximo semestre
		 */
		
		ArrayList<String> retornoCorrequisitos=planearhorarioCorequisitos( /*materiasPasadas, Pensum,*/CodigosPlaneados  );
		ArrayList<String> retornoPrerrequisitos=planearhorarioPrerequisitos( /*materiasPasadas, Pensum,*/CodigosPlaneados  );
		retornoCorrequisitos.addAll( retornoPrerrequisitos);		
		return  retornoCorrequisitos;
}


	
	
	public static ArrayList<ArrayList> AgregarSemestre(Estudiante Alumno)
	{	
		/*
		 *Esta funcion se encarga de crear un numero de ArrayList por semestre que el estudiante haya visto y
		 * guardar las materias que vio en el 
		 */
		//
		int NumerosListas=0;
		
		for (int i = 0; i <Alumno.getMateriasPasadas().size(); i++)
		{
			int Mayor=Alumno.getMateriasPasadas().get(i).getSemestre();
			if (Mayor>NumerosListas)
			{
				
				NumerosListas=Mayor;
			}
		}
		
		ArrayList<ArrayList>Semestres=new ArrayList<ArrayList>()	; 
		for (int j = 0; j <NumerosListas; j++)
		{
			ArrayList<InformacionMateria>SemestresRepeticion=new ArrayList<InformacionMateria>(); 
			Semestres.add(SemestresRepeticion);
			
		}

		for (int k = 0; k <Alumno.getMateriasPasadas().size(); k++)
		{
			int Periodo=Alumno.getMateriasPasadas().get(k).getSemestre();
			InformacionMateria NumeroSemestre=Alumno.getMateriasPasadas().get(k);
			Semestres.get(Periodo-1).add(NumeroSemestre);
		}
		return Semestres;

	}
	public static ArrayList<InformacionMateria> CopiaryEliminar  (ArrayList<InformacionMateria> MateriasPasadas)
	{  /*Esta funcion Elimina ciertas materias opcionales que se colocan por defecto  para que asi no cuente esta materia ala hora de calcular
		El informe de notas*/
		ArrayList<InformacionMateria> Copia= new ArrayList<InformacionMateria>();
		for (int j = 0; j <MateriasPasadas.size(); j++)
		{
			double Nota= MateriasPasadas.get(j).getNota();
			if (Nota==0.0)
			{
				InformacionMateria CopiaInfo =MateriasPasadas.get(j);
				Copia.add(CopiaInfo);
				MateriasPasadas.remove(j);
			}
			
		}

		return Copia;
		
	}
	public static double[] RegistroNotas(ArrayList<InformacionMateria> ListaSemestres,int TituloSemestre)
	{
		
		/*
		 Esta funcion es la que se encarga de calcular el promedio del estudiante y promedio acumulado en todos los semestres que ha visto
		 */
		double[] Valores=new double[2];
		double TotalCreditos=0;
		int NMaterias=0;
		double PromedioSemestre=0;
		double NotaClase=0;
		double PromedioAcumulado=0;
		System.out.print("Registro notas del "+TituloSemestre +" semestre \n");
		System.out.print("Listado materias tomadas en el semestre \n");
		for (int j = 0; j <ListaSemestres.size(); j++)
		{
			String CursosTomados=ListaSemestres.get(j).getNombre();
			double CreditosTomados=ListaSemestres.get(j).getCreditos();
			double Nota=ListaSemestres.get(j).getNota();
			TotalCreditos+=CreditosTomados;
			NMaterias+=1;
			NotaClase=Nota*CreditosTomados;
			PromedioSemestre+=NotaClase;
			System.out.print("Nombre: "+CursosTomados+" Creditos: "+ CreditosTomados+"\n");
		}
	
		PromedioSemestre=PromedioSemestre/TotalCreditos;
		String hola=Double.toString(PromedioSemestre);
		if(hola=="NaN")
		{
			PromedioSemestre=0;
		}
		PromedioAcumulado=PromedioSemestre*TotalCreditos;
		Valores[0]=PromedioAcumulado;
		Valores[1]=TotalCreditos*1.0;
		System.out.print("Total materias registradas este semestre :"+NMaterias+"  \nTotal creditos: "+TotalCreditos+"\n");
		System.out.print("Promedio Semestre: "+PromedioSemestre+"\n");
		return Valores;
	}
	public static void Devolver(ArrayList<InformacionMateria> Copia,Estudiante Alumno)
	{
		/*
		 Esta devuelve las materia que se eliminaron en Codigo Materias para que asi no tengamos problemas al mirar si el estudiante es candidato a grado
		 */
		for (int j = 0; j <Copia.size(); j++)
		{
			InformacionMateria recoger=Copia.get(j);
			Alumno.getMateriasPasadas().add(recoger);
		}
	}
	public static void CodigoMaterias(String Codigos) 
	
	{   
		/* En esta funcion se utilizan los contructores de Pensum para crear una arraylist con las materias que el estudiante ha visto
		 
		 */
		String[] listavacia = new String[0];
		InformacionMateria BiologiaCelular=new InformacionMateria(3,"Biología Celular","MBIO-1100",listavacia,listavacia,16,4,0);
		InformacionMateria Quimica=new InformacionMateria(3,"QUIMICA","QUIM-1103",listavacia,listavacia,16,4,0);
		String[] ListaP=new String[1];
		ListaP[0]="ISIS-2503";
		String[] ListaS=new String[1];
		ListaS[0]="ISIS-2403";
		InformacionMateria ProgramacionConTecnologiasWeb=new InformacionMateria(3,"ProgramaciónConTecnologíasWeb","ISIS-3710",ListaP,listavacia,16,6,0);
		InformacionMateria SistemasEmpresariales=new InformacionMateria(3,"Sistemas Empresariales","ISIS3425",ListaS,listavacia,16,6,0);
        ////Creamos unas materias para cumplir el pensum
	
		String[] ListaCodigos=Codigos.split(",");
		///Obtenemos una lista de este tipo["MATE-1203:Semestre:Nota","MATE-1504:Semestre:Nota","MATE-1804:Semestre:Nota"]
		ArrayList<InformacionMateria> MateriasEstudiante=new ArrayList<InformacionMateria>() ;
		for (int j = 0; j < Sistemas.getMateriasPensum().size(); j++)
		{
		String Codigo =Sistemas.getMateriasPensum().get(j).getCodigo();
		
		int i = 0;
		while (i < ListaCodigos.length)
		{	
			String[] UbicacionCodigo=ListaCodigos[i].split(":");
		if (Codigo.equals(UbicacionCodigo[0])||UbicacionCodigo[0].substring(0,5).equals(Codigo))
		{
		InformacionMateria CambioNota=Sistemas.getMateriasPensum().get(j);
		CambioNota.setNota(Double.parseDouble(UbicacionCodigo[2]));
		CambioNota.setSemestre(Integer.parseInt(UbicacionCodigo[1]));
		if( Codigo.equals("MBIO-1100") )
		{
			MateriasEstudiante.add(Quimica);}
		else if (Codigo.equals("QUIM-1103")) {
			MateriasEstudiante.add(BiologiaCelular);}
		if (Codigo.equals("ISIS-3710")) {
			MateriasEstudiante.add(SistemasEmpresariales);}
		else if (Codigo.equals("ISIS-3425")) {
			MateriasEstudiante.add(ProgramacionConTecnologiasWeb);
		}
		MateriasEstudiante.add(CambioNota);
		
		}
		i++; 
	
		}
		
		}

		Alumno=new Estudiante(MateriasEstudiante);
		


	}
	public static  ArrayList<String> splitplanear(String CargarMaterias)
	{
		 String[] ListaCodigos=CargarMaterias.split(",");
				 ArrayList<String> Codigos= new  ArrayList<String>();
				 for (int k = 0; k < ListaCodigos.length; k++)
				 {
					 Codigos.add(ListaCodigos[k]);
				 }
			return planearhorario(/*Alumno.getMateriasPasadas(),Sistemas.getMateriasPensum(),*/Codigos);
			
	}
}

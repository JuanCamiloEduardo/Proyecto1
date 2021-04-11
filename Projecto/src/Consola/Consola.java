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
		System.out.print("Hola ,digite que tipo de usuario es estudiante(1) o cordinador(2) \n");
		String Opcion=sc.nextLine();
		if(Opcion.equals("1")) 
		{   
			System.out.print("Registre sus cursos \n");
			System.out.print("Exepciones \nEstas son para que el programa pueda comprender a que tipo de materia se refiere \nEl curso de Escritura Universitaria 1 y 2 se hacen bajo el codigo LENG-1511 y LENG-1512 \nPara los cursos de Libre Eleccion se hace bajo el codigo CELE-Numero \nPara los Cursos y CBUS Tipo Epsilon y Tipo E escribirlo como EPSI-Numero y TPOE-Numero \nPara la electiva de matematicas,biologia y quimica se hace bajo EMBQ\nSi ya aprobo el curso de LENG-1156 o presento y valido un examen externo  para cumplir el requisito de Lectura de Ingles digite el codigo LENG-2999\nSi ya aprobo algun curso de idiomas nivel 10 o presento y valido un examen externo  para cumplir el requisito de Segunda Lengua digite el codigo LENG-3999\n");
			Reader lector=new Reader();
			ArrayList<InformacionMateria> ListadoMaterias=lector.cargarRecords(archivo);
			ArrayList<String> nuevo= new ArrayList<String>();
			Pensum Sistemas=new Pensum(ListadoMaterias);
			Estudiante Alumno=CodigoMaterias(Sistemas);
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

			 if (Opcion2.equals("1")) 
			{
				 System.out.print("Utilize el siguiente formato para planear materias (MATE-1203,MATE-1503,.....)");
				 String CargarMaterias=sc.nextLine();
				 String[] ListaCodigos=CargarMaterias.split(",");
				 ArrayList<String> Codigos= new  ArrayList<String>();
				 for (int k = 0; k < ListaCodigos.length; k++)
				 {
					 Codigos.add(ListaCodigos[k]);
				 }
			planearhorario(Alumno.getMateriasPasadas(),Sistemas.getMateriasPensum(),Codigos);
			}
			else if (Opcion2.equals("2")) {
					
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
					System.out.print("Total Promedio Acumulado "+NotaFinal +"\n");
					Devolver(Copia,Alumno);
			}
			
			else if (Opcion2.equals("3")) 
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
					System.out.print("El estudiante no es candidato a grad○○ \n");

				}
				
			}
			else if (Opcion2.equals("4")) 
			{
				
				repetidor=false;
				repetidor2=false;
			}
			}while(repetidor2);
			}
		else if(Opcion.equals("2"))
		{ 
			boolean repetidor3=true;
			do {
		
			System.out.print("Que accion quiere realizar \n");
			System.out.print("1-Revisar avance estudiante \n");
			System.out.print("2-Cerrar aplicacion");
			String AccionCordinador=sc.nextLine();
			if(AccionCordinador.equals("1"))
			{
				
			}
			else if (AccionCordinador.equals("3"))
			{
				repetidor=false;
				repetidor3=false;
			}
			}while(repetidor3);
		}
		
	}while(repetidor);
	}
	
	
	
	public static void planearhorarioPrerequisitos(ArrayList<InformacionMateria> materiasPasadas,ArrayList<InformacionMateria> Pensum,ArrayList<String> CodigosPlaneados  ) 
	{	boolean pre= true;
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
                    	System.out.println("No puede ver:"+codigoPlaneado+" Hasta que vea el Prerrequisito: "+Prerrequisitos[l]);
                    	pre=false;
                    }
                    
                    
                   
                    }
                    if (pre==true) {
                    	  System.out.println("Cumple con los prerrequistos de la materia:"+codigoPlaneado+" revise los correquisitos para saber si podrá inscribirla.");
                      }
                    
    }
                
    }
}
        }

	
	
	
	
	
	public static void planearhorarioCorequisitos(ArrayList<InformacionMateria> materiasPasadas,ArrayList<InformacionMateria> Pensum,ArrayList<String> CodigosPlaneados  ) 
	{	boolean co= true;
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
                    	if (!codigosMateriasPasadas.contains(Correquisitos[l])&&!CodigosPlaneados.contains(Correquisitos)) {
                    		
                    		System.out.println("No cumple con los correquisitos para poder  planear la materia:"+codigoPlaneado+" sin antes planear o haber visto: "+Correquisitos[l]);
                    		co=false;
                    	}
                    	
                    	
                    	
                    	
                    	

        }
                    if (co==true) {
                  	  System.out.println("Cumple con los Correquistos de la materia:"+codigoPlaneado+" revise los Prerrequisitos para saber si podrá inscribirla.");

                    	
                    }

                }}}}
	
	public static void planearhorario(ArrayList<InformacionMateria> materiasPasadas,ArrayList<InformacionMateria> Pensum,ArrayList<String> CodigosPlaneados  ) 
	{System.out.println("PRE Y CORREQUISTOS \n");

		planearhorarioCorequisitos( materiasPasadas, Pensum,CodigosPlaneados  );
		planearhorarioPrerequisitos( materiasPasadas, Pensum,CodigosPlaneados  );

        }

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static ArrayList<ArrayList> AgregarSemestre(Estudiante Alumno)
	{	
		
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
	{
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
		PromedioAcumulado=PromedioSemestre*TotalCreditos;
		Valores[0]=PromedioAcumulado;
		Valores[1]=TotalCreditos*1.0;
		System.out.print("Total materias registradas este semestre :"+NMaterias+"  \nTotal creditos: "+TotalCreditos+"\n");
		System.out.print("Promedio Semestre: "+PromedioSemestre+"\n");
		return Valores;
	}
	public static void Devolver(ArrayList<InformacionMateria> Copia,Estudiante Alumno)
	{
		for (int j = 0; j <Copia.size(); j++)
		{
			InformacionMateria recoger=Copia.get(j);
			Alumno.getMateriasPasadas().add(recoger);
		}
	}
	public static Estudiante CodigoMaterias(Pensum materiasPensum) 
	
	{   String[] listavacia = new String[0];
		InformacionMateria BiologiaCelular=new InformacionMateria(3,"Biología Celular","MBIO-1100",listavacia,listavacia,16,4,0);
		InformacionMateria Quimica=new InformacionMateria(3,"QUIMICA","QUIM-1103",listavacia,listavacia,16,4,0);
		String[] ListaP=new String[1];
		ListaP[0]="ISIS-2503";
		String[] ListaS=new String[1];
		ListaS[0]="ISIS-2403";
		InformacionMateria ProgramacionConTecnologiasWeb=new InformacionMateria(3,"ProgramaciónConTecnologíasWeb","ISIS-3710",ListaP,listavacia,16,6,0);
		InformacionMateria SistemasEmpresariales=new InformacionMateria(3,"Sistemas Empresariales","ISIS3425",ListaS,listavacia,16,6,0);
        ////Creamos unas materias para cumplir el pensum
		
		Scanner sc = new Scanner (System.in);
		System.out.print("Digite los codigos de las materias que ha visto separadas por coma  (MATE-1203:Semestre:Nota,MATE-1504:Semestre:Nota,....) ");
		String Codigos=sc.nextLine();
		String[] ListaCodigos=Codigos.split(",");
		///Obtenemos una lista de este tipo["MATE-1203:Semestre:Nota","MATE-1504:Semestre:Nota","MATE-1804:Semestre:Nota"]
		ArrayList<InformacionMateria> MateriasEstudiante=new ArrayList<InformacionMateria>() ;
		for (int j = 0; j < materiasPensum.getMateriasPensum().size(); j++)
		{
		String Codigo =materiasPensum.getMateriasPensum().get(j).getCodigo();
		
		int i = 0;
		while (i < ListaCodigos.length)
		{	
			String[] UbicacionCodigo=ListaCodigos[i].split(":");
		if (Codigo.equals(UbicacionCodigo[0])||UbicacionCodigo[0].substring(0,5).equals(Codigo))
		{
		InformacionMateria CambioNota=materiasPensum.getMateriasPensum().get(j);
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
		System.out.println(MateriasEstudiante);
		Estudiante alumno=new Estudiante(MateriasEstudiante);
		return alumno;	
	}
	

}

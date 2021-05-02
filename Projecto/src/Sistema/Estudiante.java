package Sistema;
import java.util.ArrayList;
public class Estudiante extends Usuario {
	private boolean RIngles;
	private boolean RSegundoLenguaje;
	private boolean Rcbus;
	private boolean RELECTIVAS;
	private ArrayList<String> RetornoGrado= new ArrayList<String>();
	private ArrayList<InformacionMateria> MateriasPasadas;
	
	public ArrayList<String> getRetornoGrado() {
		return RetornoGrado;
	}

	public ArrayList<InformacionMateria> getMateriasPasadas() 
	{
		return MateriasPasadas;
	}

	public void setMateriasPasadas(ArrayList<InformacionMateria> materiasPasadas) 
	{
		MateriasPasadas = materiasPasadas;
	}

	public Estudiante(ArrayList<InformacionMateria> materiasPasadas) 
	{
		super();
		MateriasPasadas = materiasPasadas;
	}
	public void ActualizarEstudiante(Estudiante alumno, InformacionMateria materia)
	{
		alumno.MateriasPasadas.add(materia);
	}
	
	public boolean Ingles( ) 
	{
		/*
		Mira si cumple con los requisitos de Ingles
		*/
		RIngles=false;
		for (int j = 0; j < MateriasPasadas.size(); j++)
		{
		String Codigo =MateriasPasadas.get(j).getCodigo();
		if (Codigo.equals("LENG-2999") )
		{
				RIngles= true;
			
				
		}


		}
		if(RIngles==false) 
		{
				RetornoGrado.add("El estudiante no ha cumplido con el requesito de LENG-2999 ");
				
				
			
		}
		else if(RIngles==true) {
			RetornoGrado.add("El estudiante  ha cumplido con el requesito de LENG-2999 ");
			
		}
		
	return RIngles;
	}
	
	public boolean SegundoLenguaje( ) {
		/*
		Mira si cumple con los requisitos de Segundo Lenguaje
		*/
		RSegundoLenguaje=false;
		for (int j = 0; j < MateriasPasadas.size(); j++)
		{
		String Codigo =MateriasPasadas.get(j).getCodigo();

		if (Codigo.equals("LENG-3999"))
		{
			
			RSegundoLenguaje= true;
		}
		}
		if (RSegundoLenguaje==false)		{

			RetornoGrado.add("El estudiante no ha cumplido con el requisito de segundo lenguaje(cumplir un curso 10 de idiomas o examen ) )");
		}
		else if(RSegundoLenguaje==true) {
			RetornoGrado.add("El estudiante ha cumplido con el requisito de segundo lenguaje(cumplir un curso 10 de idiomas o examen )");
		}
		
	return RSegundoLenguaje;
	}
	
	
	

	
	public ArrayList<InformacionMateria> verificarCbus( ) {
		/*
		Crea una lista para separar los cbus que ha visto y poder luego saber su tamaño y trabajar en ellos
		*/
		ArrayList<InformacionMateria> CbusAprobados= new ArrayList<InformacionMateria> ();
		for (int K = 0; K < MateriasPasadas.size(); K++)
		{
			
		String Codigo =MateriasPasadas.get(K).getCodigo();
		
		if (Codigo.substring(0,2).equals("CB")||Codigo.substring(0,4).equals("TPOE")||Codigo.substring(0,4).equals("EPSI")){
				CbusAprobados.add(MateriasPasadas.get(K));
				
		}
		}
		return CbusAprobados;
		
	}
	public boolean cumpleCele() 
	{	/*
	Mira si cumple con los requisitos de Curso de Libre eleccion
	*/
		RELECTIVAS=false;
		int contador=0;
		for (int K = 0; K < MateriasPasadas.size(); K++)
		{
			String codigo=MateriasPasadas.get(K).getCodigo();
			if (codigo.substring(0,5).equals("CELE-"))
			{
				contador+=1;
			}
		}
		if (contador>=2)
		{
			RELECTIVAS=true;
			RetornoGrado.add("El estudiante cumple con los cursos de libre eleccion");
		}
		else if(contador==1)
		{
			RetornoGrado.add("Al estudiante le hace falta un Curso de Libre Eleccion");
		}
		else
		{
			RetornoGrado.add("Al estudiante le hace falta dos Cursos de Libre Eleccion");
		}
		return RELECTIVAS;
		
		
	}

	public boolean cumplioCbus () {
		/*
		
	Mira si cumple con los requisitos de CBUS y ser un candidato a grado
	
		 */
		Rcbus=false;
		boolean cbucientifico=false;
		boolean uno=false;
		boolean cbuColombia=false;
		boolean cbuHumanidades=false;
		boolean cbuEpsilon=false;
		boolean cbuTipoE=false;
		int contador=0;
		
		
		ArrayList<InformacionMateria>  CbusAprobados =verificarCbus ();
		if (CbusAprobados.size()<6 ) 
		{
			Rcbus= false;
			int limite=6-CbusAprobados.size();
			RetornoGrado.add("Al estudiante le hacen falta "+limite+" CBUS");

			for (int i = 0; i <CbusAprobados.size(); i++)
			{	
				InformacionMateria curso =CbusAprobados.get(i);
				
				if(curso.getCodigo().contains("CBCO-")) 
				{
					cbuColombia=true;
				}
				if(curso.getCodigo().contains("CBPC-")) {
					cbucientifico=true;
				}

				if(curso.getCodigo().contains("EPSI-")) {
					cbuEpsilon=true;
					
				}

				if(curso.getCodigo().contains("CBCA-")) {
					cbuHumanidades=true;	
				}

			
				if(curso.getCodigo().contains("TPOE-")) 
				{
					contador+=1;
					if (contador >1)
					{
						cbuTipoE= true;
					
					}
					else if (contador==0)
					{
						uno=false;
					}
					else if (contador==1)
					{
						uno=true;
					}

				}

			}
			if (cbuColombia==false)
			{
				RetornoGrado.add("Al estudiante le hace falta un CBU tipo Colombia");
			}
			else if(cbuColombia==true)
			{
				RetornoGrado.add("El estudiante ha cumplido con un CBU tipo Colombia");
			}
			if (cbucientifico==false)
			{
				RetornoGrado.add("Al estudiante le hace falta un CBU tipo Pensamiento Cientifico ");
			}
			else if(cbucientifico==true)
			{
				RetornoGrado.add("El estudiante ha cumplido con un CBU tipo Cientifico ");
			}
			if (cbuHumanidades==false)
			{
				RetornoGrado.add("Al estudiante le hace falta un CBU tipo Artes y Humanidades ");
			}
			else if(cbuHumanidades==true)
			{
				RetornoGrado.add("El estudiante ha cumplido con un CBU tipo Arte y Humanidades ");
			}
			if (cbuEpsilon==false)
			{
				RetornoGrado.add("Al estudiante le hace falta un Curso tipo Epsilon ");
			}
			else if(cbuEpsilon==true)
			{
				RetornoGrado.add("El estudiante ha cumplido con un curso tipo Epsilon ");
			}
			if (uno==false)
			{
				RetornoGrado.add("Al estudiante le hacen falta dos CBUS Tipo E ");
			}
			else if (uno==true)
			{
				RetornoGrado.add("Al estudiante le hacen falta un CBU Tipo E ");
			}
			else if (cbuTipoE) 
			{
				RetornoGrado.add("El estudiante ha cumplido con un los CBUS tipo E ");
			}

			
		}

		
		
		else if (CbusAprobados.size()>5 ) 
		{
			for (int j = 0; j <CbusAprobados.size(); j++)
				{	
					InformacionMateria curso =CbusAprobados.get(j);
					
					if(curso.getCodigo().contains("CBCO-")) 
					{
						cbuColombia=true;
					}
					if(curso.getCodigo().contains("CBPC-")) {
						cbucientifico=true;
					}

					if(curso.getCodigo().contains("EPSI-")) {
						cbuEpsilon=true;
						
					}

					if(curso.getCodigo().contains("CBCA-")) {
						cbuHumanidades=true;	
					}

				
					if(curso.getCodigo().contains("TPOE-")) 
					{
						contador+=1;
						if (contador >1)
						{
							cbuTipoE= true;
						
						}
						else if (contador==0)
						{
							uno=false;
						}
						else if (contador==1)
						{
							uno=true;
						}

					}

				}
				if (cbuColombia==false)
				{
					RetornoGrado.add("Al estudiante le hace falta un CBU tipo Colombia");
				}
				else if(cbuColombia==true)
				{
					RetornoGrado.add("El estudiante ha cumplido con un CBU tipo Colombia");
				}
				if (cbucientifico==false)
				{
					RetornoGrado.add("Al estudiante le hace falta un CBU tipo Pensamiento Cientifico ");
				}
				else if(cbucientifico==true)
				{
					RetornoGrado.add("El estudiante ha cumplido con un CBU tipo Cientifico ");
				}
				if (cbuHumanidades==false)
				{
					RetornoGrado.add("Al estudiante le hace falta un CBU tipo Artes y Humanidades ");
					
				}
				else if(cbuHumanidades==true)
				{
					RetornoGrado.add("El estudiante ha cumplido con un CBU tipo Arte y Humanidades ");
				}
				if (cbuEpsilon==false)
				{
					RetornoGrado.add("Al estudiante le hace falta un Curso tipo Epsilon ");
				}
				else if(cbuEpsilon==true)
				{
					RetornoGrado.add("El estudiante ha cumplido con un curso tipo Epsilon ");
				}
				if (uno==false)
				{
					RetornoGrado.add("Al estudiante le hacen falta dos CBUS Tipo E ");
				}
				else if (uno==true)
				{
					RetornoGrado.add("Al estudiante le hacen falta un CBU Tipo E" );
				}
				if(cbuTipoE==true)
				{	RetornoGrado.add("El estudiante ha cumplido con los  CBUs tipo E" );
				
				}

			
				}
			
				
				
		if (cbucientifico==true&&  cbuHumanidades==true  && cbuColombia==true  &&  cbuTipoE==true &&cbuEpsilon==true ) {
			
			Rcbus= true;
			
		}
		
		
	return Rcbus;	
	}
	
	public boolean verificarAvance(Pensum MateriasPensum){
		/*
		Mira si cumple con el pensum de la carrera que ha introducido 
		*/
			ArrayList<String> codigosaprobados= new ArrayList<String>() ;
			
			for (int i = 0;  i<MateriasPasadas.size(); i++)
			{	
				
				String Codigo =MateriasPensum.getMateriasPensum().get(i).getCodigo();
				codigosaprobados.add(Codigo);
			}
			
			
				 
				 
			boolean cumple= false;
			int limite=MateriasPensum.getMateriasPensum().size()-7;
			for (int j = 0; j <limite; j++)
			{	
				String Codigo =MateriasPensum.getMateriasPensum().get(j).getCodigo();
				 if (!codigosaprobados.contains(Codigo)) 
				 {
					 cumple=false;
					RetornoGrado.add("Hace falta la materia:"+Codigo+"\n");
				 }
				
				
				}
			return cumple;
		
	}
	
	
	
	
	
	
	
	
	
	
}

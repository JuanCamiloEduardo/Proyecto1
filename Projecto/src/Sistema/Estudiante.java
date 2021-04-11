package Sistema;
import java.util.ArrayList;
public class Estudiante {
	private boolean RIngles;
	private boolean RSegundoLenguaje;
	private boolean Rcbus;
	private boolean RELECTIVAS;
	private ArrayList<InformacionMateria> MateriasPasadas;
	
	public ArrayList<InformacionMateria> getMateriasPasadas() {
		return MateriasPasadas;
	}

	public void setMateriasPasadas(ArrayList<InformacionMateria> materiasPasadas) {
		MateriasPasadas = materiasPasadas;
	}

	public Estudiante(ArrayList<InformacionMateria> materiasPasadas) {
		super();
		MateriasPasadas = materiasPasadas;
	}
	
	public boolean Ingles( ) {
		RIngles=false;
		for (int j = 0; j < MateriasPasadas.size(); j++)
		{
		String Codigo =MateriasPasadas.get(j).getCodigo();
		if (Codigo.equals("LENG-2999") )
		{
				RIngles= true;
			
				
		}


		}
		if(RIngles==false) {
			
				System.out.print("El estudiante no ha cumplido con el requesito de LENG-2999 \n");
				
			
		}
		else if(RIngles==true) {
			System.out.print("El estudiante  ha cumplido con el requesito de LENG-2999 \n");
		}
		
	return RIngles;
	}
	
	public boolean SegundoLenguaje( ) {
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
			System.out.print("El estudiante no ha cumplido con el requisito de segundo lenguaje(cumplir un curso 10 de idiomas o examen ) \n)");
		}
		else if(RSegundoLenguaje==true) {
			System.out.print("El estudiante ha cumplido con el requisito de segundo lenguaje(cumplir un curso 10 de idiomas o examen ) \n)");
		}
		
	return RSegundoLenguaje;
	}
	
	
	

	
	public ArrayList<InformacionMateria> verificarCbus( ) {
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
	{	
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
			System.out.print("El estudiante cumple con los cursos de libre eleccion \n");
		}
		else if(contador==1)
		{
			System.out.print("Al estudiante le hace falta un Curso de Libre Eleccion \n");
		}
		else
		{
			System.out.print("Al estudiante le hace falta dos Cursos de Libre Eleccion \n");
		}
		return RELECTIVAS;
		
		
	}

	public boolean cumplioCbus () {
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
			System.out.print("Al estudiante le hacen falta "+limite+" CBUS \n");

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
				System.out.print("Al estudiante le hace falta un CBU tipo Colombia \n ");
			
			}
			else if(cbuColombia==true)
			{
				System.out.print("El estudiante ha cumplido con un CBU tipo Colombia \n");
			}
			if (cbucientifico==false)
			{
				System.out.print("Al estudiante le hace falta un CBU tipo Pensamiento Cientifico \n");
			}
			else if(cbucientifico==true)
			{
				System.out.print("El estudiante ha cumplido con un CBU tipo Cientifico \n");
			}
			if (cbuHumanidades==false)
			{
				System.out.print("Al estudiante le hace falta un CBU tipo Artes y Humanidades \n");
			}
			else if(cbuHumanidades==true)
			{
				System.out.print("El estudiante ha cumplido con un CBU tipo Arte y Humanidades \n");
			}
			if (cbuEpsilon==false)
			{
				System.out.print("Al estudiante le hace falta un Curso tipo Epsilon \n");
			}
			else if(cbuEpsilon==true)
			{
				System.out.print("El estudiante ha cumplido con un curso tipo Epsilon \n");
			}
			if (uno==false)
			{
				System.out.print("Al estudiante le hacen falta dos CBUS Tipo E \n" );
			}
			else if (uno==true)
			{
				System.out.print("Al estudiante le hacen falta un CBU Tipo E \n");
			}
			else if (cbuTipoE) 
			{
				System.out.print("El estudiante ha cumplido con un los CBUS tipo E \n");
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
					System.out.print("Al estudiante le hace falta un CBU tipo Colombia \n");
				}
				else if(cbuColombia==true)
				{
					System.out.print("El estudiante ha cumplido con un CBU tipo Colombia \n");
				}
				if (cbucientifico==false)
				{
					System.out.print("Al estudiante le hace falta un CBU tipo Pensamiento Cientifico \n");
				}
				else if(cbucientifico==true)
				{
					System.out.print("El estudiante ha cumplido con un CBU tipo Cientifico \n");
				}
				if (cbuHumanidades==false)
				{
					System.out.print("Al estudiante le hace falta un CBU tipo Artes y Humanidades \n");
				}
				else if(cbuHumanidades==true)
				{
					System.out.print("El estudiante ha cumplido con un CBU tipo Humanidades \n");
				}
				if (cbuEpsilon==false)
				{
					System.out.print("Al estudiante le hace falta un Curso tipo Epsilon \n");
				}
				else if(cbuEpsilon==true)
				{
					System.out.print("El estudiante ha cumplido con un curso tipo Epsilon \n");
				}
				if (uno==false)
				{
					System.out.print("Al estudiante le hacen falta dos CBUS Tipo E \n");
				}
				else if (uno==true)
				{
					System.out.print("Al estudiante le hacen falta un CBU Tipo E \n");
				}
				if(cbuTipoE==true)
				{
					System.out.print("El estudiante ha cumplido con los  CBUs tipo E \n" );
				}

			
				}
			
				
				
		if (cbucientifico==true&&  cbuHumanidades==true  && cbuColombia==true  &&  cbuTipoE==true &&cbuEpsilon==true ) {
			
			Rcbus= true;
			System.out.println(Rcbus);
		}
		
		
	return Rcbus;	
	}
	
	public boolean verificarAvance(Pensum MateriasPensum){
		
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
					 System.out.println("Hace falta la materia:"+Codigo+"\n");
				 }
				
				
				}
			return cumple;
		
	}
	
	
	
	
	
	
	
	
	
	
}

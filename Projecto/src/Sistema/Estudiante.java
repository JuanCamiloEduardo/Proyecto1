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
		if (Codigo == "LENG-1156")
		{
				RIngles= true;
			
				
		}
		else
		{
			System.out.print("El estudiante no ha cumplido con el curso de ingles 1156 \n");
		}

		}
		
	return RIngles;
	}
	
	public boolean SegundoLenguaje( ) {
		RSegundoLenguaje=false;
		for (int j = 0; j < MateriasPasadas.size(); j++)
		{
		String Nombre =MateriasPasadas.get(j).getNombre();
		String Codigo =MateriasPasadas.get(j).getCodigo();

		if (Nombre.contains("10")&& Codigo.substring(0,5)=="LENG-"){
			
			RSegundoLenguaje= true;
		}
		else
		{
			System.out.print("El estudiante no ha cumplido con el requisito de segundo lenguaje(cumplir un curso 10 de idiomas)\n)");
		}

		}
		
	return RSegundoLenguaje;
	}
	
	
	

	
	public ArrayList<InformacionMateria> verificarCbus( ) {
		ArrayList<InformacionMateria> CbusAprobados= new ArrayList<InformacionMateria> ();
		for (int K = 0; K < MateriasPasadas.size(); K++)
		{
			
		String Codigo =MateriasPasadas.get(K).getCodigo();
		
		System.out.println(Codigo);
		if (Codigo.substring(0,2).equals("CB")||Codigo.substring(0,4).equals("TPOE")||Codigo.substring(0,4).equals("EPSI")){
				CbusAprobados.add(MateriasPasadas.get(K));
				System.out.println("agrego cbu");
				
		}
		}
		System.out.println(CbusAprobados);
		return CbusAprobados;
		
	}
	public boolean cumpleCele() 
	{	RELECTIVAS=false;
		int contador=0;
		for (int K = 0; K < MateriasPasadas.size(); K++)
		{
			String codigo=MateriasPasadas.get(K).getCodigo();
			if (codigo.substring(0,5).equals("CELE-"))
			{
				contador+=1;
				
				if (contador>=2)
				{
					RELECTIVAS=true;
				}
				else if(contador==1)
				{
					System.out.print("Al estudiante le hace falta un Curso de Libre Eleccion");
				}
				else
				{
					System.out.print("Al estudiante le hace falta dos Cursos de Libre Eleccion");
				}
			}
		}
		return RELECTIVAS;
		
		
	}

	public boolean cumplioCbus () {
		Rcbus=false;
		boolean cbucientifico=false;
		boolean cbuColombia=false;
		boolean cbuHumanidades=false;
		boolean cbuEpsilon=false;
		boolean cbuTipoE=false;
		int contador=0;
		
		
		ArrayList<InformacionMateria>  CbusAprobados =verificarCbus ();
		if (CbusAprobados.size()<6 ) {
			Rcbus= false;
		}
		else if (CbusAprobados.size()>5 ) {
				for (int j = 0; j <CbusAprobados.size(); j++)
				{	InformacionMateria curso =CbusAprobados.get(j);

					
					
					if(curso.getCodigo().contains("CBCO-")) {
						cbuColombia=true;
						System.out.print(" ");
					}
					else if (j==CbusAprobados.size())
					{
						System.out.print("Al estudiante le hace falta un CBU tipo Colombia");
					}
					
					if(curso.getCodigo().contains("CBPC-")) {
						cbucientifico=true;
					}
					else if (j==CbusAprobados.size())
					{
						System.out.print("Al estudiante le hace falta un CBU tipo Pensamiento Cientifico");
					}
					if(curso.getCodigo().contains("EPSI-")) {
						cbuEpsilon=true;
						
					}
					else if (j==CbusAprobados.size())
					{
						System.out.print("Al estudiante le hace falta un curso tipo EPSILON");
					}
					if(curso.getCodigo().contains("CBCA-")) {
						cbuHumanidades=true;
						
					}
					else if (j==CbusAprobados.size())
					{
						System.out.print("Al estudiante le hace falta un CBU tipo Artes y Humanidades");
					}
				
					if(curso.getCodigo().contains("TPOE-")) 
					{
						contador+=1;
						if (contador >1){
							cbuTipoE= true;
						}
					
						
					}
					else if (j==CbusAprobados.size())
					{
						if (contador==1)
						{
							System.out.print("Al estudiante le hace falta un Curso tipo E");
						}
						else
						{
							System.out.print("Al estudiante le hace falta dos Cursso tipo E");
						}
					}
					
					
			
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
		
			for (int j = 0; j <MateriasPensum.getMateriasPensum().size(); j++)
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

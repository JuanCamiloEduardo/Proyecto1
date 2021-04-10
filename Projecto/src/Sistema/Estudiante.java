package Sistema;
import java.util.ArrayList;
public class Estudiante {
	private boolean RIngles;
	private boolean RSegundoLenguaje;
	private boolean REscritura;
	private boolean Rcbus;
	private boolean RConstitucion;

	private ArrayList<InformacionMateria> MateriasPasadas;
	private int CreditosPasados;
	
	public Estudiante(ArrayList<InformacionMateria> materiasPasadas) {
		super();
		MateriasPasadas = materiasPasadas;
	}
	
	public boolean Ingles( ArrayList<InformacionMateria> MateriasPasadas) {
		for (int j = 0; j < MateriasPasadas.size(); j++)
		{
		String Codigo =MateriasPasadas.get(j).getCodigo();
		if (Codigo == "LENG-1156"){
				RIngles= true;
				
		}
		
		j++; 
		}
		
	return RIngles;
	}
	
	public boolean SegundoLenguaje( ArrayList<InformacionMateria> MateriasPasadas) {
		for (int j = 0; j < MateriasPasadas.size(); j++)
		{
		String Nombre =MateriasPasadas.get(j).getNombre();
		String Codigo =MateriasPasadas.get(j).getCodigo();

		if (Nombre.contains("10")&& Codigo.substring(0,5)=="LENG-"){
			
			RSegundoLenguaje= true;
		}
		
		j++; 
		}
		
	return RSegundoLenguaje;
	}
	
	
	
	public boolean Escritura( ArrayList<InformacionMateria> MateriasPasadas) {
		boolean REscritura1 = false;
		boolean REscritura2 = false;

		for (int j = 0; j < MateriasPasadas.size(); j++)
		{
			
		String Codigo =MateriasPasadas.get(j).getCodigo();
		if (Codigo == "LENG-1511"|| Codigo=="LITE-1621") {
				REscritura1= true;	
				
		}
		if (Codigo == "LENG-1512"|| Codigo=="LITE-1622") {
			REscritura2= true;	}
		
		j++; 
		}
		
		
		if (REscritura1==true && REscritura2==true) {
			REscritura= true;
		} 
	return REscritura;
	}
	
	public boolean Constitucion( ArrayList<InformacionMateria> MateriasPasadas) {
		for (int j = 0; j < MateriasPasadas.size(); j++)
		{
			
		String Codigo =MateriasPasadas.get(j).getCodigo();
		if (Codigo == "DERE-1300"){
				RConstitucion= true;		
		}
		j++; 
		}
	return RConstitucion;
	}
	
	public ArrayList<InformacionMateria> verificarCbus( ArrayList<InformacionMateria> MateriasPasadas) {
		ArrayList<InformacionMateria> CbusAprobados= new ArrayList<InformacionMateria> ();
		for (int j = 0; j < MateriasPasadas.size(); j++)
		{
			
		String Codigo =MateriasPasadas.get(j).getCodigo();
		if (Codigo.substring(0,1)== "CB"){
				CbusAprobados.add(MateriasPasadas.get(j));
		}
		
		
		j++; 
		}
		return CbusAprobados;
		
	}

	public boolean cumplioCbus () {
		boolean cbucientifico=false;
		boolean cbuColombia=false;
		boolean cbuHumanidades=false;
		boolean cbuEpsilon=false;
		boolean cbuTipoE=false;
		boolean Emaq=false;
		boolean cele=false;
		int contador=0;
		
		
		ArrayList<InformacionMateria>  CbusAprobados =verificarCbus (MateriasPasadas);
		if (CbusAprobados.size()<7 ) {
			Rcbus= false;
		}
		else if (CbusAprobados.size()>6 ) {
				for (int j = 0; j <CbusAprobados.size(); j++)
				{	InformacionMateria curso =CbusAprobados.get(j);

					
					
					if(curso.getCodigo().contains("CBCO-")) {
						cbuColombia=true;
						System.out.print("Hay un CBCO");
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
					if(curso.getCodigo().contains("EMQB-")) {
						Emaq=true;
						
					}
					if(curso.getCodigo().contains("CELE-")) {
						cele=true;
						
					}
					if(curso.getCodigo().contains("TPOE-")) {
						contador+=1;
						if (contador >1){
							cbuTipoE= true;
						}
						
					}
					
					
					
			
				}
				}
				
				
		if (cbucientifico==true&&  cbuHumanidades==true  && cbuColombia==true  &&  cbuTipoE==true &&cbuEpsilon==true && cele==true && Emaq==true) {
			
			Rcbus= true;
			
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
				 if (!codigosaprobados.contains(Codigo)) {
					 cumple=false;
					 System.out.println("Hace falta materia:"+Codigo+"\n");
				 }
				
				
				}
			return cumple;
		
	}
	
	
	
	
	
	
	
	
	
	
}

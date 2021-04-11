package Sistema;
import java.awt.SystemColor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class Pensum {
	private ArrayList<InformacionMateria> MateriasPensum;
	

	
	public ArrayList<InformacionMateria> getMateriasPensum() {
		return MateriasPensum;
	}

	public Pensum(ArrayList<InformacionMateria> materiasPensum) {
		super();
		MateriasPensum = materiasPensum;
		

	}
	//Para variabilidad de Carreras cada una poses un total de creditos totales
	public int CreditosTotales(ArrayList<InformacionMateria> materiasPensum)
	{
		int CreditosTotales=0;
		for (int j = 0; j < materiasPensum.size(); j++)
		{
		CreditosTotales+=materiasPensum.get(j).getCreditos();
		}
		return CreditosTotales;
	}
	
	
}

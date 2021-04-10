package Sistema;

import java.util.ArrayList;
import java.util.Arrays;
public class InformacionMateria {
	









	@Override
	public String toString() {
		return "InformacionMateria [Creditos=" + Creditos + ", Nombre=" + Nombre + ", Codigo=" + Codigo
				+ ", Prerequisitos=" + Arrays.toString(Prerequisitos)
				+ ", Correquisitos=" + Arrays.toString(Correquisitos) + ", DuracionSemestre=" + DuracionSemestre
				 +"]";
	}


	protected int Creditos;
	protected String Nombre;
	protected String Codigo;
	protected String[] Prerequisitos;
	protected String[] Correquisitos;
	protected int DuracionSemestre;



	

	





	public InformacionMateria(int creditos, String nombre, String codigo,  String[] prerequisitos,
			String[] correquisitos, int duracionSemestre) {
		super();
		Creditos = creditos;
		Nombre = nombre;
		Codigo = codigo;
		Prerequisitos = prerequisitos;
		Correquisitos = correquisitos;
		DuracionSemestre = duracionSemestre;
	
	}


	public int getCreditos() {
		return Creditos;
	}


	public void setCreditos(int creditos) {
		Creditos = creditos;
	}


	public String getNombre() {
		return Nombre;
	}


	public void setNombre(String nombre) {
		Nombre = nombre;
	}


	public String getCodigo() {
		return Codigo;
	}


	public void setCodigo(String codigo) {
		Codigo = codigo;
	}




	public String[] getPrerequisitos() {
		return Prerequisitos;
	}


	public void setPrerequisitos(String[] prerequisitos) {
		Prerequisitos = prerequisitos;
	}


	public String[] getCorrequisitos() {
		return Correquisitos;
	}


	public void setCorrequisitos(String[] correquisitos) {
		Correquisitos = correquisitos;
	}


	public int getDuracionSemestre() {
		return DuracionSemestre;
	}


	public void setDuracionSemestre(int duracionSemestre) {
		DuracionSemestre = duracionSemestre;
	}
	
	
}

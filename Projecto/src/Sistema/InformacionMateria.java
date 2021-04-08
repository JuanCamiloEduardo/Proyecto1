package Sistema;

import java.util.ArrayList;
import java.util.Arrays;
public class InformacionMateria {
	@Override
	public String toString() {
		return "InformacionMateria [Creditos=" + Creditos + ", Nombre=" + Nombre + ", Codigo=" + Codigo
				+ ", Descripcion=" + Descripcion + ", Prerequisitos=" + Arrays.toString(Prerequisitos)
				+ ", Correquisitos=" + Arrays.toString(Correquisitos) + ", DuracionSemestre=" + DuracionSemestre + "]";
	}


	protected int Creditos;
	protected String Nombre;
	protected String Codigo;
	protected String Descripcion;
	protected String[] Prerequisitos;
	protected String[] Correquisitos;
	protected int DuracionSemestre;
	
	
	public InformacionMateria(int creditos, String nombre, String codigo, String descripcion,
			String[] prerequisitos, String[] correquisitos, int duracionSemestre) {
		super();
		Creditos = creditos;
		Nombre = nombre;
		Codigo = codigo;
		Descripcion = descripcion;
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


	public String getDescripcion() {
		return Descripcion;
	}


	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
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
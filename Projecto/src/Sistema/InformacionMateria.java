package Sistema;

import java.util.ArrayList;
import java.util.Arrays;
public class InformacionMateria {
	


	protected int Creditos;
	protected String Nombre;
	protected String Codigo;
	protected String[] Prerequisitos;
	protected String[] Correquisitos;
	protected int DuracionSemestre;
	protected int Semestre;
	protected double Nota;



	public InformacionMateria(int creditos, String nombre, String codigo, String[] prerequisitos,
			String[] correquisitos, int duracionSemestre, int semestre, double nota) {
		super();
		Creditos = creditos;
		Nombre = nombre;
		Codigo = codigo;
		Prerequisitos = prerequisitos;
		Correquisitos = correquisitos;
		DuracionSemestre = duracionSemestre;
		Semestre = semestre;
		Nota = nota;
	}


	@Override
	public String toString() {
		return "InformacionMateria [Creditos=" + Creditos + ", Nombre=" + Nombre + ", Codigo=" + Codigo
				+ ", Prerequisitos=" + Arrays.toString(Prerequisitos) + ", Correquisitos="
				+ Arrays.toString(Correquisitos) + ", DuracionSemestre=" + DuracionSemestre + ", Semestre=" + Semestre
				+ ", Nota=" + Nota + "]";
	}


	public int getCreditos() {
		return Creditos;
	}

	public String getNombre() {
		return Nombre;
	}

	public String getCodigo() {
		return Codigo;
	}

	public String[] getPrerequisitos() {
		return Prerequisitos;
	}

	public String[] getCorrequisitos() {
		return Correquisitos;
	}

	public int getSemestre() {
		return Semestre;
	}

	public double getNota() {
		return Nota;
	}

	public void setSemestre(int semestre) {
		Semestre = semestre;
	}


	public void setNota(double nota) {
		Nota = nota;
	}

	public int getDuracionSemestre() {
		return DuracionSemestre;
	}



	
	
}

package Consola;

import java.io.File;

import Sistema.Reader;

public class Consola {
	static File archivo=new File("Data/PENSUM.csv");

	public static void main(String[] args){
		Reader lector=new Reader();
		lector.cargarRecords(archivo);
	
		
		
		
	}

}

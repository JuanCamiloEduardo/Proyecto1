package Sistema;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import Sistema.InformacionMateria;



public class Reader {

	public void cargarRecords(File archivo)
	{
		if (archivo.exists())
		{
			try
			{
				BufferedReader br = new BufferedReader(new FileReader(archivo));
				String linea = br.readLine();
				while (linea != null)
				{
					String[] partes = linea.split("-");
					int Creditos = Integer.parseInt(partes[0]);
					String Nombre = partes[1];
					String Codigo = partes[2];
					String Descripcion = partes[3];
					String Prerrequisitos = partes[4];
					String[] ListaPrerrequisitos=Prerrequisitos.split(",");
					ListaPrerrequisitos=Prerrequisitos.split(",");
					String Correquisitos = partes[5];
					String[] ListaCorrequisitos=Correquisitos.split(",");
					ListaCorrequisitos=Correquisitos.split(",");
					int Duracion= Integer.parseInt(partes[6]);
					InformacionMateria Materia= new InformacionMateria(Creditos,Nombre,Codigo,Descripcion, ListaPrerrequisitos,ListaCorrequisitos,Duracion);
					System.out.println(Materia.toString());
					linea = br.readLine();
					
				}
				br.close();
			}
			catch (FileNotFoundException e)
			{
				System.out.println("No encontré el archivo ...");
				e.printStackTrace();
			}
			catch (IOException e)
			{
				System.out.println("Error de lectura ...");
				e.printStackTrace();
			}
			catch (NumberFormatException e)
			{
				System.out.println("Error en los datos: un número se pudo convertir a int ...");
				e.printStackTrace();
			}

		}
	}
}

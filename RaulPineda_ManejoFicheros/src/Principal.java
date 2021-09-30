import java.util.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Principal {
	static Scanner sc = new Scanner (System.in);
	//static String filename = "..\\RaulPineda_ManejoFicheros\\files";
	static String respf1 = "", respf2 = "", resp = "";
	static File file1 = null, file2 = null, file3 = null;
	
	public static void main(String[] args) throws IOException {
		
		
		File directorio = new File("ficheros");
		
		// Path path = Paths.get(filename);
		if (!directorio.exists()) {
            if (directorio.mkdirs()) {
                System.out.println("Directorio creado");
            } else {
                System.out.println("Error al crear directorio");
            }
            }
		
		
		
		
		
		
		do {
			System.out.println("1.Ejercicio 1, Crear un fichero y escribir una cadena de texto");
			System.out.println("2.Ejercicio 2, Crear un fichero y escribir dos textos y en función de si existe añadir uno u otro");
			System.out.println("3 Ejercicio 3.e solicite por teclado el nombre del fichero que se quiere crear, \n compruebe si dicho fichero existe y vuelva a pedir por teclado el texto que se\r\n"+ "quiere escribir");
			System.out.println("4.Ejercicio 4, Crear un fichero y escribir dos textos y en función de si existe añadir uno u otro");
			System.out.println("5.Ejercicio 5, Copiar el contenido de un fichero a otro");
			System.out.println("6.Salir");
			resp = sc.nextLine();
			
			switch (Integer.parseInt(resp)) {
				case 1:{
					Principal writeFicheros = new Principal();
					writeFicheros.escribirFichero1();
					System.out.println("Proceso uno finalizado");
					break;
				}
				case 2:{
					Principal writeFicheros2 = new Principal();
					writeFicheros2.escribirFichero2();
					System.out.println("Proceso uno finalizado");
					break;
				}
				case 3:{
					Principal writeFicheros3 = new Principal();
					writeFicheros3.crearFicheroTeclado();
					System.out.println("Proceso uno finalizado");
					break;
				}
				case 4:{
					Principal writeFicheros4 = new Principal();
					writeFicheros4.leerFichero();;
					System.out.println("Proceso uno finalizado");
					break;
				}
				case 5:{
					Principal writeFicheros5 = new Principal();
					writeFicheros5.copiarFichero();
					System.out.println("Proceso uno finalizado");
					break;
				}
			}
		} while (Integer.parseInt(resp) != 6);
		
		
	}
	
	
	
	
	
	public void escribirFichero1() throws IOException{
		String resp = "", resp2 = "";
		FileWriter fw = null; 
		System.out.println("Escribe el nombre del fichero_");
		respf1 = sc.nextLine();

		System.out.println("Escribe un texto_");
		resp2 = sc.nextLine();
		try {
			
			 file1 = new File(respf1); //creamos el objeto fichero
			fw = new FileWriter(file1);	// creamos el flujo entre  nuestro programa y el fichero
			fw.write(resp2);
			fw.flush();
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			// cerrar stream
			if(null != fw) {
				try {
					fw.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
				
			}
		}
	}
	
	public void escribirFichero2() throws IOException{
		String parf1 = "", parf2 = "";
		FileWriter fw = null;
		System.out.println("Escribe el nombre del fichero_");
		respf2 = sc.nextLine();

		System.out.println("Escribe el 1º parrafo_");
		parf1 = sc.nextLine();
		System.out.println("Escribe el 2º parrafo_");
		parf2 = sc.nextLine();
		
		try {
			 file2 = new File(respf2); 
			fw = new FileWriter(file2);	
			
			if(file2.exists()) {
				fw.write(parf1);
			}else {
				fw.write(parf2);
			}
			fw.flush();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			if(null != fw) {
				try {
					fw.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
				
			}
		}
	}
	
	public void crearFicheroTeclado() throws IOException{
		String resp = "", resp2 = "", text = "", junto = "", ruta;
		FileReader fileReader = null;
		File f = null;
		FileWriter fw = null; 
		
		System.out.println("Escribe el nombre del fichero_");
		ruta = sc.nextLine();

		System.out.println("Escribe un texto_");
		resp2 = sc.nextLine();
		try {
			
			 f = new File(ruta); //creamos el objeto fichero
			 if(f.exists()) {
				 fw = new FileWriter(f, true);	// creamos el flujo entre  nuestro programa y el fichero
					fw.write(resp2);
			 }else {
				 fw = new FileWriter(f);
				 fw.write(resp2);
			 }
			
			
			fw.flush();
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			// cerrar stream
			if(null != fw) {
				try {
					fw.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
				
			}
		}
	}
	
	private void leerFichero() throws IOException {
		String nombreFicheroR = "ficheler";
		FileReader fileReader = null;
		FileWriter fw = null; 
		try {
			File file = new File(nombreFicheroR);
			fw = new FileWriter(file);	// creamos el flujo entre  nuestro programa y el fichero
			fw.write("Esto es un fichero que esta siendo leido");
			fw.flush();
			
				// leer contenido del fichero
				fileReader = new FileReader(file);
				char[] buffer = new char[1024];
				while (-1 != fileReader.read(buffer)) {
					System.out.print(buffer);
				}
			 System.out.println("---------------------------------------");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// cerrar streams
			if (null != fileReader) {
				try {
					fileReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public void copiarFichero() throws IOException{
		FileReader fileReader = null;
		String text = "";
		FileWriter fw = null;
		System.out.println("Primero leemos el fichero que vamos a copiar el contenido");
		// leer contenido del fichero
		try {
			if (file1.exists()) {
				fileReader = new FileReader(file1);
				char[] buffer = new char[1024];
				fw = new FileWriter(file2);	
				
				while (-1 != fileReader.read(buffer)) {
					text = text + String.valueOf(buffer);
				}
				fw.write(text); // Pasamos por parametros el contenido de la copia del 1º fichero
				fw.flush();
			}
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			if(null != fw) {
				try {
					fw.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
				
			}
		}

	}
}

package AhorcadoConTimer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Diccionario {

	private String ruta;
	private String categoria;
	private File diccionario;
	private Scanner lector;
	private PrintWriter escritor;
	
	
	//CONSTRUCTORS
			//Constructor sin categorias
			public Diccionario(String ruta) throws IOException{
				this.ruta = ruta;
				diccionario = new File(ruta);
				
				//Si el archino no se encuentra fisicamente el directorio, lo creo.
				if(!diccionario.exists())
					diccionario.createNewFile();
				
				//Instancio el escritor y relleno el diccionario
				escritor = new PrintWriter(diccionario);
				rellenarDiccionario();

			}
			
			//Constructor con categorias
			public Diccionario(String ruta,String categoria) throws IOException{
				this.ruta = ruta;
				this.categoria = categoria;
				diccionario = new File(ruta);
				
				if(!diccionario.exists())
					diccionario.createNewFile();
				
				//Instancio el escritor y relleno el diccionario
				escritor = new PrintWriter(diccionario);
				rellenarDiccionario(categoria);
			}
	
	//METHODS
			public String getRuta() {
				return ruta;
			}

			public void setRuta(String ruta) {
				this.ruta = ruta;
			}

			public String getCategoria() {
				return categoria;
			}

			public void setCategoria(String categoria) {
				this.categoria = categoria;
			}

			public File getFile() {
				return diccionario;
			}

			public void setDiccionario(File diccionario) {
				this.diccionario = diccionario;
			}
			
			public void rellenarDiccionario(){
				ArrayList<String> palabras = new ArrayList();
				
						 palabras.add("Monitor");
						 palabras.add("Torre");
						 palabras.add("Altavoces");
						 palabras.add("Raton");
						 palabras.add("Teclado");
						 palabras.add("Impresora");
						 palabras.add("Escaner");
						 palabras.add("Reproductor");	     
						
				for(int i = 0;i<palabras.size();i++){
					escritor.println(palabras.get(i));
				}
				escritor.close();
			}
			
			public void rellenarDiccionario(String especialidad) throws IndexOutOfBoundsException{
				ArrayList<String> palabras = new ArrayList();
				especialidad = especialidad.toUpperCase();
				
				switch(especialidad){
					case "PERIFERICOS": 
						 palabras.add("Monitor");
						 palabras.add("Torre");
						 palabras.add("Altavoces");
						 palabras.add("Raton");
						 palabras.add("Teclado");
						 palabras.add("Impresora");
						 palabras.add("Escaner");
						 palabras.add("Reproductor");	     
					break;
					case "PROGRAMACION":
						 palabras.add("Metodo");
						 palabras.add("Clase");
						 palabras.add("Variable");
						 palabras.add("Constante");
						 palabras.add("Array");
						 palabras.add("Arraylist");
						 palabras.add("Bucle");
						 palabras.add("Condicional");
					break;
					case "HARDWARE":
						 palabras.add("Procesador");
						 palabras.add("Placa");
						 palabras.add("Grafica");
						 palabras.add("Disco");
						 palabras.add("Fuente");
						 palabras.add("Disipador");
					break;
				}
						
				for(int i = 0;i<palabras.size();i++){
					escritor.println(palabras.get(i));
				}
				escritor.close();
			}
			

			
			public String generarPalabra() throws FileNotFoundException{
				ArrayList<String> palabras = new ArrayList();
				lector=new Scanner(diccionario);
				
				while(lector.hasNext()){
					palabras.add(lector.next());
				}
				return palabras.get((int) (Math.random()*palabras.size()));
			}
			
	
}


package AhorcadoGraficoSinHerencia;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.*;

public class TestAhorcadograficoSinHerencia extends JFrame {
	
	public static void main(String[] args) throws FileNotFoundException{
		

		Ahorcado ahorcado = null;
		ControladorAhorcado controlador = null;


		
		String ruta;
		String nombreDiccionario;
		String categoria;
		boolean acceso = true;

		
		do{
			acceso=true;
			ruta = JOptionPane.showInputDialog(null,"Seleccione la ruta donde quiere instalar el juego");
			nombreDiccionario = JOptionPane.showInputDialog(null,"Seleccione el nombre que quieres darle al archivo que se creará");
			nombreDiccionario+=".txt";
			ruta+=nombreDiccionario;
			categoria = JOptionPane.showInputDialog(null,"Seleccione la categoria que quieras:\n-Perifericos.\n-Hardware.\n-Programacion.");
			
			try {
			
			ahorcado = new Ahorcado(new Diccionario(ruta,categoria));
			controlador = new ControladorAhorcado(ahorcado);
				
		} catch (IOException ex) {
			acceso=false;
			System.out.println("Disculpe, pero la ruta de instalacion insertada no es correcta");
			
		}
		catch (IndexOutOfBoundsException ex) {
				acceso=false;
				System.out.println("La categoria seleccionada no existe.");
				
			}
			
		}while(!acceso);
		
		
		Interface pantalla = new Interface();
	    pantalla.setTitle("TestPaintComponent");
	    pantalla.setSize(400, 800);
	    pantalla.setLocationRelativeTo(null); // Center the frame   
	    pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    pantalla.setVisible(true);
	}

}
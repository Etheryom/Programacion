package BarajaMVC;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Vista extends JFrame{
	/*Antigua propiedad para las filas del grid
	private static int filas_grid=1;*/
	
	private JPanel cartas;
	private JPanel boton;
	
	private JPanel fila1;
	private JPanel fila2;
	private JPanel fila3;
	private JPanel fila4;
	
	private JButton darCarta;
	
	private ModBaraja baraja = new ModBaraja();
	
	public Vista(){
		baraja.barajar();
		setLayout(new BorderLayout());
		
		/*Antiguo Modo de comportamiento
		cartas = new JPanel(new GridLayout(1,10));
		*/
		
		cartas = new JPanel(new GridLayout(4,1));
		fila1 = new JPanel(new GridLayout(1,10));
		fila2 = new JPanel(new GridLayout(1,10));
		fila3 = new JPanel(new GridLayout(1,10));
		fila4 = new JPanel(new GridLayout(1,10));
		
		cartas.add(fila1);
		cartas.add(fila2);
		cartas.add(fila3);
		cartas.add(fila4);
		
		darCarta=new JButton("Dar Carta");
		boton = new JPanel(new FlowLayout(1));
		boton.setBackground(Color.BLACK);
		
		boton.add(darCarta);
		add(cartas,BorderLayout.CENTER);
		add(boton,BorderLayout.SOUTH);
		
	}
	
	public JPanel getFila1(){
		return fila1;
	}
	public JPanel getFila2(){
		return fila2;
	}
	public JPanel getFila3(){
		return fila3;
	}
	public JPanel getFila4(){
		return fila4;
	}
	
	public JPanel getCartas(){
		return cartas;
	}
	
	/*Metodo antiguo de visualizacion
	public void setCartas(){
		cartas.setLayout(new GridLayout(++filas_grid,10));
	}*/
	
	
	public JPanel getBoton(){
		return boton;
	}
	
	public JButton getDarCarta(){
		return darCarta;
	}
	
	/*Antiguo: ya no requiero que me lo añada desde aqui, lo hago desde el controlador.
	public void addCarta(){
		cartas.add(baraja.darCarta());
	}*/
	
	public ModBaraja getBaraja(){
		return baraja;
	}
	
	
}

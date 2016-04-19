package BarajaMVC;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Vista extends JFrame{
	private static int filas_grid=1;
	
	private JPanel cartas;
	private JPanel boton;
	private JButton darCarta;
	
	private ModBaraja baraja = new ModBaraja();
	
	public Vista(){
		baraja.barajar();
		setLayout(new BorderLayout());
		
		cartas = new JPanel(new GridLayout(1,10));
		darCarta=new JButton("Dar Carta");
		boton = new JPanel(new FlowLayout(1));
		boton.setBackground(Color.BLACK);
		
		boton.add(darCarta);
		add(cartas,BorderLayout.CENTER);
		add(boton,BorderLayout.SOUTH);
		
	}
	
	public JPanel getCartas(){
		return cartas;
	}
	
	public void setCartas(){
		cartas.setLayout(new GridLayout(++filas_grid,10));
	}
	
	public JPanel getBoton(){
		return boton;
	}
	
	public JButton getDarCarta(){
		return darCarta;
	}
	
	public void addCarta(){
		cartas.add(baraja.darCarta());
	}
	public ModBaraja getBaraja(){
		return baraja;
	}
	
	
}

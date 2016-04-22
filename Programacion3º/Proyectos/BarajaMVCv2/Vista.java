package BarajaMVCv2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Vista extends JFrame{

	private JPanel cartas;
	private JPanel boton;
	
	private JPanel fila1;
	private JPanel fila2;
	private JPanel fila3;
	private JPanel fila4;
	
	private JButton darCarta;
	
	public Vista(){

		setLayout(new BorderLayout());
		
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
		fila1.setBackground(new Color(0,102,0));
		fila2.setBackground(new Color(0,102,0));
		fila3.setBackground(new Color(0,102,0));
		fila4.setBackground(new Color(0,102,0));
		
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
	
	public JPanel getBoton(){
		return boton;
	}
	
	public JButton getDarCarta(){
		return darCarta;
	}
	
	public void arrancar(Vista vista) {
		vista.setSize(1200,700);
		vista.setTitle("Carta");
		vista.setVisible(true);
	    vista.setLocationRelativeTo(null);
	    vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
}

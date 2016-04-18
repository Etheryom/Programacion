package Tema16Test;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import AhorcadoGraficoSinHerencia.Interface;
import Tema16Clases.ControlCircle;

public class TestControlCircle extends JFrame{
	private static ControlCircle c;
	private JPanel botones;
	private JButton incrementar;
	private JButton decrementar;
	
	public TestControlCircle(){
		setLayout(new BorderLayout());
		
		c = new ControlCircle(10);
		
		botones = new JPanel();
		incrementar = new JButton("Incrementar");
		decrementar = new JButton("Decrementar");
		
		botones.add(incrementar);
		botones.add(decrementar);
		
		add(c,BorderLayout.CENTER);
		add(botones,BorderLayout.SOUTH);
		
		Modificar m = new Modificar();
		
		incrementar.addActionListener(m);
		decrementar.addActionListener(m);
	}

	private class Modificar implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			Object myObject = e.getSource();
			
			if(myObject ==incrementar){
				c.setIncrementoRadio(10);
			}
			else if(myObject == decrementar){
				c.setDecrementoRadio(10);
			}
			
		}
		
	} 
	
	public static void main(String[] args) {
		
		TestControlCircle pantalla = new TestControlCircle();
	    pantalla.setTitle("Juego del Ahorcado");
	    pantalla.setSize(300, 200);
	    pantalla.setLocationRelativeTo(null); // Center the frame   
	    pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    pantalla.setVisible(true);
		
	}

}

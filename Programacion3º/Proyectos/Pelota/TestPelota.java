package Pelota;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class TestPelota extends JFrame {
	
	private Pelota pelotita;
	
	public TestPelota(){
		
	pelotita = new Pelota(100);
	pelotita.setBackground(Color.GREEN);
	
	add(pelotita);	
	
	Mover m = new Mover();
	addKeyListener(m);
		
	}

	
	private class Mover implements KeyListener{

		public void keyPressed(KeyEvent e) {	
		}

		public void keyReleased(KeyEvent e) {	
		}

		public void keyTyped(KeyEvent e) {
			char letra = e.getKeyChar();
			
			if(letra == 's')
				pelotita.moverAbajo(true);
			
			else if(letra == 'w')
				pelotita.moverAbajo(false);
			
			
			if(letra == 'a')
				pelotita.moverDerecha(false);
			
			else if(letra == 'd')
				pelotita.moverDerecha(true);
		}
		
	}
	

	public static void main(String[] args) {
		TestPelota p = new TestPelota();
	    p.setTitle("Juego del Ahorcado");
	    p.setSize(1368, 800);
	    p.setLocationRelativeTo(null); // Center the frame   
	    p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    p.setVisible(true);
	}
}

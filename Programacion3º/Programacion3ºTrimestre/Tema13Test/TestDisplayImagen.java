package Tema13Test;

import javax.swing.JFrame;

import Tema13Clases.DisplayImagen;

public class TestDisplayImagen extends JFrame{
	public TestDisplayImagen (){
		add(new DisplayImagen());
	}
	
	public static void main(String[] args) {
		
		TestDisplayImagen frame = new TestDisplayImagen();
	    frame.setTitle("My Display Imagen");
	    frame.setSize(400,200);
	    frame.setLocationRelativeTo(null); // Center the frame   
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true); 
	}

}

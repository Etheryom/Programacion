package Tema13Test;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Tema13Clases.MyMessagePanel;

public class TestMyMessagePanel extends JFrame {

	public TestMyMessagePanel(){
	//Creamos los messagePanels
	MyMessagePanel SD = new MyMessagePanel("This is Java");
	MyMessagePanel SI = new MyMessagePanel("This is Java");
	MyMessagePanel ID = new MyMessagePanel("This is Java");
	MyMessagePanel II = new MyMessagePanel("This is Java");
	
	//cambiamos los colores de fondo
	SD.setBackground(Color.red);
	SI.setBackground(Color.blue);
	ID.setBackground(Color.GREEN);
	II.setBackground(Color.WHITE);
	
	//Cambiamos las fuentes.
	
	SD.setFont(new Font("SansSerif", Font.BOLD, 24));
	SI.setFont(new Font("SansSerif", Font.ITALIC, 18));
	SI.setFont(new Font("SansSerif", Font.PLAIN, 18));
	SI.setFont(new Font("SansSerif", Font.PLAIN, 12));
	
	//Centramos el mensaje del primer panel
	SD.setCentered(true);
	
	//APlicacion un setlayout Grid y añadimos al frame
	setLayout(new GridLayout(2,2));
	add(SD);
	add(SI);
	add(ID);
	add(II);
	}

	public static void main(String[] args) {
		
		TestMyMessagePanel frame = new TestMyMessagePanel();
	    frame.setTitle("My Message Panel");
	    frame.setSize(400,200);
	    frame.setLocationRelativeTo(null); // Center the frame   
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);  
	}

}

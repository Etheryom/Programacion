package Tema16Test;

import javax.swing.JFrame;

import Tema16Clases.HandleEvent;

public class TestHandleEvent {

	public static void main(String[] args) {
		
		HandleEvent frame = new HandleEvent();
	    frame.setTitle("Handle Event");
	    frame.setSize(300,50);;
	    frame.setLocationRelativeTo(null); // Center the frame   
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true); 

	}

}


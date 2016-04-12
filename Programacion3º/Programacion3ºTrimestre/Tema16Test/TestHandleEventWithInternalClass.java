package Tema16Test;

import javax.swing.JFrame;

import Tema16Clases.HandleEvent;
import Tema16Clases.HandleEventWithInternalClass;

public class TestHandleEventWithInternalClass {

	public static void main(String[] args) {
		HandleEventWithInternalClass frame = new HandleEventWithInternalClass();
	    frame.setTitle("Handle Event with Internal Class");
	    frame.setSize(300,50);;
	    frame.setLocationRelativeTo(null); // Center the frame   
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true); 

	}

}

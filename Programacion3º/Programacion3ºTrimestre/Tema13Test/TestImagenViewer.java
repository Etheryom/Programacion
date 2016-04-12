package Tema13Test;

import java.awt.GridLayout;
import javax.swing.JFrame;
import Tema13Clases.ImagenViewer;

public class TestImagenViewer extends JFrame {
	
	public TestImagenViewer(){
		setLayout(new GridLayout(2,3));
		
		for(int i = 1;i<=6;i++){
			if(i%2==0)
				add(new ImagenViewer());
			else
				add(new ImagenViewer("francia.jpg"));	
		}
	}

	public static void main(String[] args) {
		
		TestImagenViewer frame = new TestImagenViewer();
	    frame.setTitle("My Display Imagen");
	    frame.setSize(500,300);
	    frame.setLocationRelativeTo(null); // Center the frame   
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	}

}

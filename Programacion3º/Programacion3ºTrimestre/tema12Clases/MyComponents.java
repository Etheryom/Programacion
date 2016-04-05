package tema12Clases;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyComponents extends JFrame{
	
	MyComponents(){
	JPanel arriba = new JPanel();
	JButton left = new JButton("Left");
	JButton center = new JButton("Center");
	JButton right = new JButton("Right");
	arriba.add(arriba);
	arriba.add(center);
	arriba.add(right);
	
	add(arriba);
	
	}
}

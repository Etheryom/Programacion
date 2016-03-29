package tema12Clases;

import java.awt.BorderLayout;

import javax.swing.*;


public class MyBorderLayout extends JFrame {

	public MyBorderLayout(){
		
		// Separacion horizontal - Separacion vertical
		setLayout( new BorderLayout(10,10));
		
		add(new JButton("NORTH"),BorderLayout.NORTH);
		add(new JButton("SOUTH"),BorderLayout.SOUTH);
		add(new JButton("WEST"),BorderLayout.WEST);
		add(new JButton("EAST"),BorderLayout.EAST);
		add(new JButton("CENTER"),BorderLayout.CENTER);
	}
}

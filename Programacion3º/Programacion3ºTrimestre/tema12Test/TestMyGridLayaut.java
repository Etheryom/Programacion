package tema12Test;

import javax.swing.JFrame;

import tema12Clases.MyGridLayout;

public class TestMyGridLayaut {

	public static void main(String[] args) {
	
		MyGridLayout miPanel = new MyGridLayout();
		
		miPanel.setTitle("Grid Layout");
		miPanel.setBounds(400,400,250,100);
		miPanel.setVisible(true);
		miPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

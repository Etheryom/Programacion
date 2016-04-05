package tema12Test;

import javax.swing.JFrame;

import tema12Clases.MyComponents;

public class TestMyComponents {

	public static void main(String[] args) {

		MyComponents miPanel = new MyComponents();
		miPanel.setTitle("My Components");
		miPanel.setSize(300,140);
		miPanel.setVisible(true);
		miPanel.setResizable(false);
		miPanel.setLocationRelativeTo(null);
		miPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


	}

}

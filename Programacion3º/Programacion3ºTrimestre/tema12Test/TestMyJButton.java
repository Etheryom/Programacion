package tema12Test;

import javax.swing.JFrame;

import tema12Clases.MyJButton;

public class TestMyJButton {

	public static void main(String[] args) {
		
		MyJButton miPanel = new MyJButton();
		miPanel.setTitle("MyJButton");
		miPanel.setVisible(true);
		miPanel.setLocationRelativeTo(null);
		miPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miPanel.setTitle("Imagen Icon");
		miPanel.pack();


	}
}

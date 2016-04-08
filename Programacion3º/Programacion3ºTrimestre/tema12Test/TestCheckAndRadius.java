package tema12Test;

import javax.swing.JFrame;

import tema12Clases.CheckAndRadius;


public class TestCheckAndRadius {

	public static void main(String[] args) {
		CheckAndRadius miPanel = new CheckAndRadius();
		miPanel.setTitle("CheckAndRadius");
		miPanel.setSize(400,400);
		miPanel.setVisible(true);
		miPanel.setLocationRelativeTo(null);
		miPanel.pack();
		miPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;

	}

}

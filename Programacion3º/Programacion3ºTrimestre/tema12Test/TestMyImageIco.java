package tema12Test;

import javax.swing.JFrame;

import tema12Clases.MyComponents;
import tema12Clases.MyImageIco;

public class TestMyImageIco {

	public static void main(String[] args) {
		MyImageIco miPanel = new MyImageIco();
		miPanel.setTitle("Imagen Icon");
		miPanel.setVisible(true);
		miPanel.setResizable(false);
		miPanel.pack();
		miPanel.setLocationRelativeTo(null);
		miPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

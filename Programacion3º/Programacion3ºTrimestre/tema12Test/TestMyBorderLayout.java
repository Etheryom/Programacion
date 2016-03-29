package tema12Test;

import javax.swing.JFrame;

import tema12Clases.MyBorderLayout;

public class TestMyBorderLayout {

	public static void main(String[] args) {
		
		MyBorderLayout miPanel = new MyBorderLayout();
		
		miPanel.setTitle("Border Layout");
		miPanel.setBounds(400,400,600,400);
		miPanel.setVisible(true);
		miPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

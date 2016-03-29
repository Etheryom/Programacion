package tema12Test;

import javax.swing.JFrame;

import tema12Clases.FlowLayout;

public class TestFlowLayout {

	public static void main(String[] args) {
		
		FlowLayout miPanel = new FlowLayout();
		
		miPanel.setSize(400,200);
		miPanel.setVisible(true);
		miPanel.setTitle("Flow Layout");
		miPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

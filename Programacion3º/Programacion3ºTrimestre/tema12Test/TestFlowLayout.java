package tema12Test;

import javax.swing.JFrame;

import tema12Clases.FlowLayout;

public class TestFlowLayout {

	public static void main(String[] args) {
		
		FlowLayout miPanel = new FlowLayout();
		
		/*
		miPanel.setSize(400,200);
		miPanel.setLocation(700,700);
		*/
		
		//setBound esta haciendo el mismo trabajo que setSize y setLocation
		miPanel.setBounds(700,700,400,200);
		
		miPanel.setVisible(true);
		miPanel.setTitle("Flow Layout");
		miPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

package tema12Test;

import javax.swing.JFrame;

import tema12Clases.Microhondas;

public class TestMicrohondas {

	public static void main(String[] args) {
		
		Microhondas micro = new Microhondas();
		micro.setTitle("Microhondas");
		micro.setBounds(700,400,600,400);
		micro.setVisible(true);
		micro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

	}

}

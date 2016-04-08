package Tema13Test;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Tema13Clases.FigurePanel;


public class TestFigurePanel extends JFrame {

	public TestFigurePanel() {
		
		int num = Integer.parseInt(JOptionPane.showInputDialog(null,"¿Cuantas figuras deseas crear?"));

		for(int i=0;i<num;i++){
			int tipo = Integer.parseInt(JOptionPane.showInputDialog(null,"Selecciona una:\n1.-Recta\n2.-Rectangulo\n3.-Rectangulo redondeado\n4.-Ovalo"));
			boolean fil = Boolean.parseBoolean(JOptionPane.showInputDialog(null,"¿Estará rellena la figura?\n True o False"));
			add(new FigurePanel(tipo,fil));
			
		}
		setLayout(new GridLayout((num/4)+1,4,5,5));
		//System.out.println(panel1.getType());
		//panel1.setType(2);
		//panel1.setFilled(false);
		
		
	}
		
		
	public static void main(String[] args) {
	    TestFigurePanel frame = new TestFigurePanel();
	    frame.setTitle("TestPaintComponent");
	    frame.setSize(400, 200);
	    frame.setLocationRelativeTo(null); // Center the frame   
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);  
	}

}

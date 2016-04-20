package BarajaMVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener {
	
	private Vista vista;

	public Controlador(Vista vista){
		this.vista = vista;
		
		vista.getDarCarta().addActionListener(this);
	}
	
	/*Antiguo metodo para dar las cartas en un solo gridLayout
	public void actionPerformed(ActionEvent e) {
		if(vista.getBaraja().getIndice()<=39){
			vista.addCarta();
			vista.paintAll(vista.getGraphics()); 
			
			if(vista.getBaraja().getIndice()==9)
				vista.setCartas();
			if(vista.getBaraja().getIndice()==18)
				vista.setCartas();
			if(vista.getBaraja().getIndice()==27)
				vista.setCartas();
			if(vista.getBaraja().getIndice()==40)
				vista.getDarCarta().setText("No quedan mas cartas");
		}
					
	}*/
	
	public void actionPerformed(ActionEvent e) {
		
		if(vista.getBaraja().getIndice()<=39){
			
			if(vista.getBaraja().getIndice()>29 && vista.getBaraja().getIndice()<=39)
				vista.getFila4().add(vista.getBaraja().darCarta());
			
			if(vista.getBaraja().getIndice()>19 && vista.getBaraja().getIndice()<=29)
				vista.getFila3().add(vista.getBaraja().darCarta());
			
			if(vista.getBaraja().getIndice()>9 && vista.getBaraja().getIndice()<=19)
				vista.getFila2().add(vista.getBaraja().darCarta());
			
			if(vista.getBaraja().getIndice()<=9)
				vista.getFila1().add(vista.getBaraja().darCarta());
			
			if(vista.getBaraja().getIndice()==40)
				vista.getDarCarta().setText("No quedan mas cartas");
			
			//Actualiza toda el frame
			vista.paintAll(vista.getGraphics());
		}
					
	}

}

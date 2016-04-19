package BajaraMVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener {
	
	private Vista vista;

	public Controlador(Vista vista){
		this.vista = vista;
		
		vista.getDarCarta().addActionListener(this);
	}
	
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
				System.out.println("No hay mas cartas");
		}
					
	}

}

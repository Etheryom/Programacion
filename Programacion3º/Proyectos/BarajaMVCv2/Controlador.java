package BarajaMVCv2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener {
	
	private Vista vista;
	private ModBaraja baraja;

	public Controlador(Vista vista){
		this.vista = vista;
		baraja = new ModBaraja();
		baraja.barajar();
		
		vista.getDarCarta().addActionListener(this);
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		if(baraja.getIndice()<=39){
			
			if(baraja.getIndice()>29 && baraja.getIndice()<=39)
				vista.getFila4().add(new VistaCarta(baraja.darCarta().getImage()));
			
			if(baraja.getIndice()>19 && baraja.getIndice()<=29)
				vista.getFila3().add(new VistaCarta(baraja.darCarta().getImage()));
			
			if(baraja.getIndice()>9 && baraja.getIndice()<=19)
				vista.getFila2().add(new VistaCarta(baraja.darCarta().getImage()));
			
			if(baraja.getIndice()<=9)
				vista.getFila1().add(new VistaCarta(baraja.darCarta().getImage()));
			
			if(baraja.getIndice()==40)
				vista.getDarCarta().setText("No quedan mas cartas");
			
			//Actualiza toda el frame
			vista.paintAll(vista.getGraphics());
		}
					
	}

}

package AhorcadoGraficoSinHerencia;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class AhorcadoGrafico extends JPanel {
	private int errores;
	
	public AhorcadoGrafico(int errores){
		this.errores = errores;
	}
	
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		int y = getHeight();
		int x = getWidth();
		
		
		switch(errores){
		
			//Pierna Izquierda
			case 6:
				g.drawLine(x-(x/3), (int) (y-(y/2.5)), x-(x/3)-60, (int) (y-(y/2.5))+140);
			
			//Pierna Derecha
			case 5:
				g.drawLine(x-(x/3), (int) (y-(y/2.5)), x-(x/3)+60, (int) (y-(y/2.5))+140);

			
			//Brazo Izquierdo
			case 4:
				g.drawLine(x-(x/3),(int) (y-(y/1.2))+100,x-(x/3)-70,(int) (y-(y/2))+30);

			
			//Brazo Derecho
			case 3:
				g.drawLine(x-(x/3),(int) (y-(y/1.2))+100,x-(x/3)+70,(int) (y-(y/2))+30);

			
			//Tronco
			case 2:
				g.drawLine(x-(x/3), (int) (y-(y/1.2))+75, x-(x/3), (int) (y-(y/2.5)));

			
			//Cabeza
			case 1:
				g.drawOval(x-(x/3)-39, (int) (y-(y/1.2)), 75,75 );

			
			//Patibulo
			case 0:
				g.drawLine(30, y, 30, 30);
				g.drawLine(30, 30, x-(x/3), 30);
				g.drawLine(x-(x/3), 30, x-(x/3), (int) (y-(y/1.2)));
		}
		
	}
	public int getErrores() {
		return errores;
	}


	public void setErrores(int errores) {
		this.errores = errores;
		repaint();
	}

}


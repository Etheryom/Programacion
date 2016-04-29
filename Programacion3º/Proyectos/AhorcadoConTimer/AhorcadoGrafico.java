package AhorcadoConTimer;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class AhorcadoGrafico extends JPanel {
	private int errores;

	public AhorcadoGrafico(int errores) {
		this.errores = errores;
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int y = getHeight();
		int x = getWidth();

		switch (errores) {
		case 10:
			// Patibulo
			g.drawLine((int) (x * 0.05), y, (int) (x * 0.05), (int) (y * 0.05));
			g.drawLine((int) (x * 0.05), (int) (y * 0.05), (int) (x * 0.65), (int) (y * 0.05));
			g.drawLine((int) (x * 0.65), (int) (y * 0.05), (int) (x * 0.65), (int) (y * 0.15));
			
			//cabeza
			g.drawOval((int)(x*0.55), (int)(y*0.2), 80, 80);
			//tronco
			g.drawLine((int)(x*0.55)+40,(int)(y*0.2)+80, (int)(x*0.55)+40, (int)(y*0.7));
			//pierna derecha
			g.drawLine((int)(x*0.55)+40,(int)(y*0.7), (int)(x*0.75), (int)(y*0.93));
			//pierna izquierda
			g.drawLine((int)(x*0.55)+40,(int)(y*0.7), (int)(x*0.55),(int)(y*0.93));
			//brazo derecho
			g.drawLine((int)(x*0.55)+40,(int)(y*0.2)+110, (int)(x*0.83), (int)(y*0.35));
			//brazo izquierdo
			g.drawLine((int)(x*0.55)+40,(int)(y*0.2)+110, (int)(x*0.50), (int)(y*0.36));
			
		break;
		case 9:
			// Patibulo
			g.drawLine((int) (x * 0.05), y, (int) (x * 0.05), (int) (y * 0.05));
			g.drawLine((int) (x * 0.05), (int) (y * 0.05), (int) (x * 0.65), (int) (y * 0.05));
			g.drawLine((int) (x * 0.65), (int) (y * 0.05), (int) (x * 0.65), (int) (y * 0.15));
			
			//cabeza
			g.drawOval((int)(x*0.55), (int)(y*0.2), 80, 80);
			//tronco
			g.drawLine((int)(x*0.55)+40,(int)(y*0.2)+80, (int)(x*0.55)+40, (int)(y*0.7));
			//pierna derecha
			g.drawLine((int)(x*0.55)+40,(int)(y*0.7), (int)(x*0.75), y);
			//pierna izquierda
			g.drawLine((int)(x*0.55)+40,(int)(y*0.7), (int)(x*0.55), y);
			//brazo derecho
			g.drawLine((int)(x*0.55)+40,(int)(y*0.2)+110, (int)(x*0.75), (int)(y*0.75));
			//brazo izquierdo
			g.drawLine((int)(x*0.55)+40,(int)(y*0.2)+110, (int)(x*0.55), (int)(y*0.75));
			
		break;
		
		// cuerpo doblado izquierda
		case 8:
			// Patibulo
			g.drawLine((int) (x * 0.05), y, (int) (x * 0.05), (int) (y * 0.05));
			g.drawLine((int) (x * 0.05), (int) (y * 0.05), (int) (x * 0.65), (int) (y * 0.05));
			g.drawLine((int) (x * 0.65), (int) (y * 0.05), (int) (x * 0.65), (int) (y * 0.15));

			// Cabeza
			g.drawOval((int) ((x * 0.65) - 40), (int) (y * 0.15), 80, 80);

			// tronco
			g.drawLine((int) ((x * 0.65)), (int) ((y * 0.15) + 80), (int) (x * 0.55), (int) (y * 0.72));

			// Brazo derecho
			g.drawLine((int) ((x * 0.65) - 7), (int) ((y * 0.15) + 100), (int) ((x * 0.63)), (int) (y * 0.7));

			// brazo izquierdo
			g.drawLine((int) ((x * 0.65) - 7), (int) ((y * 0.15) + 100), (int) ((x * 0.48)), (int) (y * 0.65));

			// Pierna Izquierda
			g.drawLine((int) (x * 0.55), (int) (y * 0.72), (int) (x * 0.40), (int) (y * 0.90));

			// Pierna Derecha
			g.drawLine((int) (x * 0.55), (int) (y * 0.72), (int) (x * 0.50), (int) (y * 0.95));

			break;
		// Cuerpo Doblado derecha
		case 7:
			// Patibulo
			g.drawLine((int) (x * 0.05), y, (int) (x * 0.05), (int) (y * 0.05));
			g.drawLine((int) (x * 0.05), (int) (y * 0.05), (int) (x * 0.65), (int) (y * 0.05));
			g.drawLine((int) (x * 0.65), (int) (y * 0.05), (int) (x * 0.65), (int) (y * 0.15));

			// Cabeza
			g.drawOval((int) ((x * 0.65) - 40), (int) (y * 0.15), 80, 80);

			// tronco
			g.drawLine((int) ((x * 0.65)), (int) ((y * 0.15) + 80), (int) (x * 0.8), (int) (y * 0.7));

			// Brazo derecho
			g.drawLine((int) ((x * 0.65) + 12), (int) ((y * 0.15) + 100), (int) ((x * 0.85)), (int) (y * 0.65));

			// brazo izquierdo
			g.drawLine((int) ((x * 0.65) + 12), (int) ((y * 0.15) + 100), (int) ((x * 0.72)), (int) (y * 0.7));

			// Pierna Izquierda
			g.drawLine((int) (x * 0.8), (int) (y * 0.7), (int) (x * 0.85), (int) (y * 0.95));

			// Pierna Derecha
			g.drawLine((int) (x * 0.8), (int) (y * 0.7), (int) (x * 0.95), (int) (y * 0.9));

			break;
		// Pierna Izquierda
		case 6:
			g.drawLine((int) (x * 0.65), (int) (y * 0.7), (int) (x * 0.6), (int) (y * 0.95));

			// Pierna Derecha
		case 5:
			g.drawLine((int) (x * 0.65), (int) (y * 0.7), (int) (x * 0.7), (int) (y * 0.95));

			// Brazo Izquierdo
		case 4:
			g.drawLine((int) (x * 0.65), (int) ((y * 0.15) + 105), (int) ((x * 0.6)), (int) (y * 0.75));

			// Brazo Derecho
		case 3:
			g.drawLine((int) (x * 0.65), (int) ((y * 0.15) + 105), (int) ((x * 0.70)), (int) (y * 0.75));

			// Tronco
		case 2:
			g.drawLine((int) ((x * 0.65)), (int) ((y * 0.15) + 80), (int) (x * 0.65), (int) (y * 0.7));

			// Cabeza
		case 1:
			g.drawOval((int) ((x * 0.65) - 40), (int) (y * 0.15), 80, 80);

			// Patibulo
		case 0:
			g.drawLine((int) (x * 0.05), y, (int) (x * 0.05), (int) (y * 0.05));
			g.drawLine((int) (x * 0.05), (int) (y * 0.05), (int) (x * 0.65), (int) (y * 0.05));
			g.drawLine((int) (x * 0.65), (int) (y * 0.05), (int) (x * 0.65), (int) (y * 0.15));
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

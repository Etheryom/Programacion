package AhorcadoGraficoConHerencia;
import java.awt.Graphics;

public class PiernaDerecha extends BrazoIzquierdo {
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		int y = getHeight();
		int x = getWidth();
		g.drawLine(x-(x/3), (int) (y-(y/2.5)), x-(x/3)+60, (int) (y-(y/2.5))+140);
		repaint();
	}
}

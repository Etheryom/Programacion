package AhorcadoGraficoConHerencia;
import java.awt.Graphics;

public class Tronco extends Cabeza{
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		int y = getHeight();
		int x = getWidth();
		g.drawLine(x-(x/3), (int) (y-(y/1.2))+75, x-(x/3), (int) (y-(y/2.5)));
		repaint();
	}

}

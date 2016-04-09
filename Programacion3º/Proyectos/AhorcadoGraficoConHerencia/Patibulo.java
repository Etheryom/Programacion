package AhorcadoGraficoConHerencia;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Patibulo extends JPanel {
	
	protected void paintComponent(Graphics g){
		int y = getHeight();
		int x = getWidth();
		g.drawLine(30, y, 30, 30);
		g.drawLine(30, 30, x-(x/3), 30);
		g.drawLine(x-(x/3), 30, x-(x/3), (int) (y-(y/1.2)));
	}

}

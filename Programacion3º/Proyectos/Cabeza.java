import java.awt.Graphics;

public class Cabeza extends Patibulo {

	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		int y = getHeight();
		int x = getWidth();
		g.drawOval(x-(x/3)-39, (int) (y-(y/1.2)), 75,75 );
		repaint();
	}
}

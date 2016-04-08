import java.awt.Graphics;

public class BrazoIzquierdo extends BrazoDerecho {
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		int y = getHeight();
		int x = getWidth();
		g.drawLine(x-(x/3),(int) (y-(y/1.2))+100,x-(x/3)-70,(int) (y-(y/2))+30);
		repaint();
	}

}

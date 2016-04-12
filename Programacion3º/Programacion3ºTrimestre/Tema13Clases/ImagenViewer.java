package Tema13Clases;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagenViewer extends JPanel {
	
	private int xCoordinate = 0;
	private int yCoordinate = 0;
	private boolean stretched = true;
	private Image flag;
	
	//Constructores
	public ImagenViewer(){
		this("flagspain.png");
	}

	public ImagenViewer(String image){
		flag = new ImageIcon("images/"+image).getImage();
	}
	
	//Getters and Setters
	public int getxCoordinate() {
		return xCoordinate;
	}

	public void setxCoordinate(int xCoordinate) {
		this.xCoordinate = xCoordinate;
		repaint();
	}

	public int getyCoordinate() {
		return yCoordinate;
	}

	public void setyCoordinate(int yCoordinate) {
		this.yCoordinate = yCoordinate;
		repaint();
	}

	public boolean isStretched() {
		return stretched;
	}

	public void setStretched(boolean stretched) {
		this.stretched = stretched;
		repaint();
	}

	public Image getFlag() {
		return flag;
	}

	public void setFlag(Image flag) {
		this.flag = flag;
		repaint();
	}
	
	//PaintComponent
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		
		int x = getWidth();
		int y = getHeight();
		
		if(stretched)
			g.drawImage(flag, xCoordinate, yCoordinate,x,y,this);
		else
		g.drawImage(flag, xCoordinate, yCoordinate,this);
		
	}
}

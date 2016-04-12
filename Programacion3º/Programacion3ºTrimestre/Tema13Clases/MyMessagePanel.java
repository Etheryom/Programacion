package Tema13Clases;

import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MyMessagePanel extends JPanel{
	
	private String message;
	private int xCoordinate = 20;
	private int yCoordinate = 20;
	private boolean centered;
	private int interval = 10;
	
	//Constructores
	public MyMessagePanel(){
		this("This is Java");
	}
	
	public MyMessagePanel(String message){
		this.message = message;
	}
	
	//Getters and Setters
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
		repaint();
	}

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

	public boolean isCentered() {
		return centered;
	}

	public void setCentered(boolean centered) {
		this.centered = centered;
		repaint();
	}

	public int getInterval() {
		return interval;
	}

	public void setInterval(int interval) {
		this.interval = interval;
	}
	
	
	//Paint Component
	protected void paintComponent(Graphics g) {
		    super.paintComponent(g);

		    if (centered) {
		      //Extraigo la fuente actual del panel
		      FontMetrics fm = g.getFontMetrics();

		      // Almaceno los valores de la altura y anchura del texto escrito
		      int stringWidth = fm.stringWidth(message);
		      int stringAscent = fm.getAscent();
		      // La coordenada x vale la mitad de la anchura del Frame - la mitad del ancho que ocupa el mensaje
		      // La coordenada y vale la mitad de la altura del frame - la mitad de la altura del mensaje
		      //Con esto conseguimos que en el centro del Frame , se encuentre el centro del mensaje.
		      xCoordinate = getWidth() / 2 - stringWidth / 2;
		      yCoordinate = getHeight() / 2 + stringAscent / 2;
		    }

		    g.drawString(message, xCoordinate, yCoordinate);
		  }

	//Metodos para eventos
	public void moveLeft() {
		    xCoordinate -= interval;
		    repaint();
		  }


	public void moveRight() {
		    xCoordinate += interval;
		    repaint();
		  }


	public void moveUp() {
		    yCoordinate -= interval;
		    repaint();
		  }

	public void moveDown() {
		    yCoordinate += interval;
		    repaint();
		  }

}

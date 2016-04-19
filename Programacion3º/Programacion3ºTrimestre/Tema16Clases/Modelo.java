package Tema16Clases;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Modelo extends JPanel { // Inner class
    private int radius = 400; // Default circle radius
    private int estado =0;
        
    /** Enlarge the circle */
    public void sonreir() {
      estado=1;
      repaint();
    }
    public void entristecer(){
    	estado=2;
    	repaint();
    }
    @Override 
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.setColor(Color.YELLOW);
      int x = getWidth();
      int y = getHeight();
      g.fillOval((x/2)-(radius/2), (y/2)-(radius/2), radius, radius);
      
      g.setColor(Color.black);
      g.fillOval((x/2)-100, (y/2)-100, 50, 50);
      g.fillOval((x/2)+50, (y/2)-100, 50, 50);
      if(estado==0)
    	  g.drawLine((x/2)-50, (y/2)+100, (x/2)+50, (y/2)+100);
      else if(estado==1)
    	  g.drawArc((x/2)-100,(y/2)-100, 200, 200,-170 , 160);
      else if( estado == 2)
    	 g.drawArc((x/2)-100,(y/2), 200, 200, 170, -160);
      //else
    	  
    }
  }  

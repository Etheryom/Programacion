package Tema16Clases;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Controlador implements ActionListener{
	  Vista view;
	  public Controlador(Vista v){
		  this.view = v;
		  view.getSonreir().addActionListener(this);
		  view.getEntristecer().addActionListener(this);
	  }
	  public void actionPerformed(ActionEvent e) {
		  JButton source = (JButton) (e.getSource());
		  Modelo c = (Modelo) view.getFace();
	       if ( (source.getText()).equals("Sonreir")) {
	    	  c.sonreir();
	       }
	       else
	    	   if ( (source.getText()).equals("Entristecer")) {
	 	    	  c.entristecer();
	 	       }
	       		
	     }
}

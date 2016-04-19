package Tema16Clases;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
  
public class Vista extends JFrame {
  private JButton sonreir = new JButton("Sonreir");
  private JButton entristecer = new JButton("Entristecer");
  private Modelo face = new Modelo();
    
  public Vista() {
    JPanel panel = new JPanel(); // Use the panel to group buttons
    panel.add(sonreir);
    panel.add(entristecer);
      
    this.add(face, BorderLayout.CENTER); // Add canvas to center
    this.add(panel, BorderLayout.SOUTH); // Add buttons to the frame 
      
   
  }
    
 public JButton getSonreir(){
	 return sonreir;
 }
 public JButton getEntristecer(){
	 return entristecer;
 }
   
 public JPanel getFace(){
	 return face;
 }
     
  
} 

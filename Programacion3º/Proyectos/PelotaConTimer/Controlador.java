package PelotaConTimer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;


public class Controlador implements ActionListener{
	private int maxWidth;
	private int maxHeight;
	private Vista vista;
	private ModPelota pelota;
	private VistaPelota vistaPelota;
	private boolean retornar = false;
	Timer timer;
	
	public Controlador(Vista vista){
		timer = new Timer(30,this);
		
		this.vista = vista;
		pelota = vista.getVistaPelota().getModPelota();
		
		vista.getMover().addActionListener(this);
	}
	
	public void moverDerecha(){
		timer.start();
		
		if(!retornar){
			if((pelota.getX()) +pelota.getDesplazamiento()+pelota.getRadio() >= maxWidth()){
				retornar = true;
			}
			if(!retornar){
				pelota.setX(pelota.getX()+pelota.getDesplazamiento());
			}
			vista.getVistaPelota().repaint();
			
		}
		
		if(retornar){
			
			if((pelota.getX()-pelota.getDesplazamiento()) <= 0){
				retornar = false;
			}
				pelota.setX(pelota.getX()-pelota.getDesplazamiento());
				vista.getVistaPelota().repaint();
		}
	}

	public void actionPerformed(ActionEvent e) {
		moverDerecha();
	}
	public int maxWidth(){
		return vista.getWidth();
	}
	
	public int maxHeight(){
		return vista.getHeight();
	}
}
package PelotaConTimer;

import javax.swing.JPanel;

public class ModPelota extends JPanel {
	
	private int x;
	private int y;
	private int desplazamiento;
	private int radio;
	
	public ModPelota(int radio){
		this.radio = radio;
		x=600;
		y=250;
		desplazamiento = 20;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getDesplazamiento() {
		return desplazamiento;
	}

	public void setDesplazamiento(int desplazamiento) {
		this.desplazamiento = desplazamiento;
	}

	public int getRadio() {
		return radio;
	}

	public void setRadio(int radio) {
		this.radio = radio;
	}

}
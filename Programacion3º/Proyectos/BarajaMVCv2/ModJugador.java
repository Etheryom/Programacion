package BarajaMVCv2;

public class ModJugador {
	
	private String nombre;
	private int puntacionActual;
	private int rondasGanadas;
	
	
	public ModJugador(){
		this("Anonimo");
		puntacionActual = 0;
		rondasGanadas = 0;
	}
	
	public ModJugador(String nombre){
		this.nombre=nombre;
		puntacionActual = 0;
		rondasGanadas = 0;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPuntacionActual() {
		return puntacionActual;
	}

	public void setPuntacionActual(int puntacionActual) {
		this.puntacionActual = puntacionActual;
	}

	public int getRondasGanadas() {
		return rondasGanadas;
	}

	public void setRondasGanadas(int rondasGanadas) {
		this.rondasGanadas = rondasGanadas;
	}
	
}

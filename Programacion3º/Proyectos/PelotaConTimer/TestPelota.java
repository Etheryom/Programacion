package PelotaConTimer;

public class TestPelota {

	public static void main(String[] args) {
		
		ModPelota pelota = new ModPelota(100);
		VistaPelota vistaPelota = new VistaPelota(pelota);
		Vista vista = new Vista(vistaPelota);
		Controlador controlador = new Controlador(vista);
		vista.arrancar();
	}

}
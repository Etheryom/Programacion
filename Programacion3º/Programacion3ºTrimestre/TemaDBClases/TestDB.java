package TemaDBClases;

public class TestDB {

	public static void main(String[] args) {
		
		Vista vista = new Vista();
		Controlador controlador  = new Controlador(vista);
		vista.arrancar();
	}

}

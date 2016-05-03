package TemaDBClases;

import TemaDBClases.Controlador.Controlador;
import TemaDBClases.Vista.Vista;

public class TestDB {

	public static void main(String[] args) {
		
		Vista vista = new Vista();
		Controlador controlador  = new Controlador(vista);
		vista.arrancar();
	}

}

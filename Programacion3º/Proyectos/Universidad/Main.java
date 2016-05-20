package Universidad;

import Universidad.Controlador.Controlador;
import Universidad.Vista.Login;
import Universidad.Vista.PanelPrincipal;
import Universidad.Vista.Programacion;

public class Main {

	public static void main(String[] args) {
		
		Login login = new Login();
		
		PanelPrincipal principal = new PanelPrincipal();
		principal.arrancar();
		
		Controlador controlador = new Controlador(principal,login);
		
	}

}

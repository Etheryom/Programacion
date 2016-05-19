package Universidad.Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Consultas extends ConexionBaseDeDatos {
	
	private Universitario universitario = new Universitario();
	
	public Consultas(){
		super();
	}
	
	public boolean login(String carnetUniversitario,String contrasenia){
		
		boolean conectado = false;
		ResultSet resulset = super.consultar("select * from universitario where u_cu = '"+carnetUniversitario+"' AND u_password = '"+contrasenia+"'");
		
		try {
			while(resulset.next()){
				conectado = true;
				
				String CU = resulset.getString("U_CU");
				String CI = resulset.getString("U_CI");
				String nombre = resulset.getString("U_NOMBRE");
				String password = resulset.getString("U_PASSWORD");
				
				getUniversitario().setCU(CU);
				getUniversitario().setCI(CI);
				getUniversitario().setNombre(nombre);
				getUniversitario().setPassword(password);
				getUniversitario().setMatricula(null);
			}
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "Usuario y contraseña incorrecto");
		}
		
		return conectado;
	}
	
	public Universitario getUniversitario() {
		return universitario;
	}

	public void setUniversitario(Universitario universitario) {
		this.universitario = universitario;
	}

}

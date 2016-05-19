package Universidad.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Universidad.Modelo.Informacion;
import Universidad.Modelo.Universitario;
import Universidad.Vista.Login;
import Universidad.Vista.PanelPrincipal;

public class Controlador implements ActionListener {
	
	private PanelPrincipal panelPrincipal;
	private Login login;
	private Informacion modelo;
	
	public Controlador(PanelPrincipal panelPrincipal,Login login){
		this.panelPrincipal = panelPrincipal;
		this.login = login;
		modelo = new Informacion();
		
		
		//Eventos
		panelPrincipal.getIngresar().addActionListener(this);
		login.getIngresar().addActionListener(this);
	}


	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == panelPrincipal.getIngresar()){
			login.arrancar();
		}
		
		if(e.getSource() == login.getIngresar()){
			boolean conectado = false;
			ResultSet resulset = modelo.consultar("select * from universitario where u_cu = '"+login.getCarnetUniversitario().getText()+"' AND u_password = '"+construirContraseņa(login.getPassword().getPassword())+"'");
			try {
				while(resulset.next()){
					conectado = true;
					
					String CU = resulset.getString("U_CU");
					String CI = resulset.getString("U_CI");
					String nombre = resulset.getString("U_NOMBRE");
					String password = resulset.getString("U_PASSWORD");
					
					modelo.getUniversitario().setCU(CU);
					modelo.getUniversitario().setCI(CI);
					modelo.getUniversitario().setNombre(nombre);
					modelo.getUniversitario().setPassword(password);
					modelo.getUniversitario().setMatricula(null);
					
					//Desaparece panel de login
					login.setVisible(false);
					//Mensaje de Bienvenida
					JOptionPane.showMessageDialog(null, "Bienvenid@ "+modelo.getUniversitario().getNombre());
				}
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, "Usuario y contraseņa incorrecto");
			}
			if(!conectado)
				JOptionPane.showMessageDialog(null, "Usuario y contraseņa incorrecto");
			else{
				//Desactivo ingresar y activo los demas
				panelPrincipal.getIngresar().setEnabled(false);
				panelPrincipal.getSalir().setEnabled(true);
				panelPrincipal.getProgramar().setEnabled(true);
				panelPrincipal.getVisualizar().setEnabled(true);
				

			}
			

			
		}
		
		
		
	}
	public String construirContraseņa(char[] caracteres){
		String password="";
			for(int i = 0;i<caracteres.length;i++){
				password+=caracteres[i];
			}
		return password;
	}

}

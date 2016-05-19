package Universidad.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Universidad.Modelo.Consultas;
import Universidad.Modelo.Universitario;
import Universidad.Vista.Login;
import Universidad.Vista.PanelPrincipal;

public class Controlador implements ActionListener {
	
	private PanelPrincipal panelPrincipal;
	private Login login;
	private Consultas modelo;
	
	public Controlador(PanelPrincipal panelPrincipal,Login login){
		this.panelPrincipal = panelPrincipal;
		this.login = login;
		modelo = new Consultas();
		
		
		//Eventos
		panelPrincipal.getIngresar().addActionListener(this);
		login.getIngresar().addActionListener(this);
		panelPrincipal.getSalir().addActionListener(this);
		panelPrincipal.getProgramar().addActionListener(this);
		panelPrincipal.getVisualizar().addActionListener(this);
	}


	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == panelPrincipal.getIngresar()){
			login.arrancar();
		}
		
		if(e.getSource() == login.getIngresar()){
			
			
			if(!modelo.login(login.getCarnetUniversitario().getText(), construirContraseña(login.getPassword().getPassword())))
				JOptionPane.showMessageDialog(null, "Usuario y contraseña incorrecto");
			else{
				//Desactivo ingresar y activo los demas
				panelPrincipal.getIngresar().setEnabled(false);
				panelPrincipal.getSalir().setEnabled(true);
				panelPrincipal.getProgramar().setEnabled(true);
				panelPrincipal.getVisualizar().setEnabled(true);
				
				//Desaparece panel de login
				login.setVisible(false);
				//Mensaje de Bienvenida
				JOptionPane.showMessageDialog(null, "Bienvenid@ "+modelo.getUniversitario().getNombre());
			}
		}
		
		if(e.getSource() == panelPrincipal.getSalir()){

			int n = JOptionPane.showConfirmDialog(
		            null,
		            "Le has dado al boton salir, ¿Seguro que quieres hacerlo?",
		            "",
		            JOptionPane.YES_NO_OPTION);

		        if(n == JOptionPane.YES_OPTION){
					
		        	//Desactivo todos los botones y activo ingresar
					panelPrincipal.getIngresar().setEnabled(true);
					panelPrincipal.getSalir().setEnabled(false);
					panelPrincipal.getProgramar().setEnabled(false);
					panelPrincipal.getVisualizar().setEnabled(false);
					
					//limpiamos los registros anteriores.
					login.getCarnetUniversitario().setText("");
					login.getPassword().setText("");
		       
		        }
			
		}
		
		if(e.getSource() == panelPrincipal.getProgramar()){
			System.out.println("programar");
		}
		if(e.getSource() == panelPrincipal.getVisualizar()){
			System.out.println("visualizar");
		}
		
		
	}
	public String construirContraseña(char[] caracteres){
		String password="";
			for(int i = 0;i<caracteres.length;i++){
				password+=caracteres[i];
			}
		return password;
	}

}

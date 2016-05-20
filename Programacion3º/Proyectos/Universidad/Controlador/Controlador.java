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
import Universidad.Vista.Programacion;

public class Controlador implements ActionListener {
	
	private PanelPrincipal panelPrincipal;
	private Login login;
	private Consultas modelo;
	private Programacion programacion;
	
	public Controlador(PanelPrincipal panelPrincipal,Login login){
		this.panelPrincipal = panelPrincipal;
		this.login = login;
		modelo = new Consultas();
		programacion= new Programacion(modelo.rellenarAsignaturas(modelo.asignaturasExistentes()));
		
		
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
				
				
				if(modelo.estaMatriculado(modelo.getUniversitario().getCU()))
					panelPrincipal.getProgramar().setEnabled(false);
				else
					panelPrincipal.getProgramar().setEnabled(true);
				
				if(modelo.estaMatriculado(modelo.getUniversitario().getCU()))
					panelPrincipal.getVisualizar().setEnabled(true);
				else
					panelPrincipal.getVisualizar().setEnabled(false);
				
				
				//Desaparece panel de login
				login.setVisible(false);
				
				if(modelo.estaMatriculado(modelo.getUniversitario().getCU())){
					modelo.getUniversitario().setMatricula(modelo.getUniversitario().getCU());
					JOptionPane.showMessageDialog(null, "Bienvenid@ "+modelo.getUniversitario().getNombre());
				}
				else{
					modelo.getUniversitario().setMatricula(null);
					JOptionPane.showMessageDialog(null, "Bienvenid@ "+modelo.getUniversitario().getNombre()+". Le recordamos que aun no se ha matriculado. Le "
							+ "aconsejamos que lo haga lo antes posible.");
				}
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
			programacion.getJl_cuci().setText("C.U.: "+modelo.getUniversitario().getCU()+"          C.I.: "+modelo.getUniversitario().getCI());
			programacion.getJl_NombreCompleto().setText("Nombre Completo: "+modelo.getUniversitario().getNombre());
			programacion.getJl_NumeroMatricula().setText("IDº Matricula: "+modelo.getUniversitario().getMatricula());
			programacion.arrancar();
			
			
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

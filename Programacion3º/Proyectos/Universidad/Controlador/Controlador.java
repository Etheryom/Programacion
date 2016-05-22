package Universidad.Controlador;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.AbstractButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import Universidad.Modelo.Asignaturas;
import Universidad.Modelo.Consultas;
import Universidad.Modelo.Universitario;
import Universidad.Vista.Login;
import Universidad.Vista.PanelPrincipal;
import Universidad.Vista.Programacion;
import Universidad.Vista.VistaAsignaturas;

public class Controlador implements ActionListener {
	
	private PanelPrincipal panelPrincipal;
	private Login login;
	private Consultas modelo;
	private Programacion programacion;
	private Programacion visualizacion;
	
	public Controlador(PanelPrincipal panelPrincipal,Login login){
		this.panelPrincipal = panelPrincipal;
		this.login = login;
		modelo = new Consultas();
		programacion= new Programacion(modelo.rellenarAsignaturas(modelo.asignaturasExistentes()),true);

		
		//Eventos
		panelPrincipal.getIngresar().addActionListener(this);
		login.getIngresar().addActionListener(this);
		panelPrincipal.getSalir().addActionListener(this);
		panelPrincipal.getProgramar().addActionListener(this);
		panelPrincipal.getVisualizar().addActionListener(this);
		programacion.getProgramar().addActionListener(this);
		programacion.getCancelar().addActionListener(this);
		
	}


	public void actionPerformed(ActionEvent e) {
		
		Calendar c = new GregorianCalendar();
		String dia = Integer.toString(c.get(Calendar.DATE));
		String mes = Integer.toString(c.get(Calendar.MONTH)+1);
		String annio = Integer.toString(c.get(Calendar.YEAR));
		

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
			programacion.getJl_cuci().setText("C.U.: "+modelo.getUniversitario().getCU()+"    C.I.: "+modelo.getUniversitario().getCI());
			programacion.getJl_NombreCompleto().setText("Nombre: "+modelo.getUniversitario().getNombre());
			programacion.getJl_Fecha().setText("Fecha: "+dia+"/"+mes+"/"+annio);
			programacion.getJl_NumeroMatricula().setText("IDº Matricula: "+modelo.getUniversitario().getMatricula());
			programacion.arrancar();
		}

		if(e.getSource() == programacion.getProgramar()){
			
			int n = JOptionPane.showConfirmDialog(
		            null,
		            "Estas seguro de querer finalizar la matriculacion?. Recuerda que no podrá realizarla de nuevo.",
		            "",
		            JOptionPane.YES_NO_OPTION);

		        if(n == JOptionPane.YES_OPTION){
					for(int i = 0;i<programacion.getAsignaturas().getComponentCount();i++){
						//Si esta seleccionada, modificamos los datos del modelo de asignaturas para posteriormente insertarlas en la bbdd
						if(((AbstractButton) ((Container) programacion.getAsignaturas().getComponent(i)).getComponent(0)).isSelected()){
							programacion.getAsigna().get(i).setSeleccionada(true);
							programacion.getAsigna().get(i).setGrupo((String) ((JComboBox) ((Container) programacion.getAsignaturas().getComponent(i)).getComponent(5)).getSelectedItem());
						}
					}
					
					//Matriculo las seleccionadas y las inserto en la tabla programacion
					for(int i = 0;i<programacion.getAsigna().size();i++){
						if(programacion.getAsigna().get(i).isSeleccionada())
							modelo.matricularAsignatura(modelo.getUniversitario().getCU(), programacion.getAsigna().get(i).getNombre(), programacion.getAsigna().get(i).getGrupo(), programacion.getAsigna().get(i).getSigla(), programacion.getAsigna().get(i).getTipo(), programacion.getAsigna().get(i).getCurso());	
					}
					
					//Creo ficha de matricula para el usuario
					modelo.registrarMatricula(modelo.getUniversitario().getCU(),dia+"/"+mes, dia+"/"+mes+"/"+annio);
					
					//asigno numero de matricula al modelo
					modelo.getUniversitario().setMatricula(modelo.getUniversitario().getCU());
					
					//cierro la ventana de matriculacion y activo la de visualizacion y desactivo la de programacion
					panelPrincipal.getProgramar().setEnabled(false);
					panelPrincipal.getVisualizar().setEnabled(true);
					programacion.dispose();
					
		        }
			
			//System.out.println( ((AbstractButton) ((Container) programacion.getAsignaturas().getComponent(0)).getComponent(0)).isSelected());
			//System.out.println( ((JComboBox) ((Container) programacion.getAsignaturas().getComponent(0)).getComponent(5)).getSelectedItem());
				

			
		}
		if(e.getSource() == programacion.getCancelar()){
			programacion.dispose();
		}
		
		if(e.getSource() == panelPrincipal.getVisualizar()){
			visualizacion  = new Programacion(modelo.asignaturasMatriculadas(),false);
			visualizacion.getJl_cuci().setText("C.U.: "+modelo.getUniversitario().getCU()+"    C.I.: "+modelo.getUniversitario().getCI());
			visualizacion.getJl_NombreCompleto().setText("Nombre: "+modelo.getUniversitario().getNombre());
			visualizacion.getJl_Fecha().setText("Fecha: "+dia+"/"+mes+"/"+annio);
			visualizacion.getJl_NumeroMatricula().setText("IDº Matricula: "+modelo.getUniversitario().getMatricula());
			visualizacion.arrancar();
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

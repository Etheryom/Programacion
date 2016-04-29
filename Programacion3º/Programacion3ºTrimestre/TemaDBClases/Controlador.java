package TemaDBClases;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

import Tema16Test.OracleDB;

public class Controlador implements ActionListener{
	
	private Vista vista;
	private Modelo modelo;
	private Connection connection;
	
	public Controlador(Vista vista){
		this.vista = vista;
			
		//Asocio evento al boton enviar
		vista.getAceptar().addActionListener(this);
	}
	
	//<<<----ALTERACION VISTA----->>>

	
	//<<<----METODOS BBDD----->>>
	public Connection getConnection(){
		return connection;
	}
	
	public void setConnection(Connection c){
		connection = c ;
	}
	
	public Controlador conectar() {
		
	    try {
	        Class.forName("oracle.jdbc.OracleDriver");
	        String BaseDeDatos = "jdbc:oracle:thin:@localhost:1521:XE";
	         
	        connection = DriverManager.getConnection(BaseDeDatos, modelo.getUsuario(),modelo.getPassword());            
	        if (connection != null){ 
	        	modelo.setEstado("Conectado");
	        	vista.getEstado().setText("Estado: " +modelo.getEstado());
	        	vista.getEstado().setForeground(Color.GREEN);
	        }
	    } 
	    
	    catch (Exception e) {
	        JOptionPane.showMessageDialog(null, "No se ha podido establecer conexion\ncon la Base de datos");
	    }       
	    return this;
	}

	//<<<----EVENTOS----->>>
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
		
		//Recojo los campos introducidos por el usuario y los guardo en el modelo
		modelo = new Modelo(vista.getCampoNombre().getText(),vista.getCampoPassword().getText());
		
		//Establezco conexion con la BBDD
		conectar();
	}

}

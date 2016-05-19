package Universidad.Modelo;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import TemaDBClases.Controlador.Controlador;

public class ConexionBaseDeDatos {
	
	  private String login = "DB_PROGRAMACION";
	  private String password = "universidad";
	  private String url = "jdbc:oracle:thin:@localhost:1521:XE";
	  private Connection connection = null;
	  
	  public ConexionBaseDeDatos(){
		  conectar(); 
	  }
	  
	  public ConexionBaseDeDatos conectar() {
		  System.out.println("Estableciendo conexion...");	
		    try {
		        Class.forName("oracle.jdbc.OracleDriver");
		         
		        connection = DriverManager.getConnection(url, login,password);            
		        if (connection != null){ 
		        	
		        	System.out.println("Conexion Establecida con la Base de datos");
		        }
		    } 
		    
		    catch (Exception e) {
	        	System.out.println("Ha sido imposible conectar con la Base de datos");
		        return null;
		    }       
		    return this;
		}
	  
		public ResultSet consultar(String sql) {
	        ResultSet resultado = null;
	        try {
	            Statement sentencia;
	            sentencia = connection.createStatement();
	            resultado = sentencia.executeQuery(sql);
	        } catch (SQLException e) {
	            System.out.println("Error en la consulta");
	            return null;
	        }        
	        return resultado;
	    }
		
		public boolean ejecutar(String sql) {
	        try {
	            Statement sentencia;
	            sentencia = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
	            sentencia.executeUpdate(sql);
	            connection.commit();
	            sentencia.close();
	        } catch (SQLException e) {
	            System.out.println("Error en la ejecucion");
	            return false;
	        }        return true;
	    }
}

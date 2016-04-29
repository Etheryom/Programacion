package Tema16Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class OracleDB {
	
	private Connection connection;
	
	public Connection getConnection(){
		return connection;
	}
	
	public void setConnection(Connection c){
		connection = c ;
	}
	
	public OracleDB conectar() {
	    try {
	        Class.forName("oracle.jdbc.OracleDriver");
	        String BaseDeDatos = "jdbc:oracle:thin:@localhost:1521:XE";
	         
	        connection = DriverManager.getConnection(BaseDeDatos, "hr","hr");            
	        if (connection != null) {
	            System.out.println("Conexion exitosa!");
	        } else {
	            System.out.println("Conexion fallida!");
	        }
	    } catch (Exception e) {
	        System.out.println("Imposible establecer la conexion");
	    }       
	    return this;
	}	
}
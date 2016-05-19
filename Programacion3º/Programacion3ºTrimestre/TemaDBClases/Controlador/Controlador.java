package TemaDBClases.Controlador;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import Tema16Test.OracleDB;
import TemaDBClases.Modelo.Modelo;
import TemaDBClases.Modelo.ModeloDepartamentos;
import TemaDBClases.Modelo.ModeloTrabajador;
import TemaDBClases.Vista.Vista;
import TemaDBClases.Vista.VistaConsulta;

public class Controlador implements ActionListener{
	
	private Vista vista;
	private VistaConsulta vistaConsulta;
	private Modelo modelo;
	private ModeloDepartamentos modeloDepartamentos;
	private Connection connection;
	private Statement sentencia;
	private ResultSet resultado;
	private ArrayList<String> departments;
	private ArrayList<ModeloTrabajador> trabajadores;
	
	
	
	public Controlador(Vista vista){
		this.vista = vista;
			
		//Instancio ArrayList y lo relleno con los resultados de la consulta
		departments = new ArrayList();
		
		//Instancio ArrayList y lo relleno con los resultados de la consulta
		trabajadores = new ArrayList();
		
		//Asocio evento al boton enviar
		vista.getAceptar().addActionListener(this);
		
	}
	
	
//<<<----METODOS DE LA CLASE----->>>
	
	//Retorna conectado o desconectado en funcion de si esta conectado o no.
	public String mensajeConectado(){
		if(modelo.getEstado())
			return "Conectado";
		else
			return "Desconectado";	
	}
	
	public String contruirContraseña(char[] caracteres){
		String password="";
			for(int i = 0;i<caracteres.length;i++){
				password+=caracteres[i];
			}
		return password;
	}
	
//<<<---METODOS PARA COMBOBOX!!--->>>
	
	//Hago la consulta e instancio el modeloDepartamento con un ArrayList de los distintos departamentos
	public void ConsultaCombo() throws SQLException{
		//Una vez realizado, realizo consulta para obtener los departamentos;
		resultado = consultar("select * from departments");
		
		//relleno el ArrayList
		departments = rellenarDepartaments();
	
	}
	
	//Relleno el combobox de la vista con los distintos departamentos
	public ArrayList<String> rellenarDepartaments() throws SQLException{
		
    	while(resultado.next()){
    		departments.add(resultado.getString("DEPARTMENT_NAME"));
    	}
		return departments;
	}
	
	
// <<<---METODOS PARA TRABAJADORES--->>>>
	
	//--1--Realizo consulta
	public ResultSet ConsultaTrabajadores(){
		String d = (String)vistaConsulta.getDepartments().getSelectedItem();
		resultado = consultar("select first_name,last_name from employees where department_id = (select department_id from departments where department_name = '"+d+"')");

		return resultado;
	}
	
	//--2--Relleno ArrayList con todos los departamentos obtenidos en la busqueda
	public ArrayList<ModeloTrabajador> rellenarTrabajadores() throws SQLException{
		//Limpio los trabajadores anteriores si los hay
		trabajadores.clear();
		
		while(resultado.next()){
			trabajadores.add( new ModeloTrabajador(resultado.getString("first_name"), resultado.getString("last_name")));
		}
		return trabajadores;
	}
	
	//--3-- Modifico la vista a partir del ArrayList con todos los trabajadores
	public void visualizarTrabajadores() throws SQLException{
		//Eliminamos (si los hay), los resultado anteriores.
		vistaConsulta.getNombres().removeAll();
		
		//Creamos JLabel
		JLabel label;
		
		//Contamos filas para las filas del gridlayout
		int f = 0;
		//while(resultado.next()){
		for(int i= 0;i<trabajadores.size();i++){

				label = new JLabel(trabajadores.get(i).getNombre(),SwingConstants.CENTER);
				label.setOpaque(true);
				
				if(f%2==0)
					label.setBackground(new Color(153,255,153));
				
				vistaConsulta.getNombres().add(label);
				
				label = new JLabel(trabajadores.get(i).getApellido(),SwingConstants.CENTER);
				label.setOpaque(true);
				if(f%2==0)
					label.setBackground(new Color(153,255,153));
				vistaConsulta.getNombres().add(label);
			
			
			//resultado.getString("last_name")
			vistaConsulta.getNombres().setLayout(new GridLayout(++f,1));
		}
		
		vistaConsulta.pack();
		vistaConsulta.paintAll(vistaConsulta.getGraphics());
	}
	
	//<<<----METODOS BBDD----->>>

	public Controlador conectar() {
		
	    try {
	        Class.forName("oracle.jdbc.OracleDriver");
	        String BaseDeDatos = "jdbc:oracle:thin:@localhost:1521:XE";
	         
	        connection = DriverManager.getConnection(BaseDeDatos, modelo.getUsuario(),modelo.getPassword());            
	        if (connection != null){ 
	        	modelo.setEstado(true);
	        	vista.getEstado().setText("Estado: " +mensajeConectado());
	        	vista.getEstado().setForeground(Color.GREEN);
	        }
	    } 
	    
	    catch (Exception e) {
	        JOptionPane.showMessageDialog(null, "No se ha podido establecer conexion\ncon la Base de datos");
	        return null;
	    }       
	    return this;
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
	
	public ResultSet consultar(String sql) {
        ResultSet resultado = null;
        try {
            Statement sentencia;
            sentencia = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            resultado = sentencia.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("Error en la consulta");
            return null;
        }        
        return resultado;
    }
	
	public Connection getConnection(){
		return connection;
	}
	
	public void setConnection(Connection c){
		connection = c ;
	}
	
	//<<<----EVENTOS----->>>
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == vista.getAceptar()){
			//Recojo los campos introducidos por el usuario y los guardo en el modelo
			modelo = new Modelo(vista.getCampoNombre().getText(),contruirContraseña(vista.getCampoPassword().getPassword()));
			
			//Establezco conexion con la BBDD
			conectar();
			
			if(connection!=null){
				//consulta para obtener los datos para el combobox
				try {
					ConsultaCombo();
					
					//Instancio el modelo con el ArrayList
					modeloDepartamentos = new ModeloDepartamentos(departments);
					
					//Instancio la vista del Departamento,dejo el que marca el combobox vacio y la arranco
					vistaConsulta = new VistaConsulta(modeloDepartamentos.getDepartamentos());
					vistaConsulta.getDepartments().setSelectedIndex(-1);
					vistaConsulta.arrancar();
					
					
					//cierro la ventana de la vista al salir de la vista
					MouseAdapter mouse = new MouseAdapter() {
						public void mouseExited(MouseEvent e) {
							vista.dispose();
						}
					};
					vista.addMouseListener(mouse);
					
					
					
					//Añado evento ActionListener al combobox
					vistaConsulta.getDepartments().addActionListener(this);
					
					//Cierro el resultado
					resultado.close();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "No se pudo realizar la consulta");
				}
			}
		}
		if(connection!=null){
			if(e.getSource() == vistaConsulta.getDepartments()){
				
				try {
					ConsultaTrabajadores();
					rellenarTrabajadores();
					visualizarTrabajadores();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "No se pudo extraer los nombres del Departamento");
				}
			}
		}
	}

}

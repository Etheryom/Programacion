package Universidad.Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
			}
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "Usuario y contraseña incorrecto");
		}
		
		return conectado;
	}
	
	public boolean estaMatriculado(String u_cu){
		boolean matriculado = false;
		ResultSet resulset = super.consultar("select m_id from matricula where m_id = '"+u_cu+"'");
		
		try {
			while(resulset.next()){
				//Si accede a este punto signica que ha habido un resultado y por tanto esta matriculado
				matriculado  = true;
	
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "La consulta sobre la matriculacion no ha podido ser realizada");
		}
		
		return matriculado;
	}
	
	public ResultSet asignaturasExistentes(){
		ResultSet resulset = super.consultar("select * from materia");
		return resulset;
	}
	
	public ArrayList<Asignaturas> rellenarAsignaturas(ResultSet resulset){
		ArrayList<Asignaturas> array  = new ArrayList();
		
		try {
			while(resulset.next()){
				array.add(new Asignaturas(resulset.getString("M_SIGLA"),resulset.getString("M_NOMBRE"),resulset.getInt("M_CURSO"),resulset.getString("M_TIPO")));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "La consulta sobre las asignaturas no  hapodido ser realizada");
		}
		
		return array;
	}
	
	public void matricularAsignatura(String p_matricula,String p_materia,String p_grupo,String p_sigla,String p_tipo,int p_curso){
		super.ejecutar("INSERT INTO programacion VALUES('"+p_matricula+"',null,'"+p_materia+"','"+p_grupo+"','"+p_sigla+"','"+p_tipo+"',"+p_curso+")");
	}
	
	public void registrarMatricula(String m_id,String m_gestion,String m_fecha ){
		super.ejecutar("INSERT INTO matricula VALUES('"+m_id+"','"+m_gestion+"','"+m_fecha+"')");
	}
	
	
	
	public Universitario getUniversitario() {
		return universitario;
	}

	public void setUniversitario(Universitario universitario) {
		this.universitario = universitario;
	}
	
	public ArrayList<Asignaturas> asignaturasMatriculadas(){
		ArrayList<Asignaturas> matriculadas = new ArrayList<>();
		
		ResultSet resulset = super.consultar("select p_matricula,p_materia,p_grupo,p_sigla,p_tipo,p_curso from programacion where p_matricula ='"+universitario.getCU()+"'");
		
		try {
			while(resulset.next()){
				matriculadas.add(new Asignaturas(resulset.getString("p_sigla"),resulset.getString("p_materia"),resulset.getInt("p_curso"),resulset.getString("p_tipo"),resulset.getString("p_grupo")));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "La consulta sobre las asignaturas no  hapodido ser realizada");
		}
	
		return matriculadas;
	}

}

package TemaDBClases;

public class Modelo {

	private String usuario;
	private String password;
	private String driver;
	private boolean estado;
	
	public Modelo(){
		this("hr","hr");
		estado = false;
		driver = "jdbc:oracle:thin:@localhost:1521:XE";
	}
	public Modelo(String usuario,String password){
		this.usuario = usuario;
		this.password = password;
		driver = "jdbc:oracle:thin:@localhost:1521:XE";
		estado = false;
	}
	
	
	public boolean getEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	

}

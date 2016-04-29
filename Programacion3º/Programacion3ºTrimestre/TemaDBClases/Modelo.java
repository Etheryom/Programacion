package TemaDBClases;

public class Modelo {
	private String usuario;
	private String password;
	private String driver;
	
	public Modelo(){
		this("hr","hr","jdbc:oracle:thin:@localhost:1521:XE");
	}
	public Modelo(String usuario,String password,String driver){
		this.usuario = usuario;
		this.password = password;
		this.driver = driver;
	}
	

}

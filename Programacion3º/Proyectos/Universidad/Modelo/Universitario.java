package Universidad.Modelo;

public class Universitario {

	private String CU;
    private String CI;
    private String nombre;
	private String password;
    private String matricula;

    public Universitario(){
    	
    }
    
    //<<<---GETTERS AND SETTERS--->>>
    public String getCU() {
		return CU;
	}

	public void setCU(String cU) {
		CU = cU;
	}

	public String getCI() {
		return CI;
	}

	public void setCI(String cI) {
		CI = cI;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}

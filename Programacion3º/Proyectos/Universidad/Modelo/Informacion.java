package Universidad.Modelo;

public class Informacion extends ConexionBaseDeDatos {
	
	private Universitario universitario = new Universitario();
	
	public Informacion(){
		super();
	}
	
	public Universitario getUniversitario() {
		return universitario;
	}

	public void setUniversitario(Universitario universitario) {
		this.universitario = universitario;
	}

}

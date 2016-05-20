package Universidad.Modelo;

public class Asignaturas {
	
	private String sigla;
	private String nombre;
	private int curso;
	private String tipo;
	private String grupo;
	private boolean seleccionada;
	
	public Asignaturas(String sigla,String nombre,int curso,String tipo){
		this.sigla = sigla;
		this.nombre = nombre;
		this.curso = curso;
		this.tipo = tipo;
		grupo = "";
		seleccionada = false;
	}
	
	///<<<---GETTERS AND SETTERS--->>>
	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCurso() {
		return curso;
	}

	public void setCurso(int curso) {
		this.curso = curso;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public boolean isSeleccionada() {
		return seleccionada;
	}

	public void setSeleccionada(boolean seleccionada) {
		this.seleccionada = seleccionada;
	}

}

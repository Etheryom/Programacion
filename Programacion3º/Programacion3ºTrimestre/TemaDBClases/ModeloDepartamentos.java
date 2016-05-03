package TemaDBClases;

import java.util.ArrayList;

public class ModeloDepartamentos {
	
	private ArrayList <String> departamentos;
	private String departamentoSeleccionado;
	
	public ModeloDepartamentos(ArrayList departamentos, String departamentoSeleccionado ){
		this.departamentos = departamentos; 
		this.departamentoSeleccionado = departamentoSeleccionado;
	}
	
	
//<<<---- GETTERS AND SETTERS ---- >>>
	public ArrayList <String> getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(ArrayList <String> departamentos) {
		this.departamentos = departamentos;
	}

	public String getDepartamentoSeleccionado() {
		return departamentoSeleccionado;
	}

	public void setDepartamentoSeleccionado(String departamentoSeleccionado) {
		this.departamentoSeleccionado = departamentoSeleccionado;
	}
	
	

}

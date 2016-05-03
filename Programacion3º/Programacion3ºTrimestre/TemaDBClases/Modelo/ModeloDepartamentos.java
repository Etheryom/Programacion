package TemaDBClases.Modelo;

import java.util.ArrayList;

public class ModeloDepartamentos {
	
	private ArrayList <String> departamentos;
	
	public ModeloDepartamentos(ArrayList <String> departamentos){
		this.departamentos = departamentos; 
	}
	
	
//<<<---- GETTERS AND SETTERS ---- >>>
	public ArrayList <String> getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(ArrayList <String> departamentos) {
		this.departamentos = departamentos;
	}
}

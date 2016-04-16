package AhorcadoGraficoSinHerencia;

import java.io.IOException;
import java.util.ArrayList;

public class ControladorAhorcado {

	private Ahorcado ahorcado;
	private String letterIntroduced;
	private int errores;
	
	
	public ControladorAhorcado() throws IOException{
		ahorcado = new Ahorcado();
		letterIntroduced = "";
		errores = 0;
	}
	
	public ControladorAhorcado(Ahorcado ahorcado){
		this.ahorcado=ahorcado;
		letterIntroduced = "";
		errores = 0;
	}
	
	public Ahorcado getAhorcado(){
		return ahorcado;
	}
	public int getErrores(){
		return errores;
	}
	public void setErrores(int errores){
		this.errores=errores;
	}
	
	public String getLetterIntroduced(){
		return letterIntroduced;
	}
	
	public void setLetterIntroduced(String letras){
		letterIntroduced = letras;
	}
	

	public void actualizarMascara(String letter){
		char letra = letter.toUpperCase().charAt(0);
		char[] mascara = ahorcado.getMaskWord().toUpperCase().toCharArray();
		
		for(int i = 0;i<ahorcado.getWord().length();i++){
			if(ahorcado.getWord().toUpperCase().charAt(i) == letra)
				mascara[i] =letra;
		}
		ahorcado.setMaskWord("");
		for(int i =0;i<mascara.length;i++){
			ahorcado.setMaskWord(ahorcado.getMaskWord()+mascara[i]);
		}
	}
	
	//Comprueba la letra en la palabra word tanto en mayusculo como en minuscula
	public boolean checkLetter(String letter){
		letterIntroduced+=letter+"|";
		
			
		if(ahorcado.getWord().indexOf(letter.toLowerCase())>-1 || (ahorcado.getWord().indexOf(letter.toUpperCase())>-1))
			return true;
		
		else{
			errores++;
			return false;
		}
		
	}
	
	/* @overload -> Sobrecargo el metodo para comprobar si la letra esta en las introducidas anteriomente escritas
	 */
	public boolean checkLetter(String letter, String letterIntroduced){
		
		if(letterIntroduced.indexOf(letter)>-1 || (letterIntroduced.indexOf(letter.toUpperCase())>-1))
			return true;
		
		else{
			return false;
		}

	}
	//Si la mascara coincide con la palabra
	public boolean ganar(){
		if(equals(ahorcado.getMaskWord()))
			return true;
		else
			return false;
	}
	
	//Si coincide con la palabra word del ahorcado gana
	public boolean ganar(String insertada){
		if(equals(insertada))
			return true;
		else
			return false;
	}
	
	/*Convierto tanto la palabra del ahorcado como la insertada a mayusculas para 
	 no ser case sensitive y comparo ambos String con compareTo() */
	public boolean equals(String insertada){
		insertada = insertada.toUpperCase();
		String palabra = ahorcado.getWord().toUpperCase();
		
		if(insertada.compareTo(palabra)<0)
			return false;
		else if(insertada.compareTo(palabra)>0)
			return false;
		else
			return true;
		
	}
}
package AhorcadoConTimer;

import java.io.IOException;

public class Ahorcado {

	private Diccionario diccionario;
	private String word;
	private String maskWord;
	
	//Crea un ahorcado de tecnologia por defecto
	public Ahorcado() throws IOException{
		diccionario = new Diccionario("C:\\tecnologia.txt","perifericos");
		word = diccionario.generarPalabra();
		maskWord= createMaskWord();
		
	}
	
	//Crea un ahorcado a tu eleccion
	public Ahorcado(Diccionario diccionario) throws IOException{
		this.diccionario = diccionario;
		word = diccionario.generarPalabra();
		maskWord= createMaskWord();
		
	}
	
	public Diccionario getDiccionario() {
		return diccionario;
	}

	public void setDiccionario(Diccionario diccionario) {
		this.diccionario = diccionario;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getMaskWord() {
		return maskWord;
	}

	public void setMaskWord(String maskWord) {
		this.maskWord = maskWord;
	}

	
	public String createMaskWord(){
		String mask="";
		for(int i=0;i<word.length();i++){
			mask+="*";
		}
		return mask;
	}

}
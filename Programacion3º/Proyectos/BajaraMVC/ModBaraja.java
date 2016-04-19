package BajaraMVC;

import java.util.ArrayList;

public class ModBaraja {
	
	private ArrayList<ModCarta> baraja;
	
	private static int indice;
	
	public ModBaraja(){
		
		baraja = crearBaraja();
		indice = 0;
		
	}
	public int getIndice(){
		return indice;
	}
	public void setIndice(){
		indice++;
	}
	
	public ArrayList crearBaraja(){
		baraja = new ArrayList();
		int i;
		int j;
		String palo="";
		
		for(i = 0;i<4;i++){
			
			switch(i){
				case 0: palo = "Basto";break;
				case 1: palo = "Espada";break;
				case 2: palo = "Copa";break;
				case 3: palo = "Oro";break;
			}
			
			for(j=1;j<=10;j++){	
				baraja.add(new ModCarta(palo,j));
			}
		}
		return baraja;
	}
	
	public ArrayList getBaraja(){
		return baraja;
	}
	
	public ModCarta darCarta(){
		return baraja.get(indice++);
	}
	
	public void barajar(){
		int random;
		
		for(int i = 0;i<baraja.size();i++){
			random = (int) ((Math.random()*baraja.size()));
			
			Object aux = baraja.get(i);
		
			baraja.set(i, baraja.get(random));
			baraja.set(random, (ModCarta) aux);
		}
		
	}


}

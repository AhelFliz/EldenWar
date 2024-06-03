package Clases;

import Personaje.Personaje;

public class Confessor extends Personaje {
	
	public Confessor(String nombre, int vida, int misiles_ronda, String tipoPersonaje) {
		
		super(nombre, vida, misiles_ronda, tipoPersonaje);
	}
	
	@Override
	public String ataque(int misilesAtaque, Personaje atacado) { // Metodo para el ataque 
		
		String frasEfec = "\n";
		
		if (atacado.getTipoPersonaje().equals("Prisoner")) {
        	
        	atacado.setVida(atacado.getVida() - (misilesAtaque*2));
        	frasEfec = "Es muy efectivo hace " + misilesAtaque*2 + " de daño\n";
	        	
		} 
    	else {
    		
    		atacado.setVida(atacado.getVida() - misilesAtaque);
    	}
    
	    
		misiles_ronda -= misilesAtaque;
		
		return nombre + " ("+ tipoPersonaje +") " + "ha atacado a " + atacado.getNombre() + " ("+ atacado.getTipoPersonaje() +") "+ "con " + misilesAtaque + " misiles\n" + frasEfec ;
	
	}


}
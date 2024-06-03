package Clases;

import Personaje.Personaje;

public class Astrologer extends Personaje {
	
	public Astrologer(String nombre, int vida, int misiles_ronda, String tipoPlaneta) {
		
		super(nombre, vida, misiles_ronda, tipoPlaneta);
	}
	
	@Override
	public String ataque(int misilesAtaque, Personaje atacado) { // Metodo para el ataque 
		
		String frasEfec = "\n";
		
		if (atacado.getTipoPersonaje().equals("Hero")) {
        	
        	atacado.setVida(atacado.getVida() - (misilesAtaque*2));
        	frasEfec = "Es muy efectivo hace " + misilesAtaque*2 + " de daño\n";
	        	
		}else {
    		
    		atacado.setVida(atacado.getVida() - misilesAtaque);
    	}
    
		misiles_ronda -= misilesAtaque;
		
		return nombre + " ("+ tipoPersonaje +") " + "ha atacado a " + atacado.getNombre() + " ("+ atacado.getTipoPersonaje() +") "+ "con " + misilesAtaque + " misiles\n" + frasEfec ;
	
	}


}
package Personaje;

import java.util.ArrayList;

public class ArrayPersonajes {
	
	public static int numPerso;
	
	public static int turno;
	
	public static String resumenRonda = "";
	
	public static int vida = 200;
	
	public static int minJug = 3;
	
	public static int maxJug = 6;
	
	public static int numMis = 100;
 

    public static void setNumPerso(int numP) {
    	numPerso = numP;
    }
    
    public static int getNumPerso() {
        return numPerso;
    }

	public static ArrayList<Personaje> personajes = new ArrayList<>();

    
}

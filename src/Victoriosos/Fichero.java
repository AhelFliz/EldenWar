package Victoriosos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Fichero {

	static String ruta = "src/Victoriosos/ganadores.txt";
	static ArrayList<Datos> listaDatos = new ArrayList<Datos>();
	
	
	public static void guardarFichero(String ganador) { // Guarda los datos en un array separados en nombres y victorias 
		
		boolean existe = false;
		
		try {	
	            FileReader fr = new FileReader(ruta);
	            BufferedReader br = new BufferedReader(fr);
	            String line = "";
	            listaDatos.clear();
	            
	            do {
	            	if((line = br.readLine()) != null){
		            	String[] lineP = line.split(" ");
		            	Datos d = new Datos(lineP[0], Integer.parseInt(lineP[1]));
		            	
		            	listaDatos.add(d);
	            	}
	            	
	            }while((line = br.readLine()) != null);
	      
	            
	            fr.close();
	            br.close();
	        } catch (IOException e) {
	            System.out.println("Error E/S: " + e);
	        } 
		
			for(Datos datos: listaDatos){
	        	
	        	if(datos.getNombre().equalsIgnoreCase(ganador)){
	        		
	        		datos.setVictorias(datos.getVictorias() + 1 );
	        		
	        		existe = true;
	        		
	        		break;
	        	}
	        }
			if(!existe){
				Datos d = new Datos(ganador, 1);
				listaDatos.add(d);
			}
			
			
			escribirFichero();
	}
	
	public static void escribirFichero() { // Funcion para escribir el fichero 

        try {

			FileWriter fw = new FileWriter(ruta,false);
			
	        BufferedWriter bw = new BufferedWriter(fw);			   
		
	        for(Datos d: listaDatos ) {
	        	
	        	bw.write(d.getNombre() + " " + d.getVictorias() + "\n");
	        }
			   
			bw.close();
			
			fw.close();

        }catch(IOException e){
        	
            System.out.println("Error E/S: " + e);
        }	
	}
	
	public static void leerFichero() { // Funcion para leer el fichero 
	        
	        try {
	            FileReader fr = new FileReader(ruta);
	            BufferedReader br = new BufferedReader(fr);
	            String line;
	            
	            while ((line = br.readLine()) != null) {
	                System.out.println(line);
	            }
	            
	            fr.close();
	            br.close();
	        } catch (IOException e) {
	            System.out.println("Error E/S: " + e);
	        }
	}
}

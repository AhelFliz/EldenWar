package Musica;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;

public class CancionMenu {
	
	private static Clip clip;
	private static Clip clip02;

	
    public static void MusicaMenu(String nombreSonido) {
        
    	try {
            if (clip != null && clip.isOpen()) {
                clip.stop();  
                clip.close(); 
            }
            
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(nombreSonido).getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            System.out.println("Error al reproducir el sonido: " + ex.getMessage());
        }
    
    	
    }
    
    public static void SonidoBoton(String nombreSonido) {
        
    	try {
            if (clip02 != null && clip02.isOpen()) {
            	clip02.stop();  
            	clip02.close(); 
            }

            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(nombreSonido).getAbsoluteFile());
            clip02 = AudioSystem.getClip();
            clip02.open(audioInputStream);
            clip02.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            System.out.println("Error al reproducir el sonido: " + ex.getMessage());
        }
    
    	
    }
}
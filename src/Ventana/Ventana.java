package Ventana;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import Menu.EventoMenu;
import Musica.CancionMenu;

public class Ventana extends JFrame{
	
	
	public Ventana() {
		
        ImageIcon originalIcon = new ImageIcon("src/Ventana/prueba2.png");
        Image scaledImage = originalIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon cursorIcon = new ImageIcon(scaledImage);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image cursorImage = cursorIcon.getImage();
        Point cursorHotSpot = new Point(0, 0);
        Cursor customCursor = toolkit.createCustomCursor(cursorImage, cursorHotSpot, "Custom Cursor");      
	
		setTitle("Elden War");
		setBounds(110, 80, 1440, 900);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setCursor(customCursor);
        
		CancionMenu.MusicaMenu("src/Clips/MusicaMenu.wav");
		
		add(new EventoMenu());
		
		setVisible(true);
	}
	
}

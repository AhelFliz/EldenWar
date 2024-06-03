package Creador;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Configuracion.EventoConfiguracion;
import Menu.EventoMenu;
import Musica.CancionMenu;

public class EventoCreador extends JPanel implements ActionListener{
	
	private JLabel JLFondo;
	private JButton JBAtras;
	private ImageIcon Icono01;
	
	public EventoCreador() {
		
		setLayout(null);
		
        Icono01 = new ImageIcon("src/Creador_Img/BotonAtras.png");
		JBAtras = new JButton(Icono01);
		JBAtras.setBounds(1100, 590, 500,400 ); 
		JBAtras.setContentAreaFilled(false);
		JBAtras.setBorder(null);
		
		JBAtras.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
		    
				
			}
	
			@Override
			public void mousePressed(MouseEvent e) {
			    CancionMenu.MusicaMenu("src/Clips/SonidoAtras.wav");				
			}
	
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
	
			@Override
			public void mouseEntered(MouseEvent e) {
				JBAtras.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				JBAtras.setBackground(Color.RED); // Cambia el color de fondo al pasar el mouse sobre el botón
	
				
			}
	
			@Override
			public void mouseExited(MouseEvent e) {
				JBAtras.setCursor(Cursor.getDefaultCursor());
				JBAtras.setBackground(null);
				
			}
        
       
		});
        

	    add(JBAtras);
	    JBAtras.addActionListener(this);
	    
		JLFondo = new JLabel();
	    JLFondo.setBounds(0, 0, 1440, 900); 
	    JLFondo.setIcon(new ImageIcon("src/Creador_Img/CreadorImagen01.jpeg"));
	    add(JLFondo);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		JFrame evento = (JFrame) SwingUtilities.getWindowAncestor(this);
		
		if (e.getSource() == JBAtras) {
	          evento.remove(this);
	          evento.getContentPane().add(new EventoMenu());
	          evento.setVisible(true);
	        }
		
	}

}

package Personaje;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Musica.CancionMenu;

public class EventoSeleccionPersonaje extends JPanel implements ActionListener{
	
	private JLabel JLFondo;
	private JLabel jLTipoPersonaje;
	private JButton botonPersonaje1;
	private JButton botonPersonaje2;
	private JButton botonPersonaje3;
	private JButton botonSiguiente;
	private JButton botonAtras;
	
	public EventoSeleccionPersonaje() {
		
		setLayout(null);
		
		Font font = null;
		Font font2 = null;
		
		Color colorFuente = Color.decode("#d4b877");

		try {
			font = Font.createFont(Font.TRUETYPE_FONT, new File("src/Fonts/Mantinia Regular.otf")).deriveFont(20f);
		} catch (FontFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		jLTipoPersonaje = new JLabel("Seleccion de Personaje");
		jLTipoPersonaje.setBounds(90, 40, 250, 20);
		jLTipoPersonaje.setForeground(colorFuente);
		jLTipoPersonaje.setBorder(null);
		jLTipoPersonaje.setFont(font);
		add(jLTipoPersonaje);
		
		
		//Personaje 1
		botonPersonaje1 = new JButton();
		botonPersonaje1.setBounds(150, 180, 400, 540);
		ImageIcon iconoOriginal1 = new ImageIcon("src/Personaje_Img/TipoPersonajes1.png");
		Image imagenOriginal1 = iconoOriginal1.getImage();
		Image imagenRedimensionada1 = imagenOriginal1.getScaledInstance(400, 540, Image.SCALE_SMOOTH);
		ImageIcon iconoRedimensionado1 = new ImageIcon(imagenRedimensionada1);
		botonPersonaje1.setIcon(iconoRedimensionado1);
		botonPersonaje1.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
		        CancionMenu.SonidoBoton("src/Clips/SonidoPersonaje.wav");

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
	
		        botonPersonaje1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				botonPersonaje1.setCursor(Cursor.getDefaultCursor());

				
			}  
        });
		botonPersonaje1.addActionListener(this);
		add(botonPersonaje1);

		//Personaje 2
		botonPersonaje2 = new JButton();
		botonPersonaje2.setBounds(560, 180, 400, 540);
		ImageIcon iconoOriginal2 = new ImageIcon("src/Personaje_Img/TipoPersonajes2.png");
		Image imagenOriginal2 = iconoOriginal2.getImage();
		Image imagenRedimensionada2 = imagenOriginal2.getScaledInstance(400, 540, Image.SCALE_SMOOTH);
		ImageIcon iconoRedimensionado2 = new ImageIcon(imagenRedimensionada2);
		botonPersonaje2.setIcon(iconoRedimensionado2);
		botonPersonaje2.addActionListener(this);
		botonPersonaje2.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
		        CancionMenu.SonidoBoton("src/Clips/SonidoPersonaje.wav");

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {


		        botonPersonaje2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				botonPersonaje2.setCursor(Cursor.getDefaultCursor());
				
				
			}  
        });
		add(botonPersonaje2);

		//Personaje 3
		botonPersonaje3 = new JButton();
		botonPersonaje3.setBounds(970, 180, 400, 540);
		ImageIcon iconoOriginal3 = new ImageIcon("src/Personaje_Img/TipoPersonajes3.png");
		Image imagenOriginal3 = iconoOriginal3.getImage();
		Image imagenRedimensionada3 = imagenOriginal3.getScaledInstance(400, 540, Image.SCALE_SMOOTH);
		ImageIcon iconoRedimensionado3 = new ImageIcon(imagenRedimensionada3);
		botonPersonaje3.setIcon(iconoRedimensionado3);
		botonPersonaje3.addActionListener(this);
		botonPersonaje3.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent e) {
					
				}

				@Override
				public void mousePressed(MouseEvent e) {
			        CancionMenu.SonidoBoton("src/Clips/SonidoPersonaje.wav");

				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseEntered(MouseEvent e) {

			        botonPersonaje3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					botonPersonaje3.setCursor(Cursor.getDefaultCursor());
			  

					
				}
	            
	           
	        });
		add(botonPersonaje3);
		
		jLTipoPersonaje = new JLabel("Pulsa para ver la informacion");
		jLTipoPersonaje.setBounds(620, 135, 280, 30);
		jLTipoPersonaje.setForeground(colorFuente);
		jLTipoPersonaje.setBorder(null);
		jLTipoPersonaje.setFont(font);
		add(jLTipoPersonaje);
		
		font2 = new Font("Arial", Font.PLAIN, 40);
		
		botonSiguiente = new JButton("<");
		botonSiguiente.setBounds(20, 400, 100, 100);
		botonSiguiente.setContentAreaFilled(true);
		botonSiguiente.setForeground(colorFuente);
		botonSiguiente.setBorder(null);
		botonSiguiente.setFont(font2);
       
		botonSiguiente.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent e) {
					
				}

				@Override
				public void mousePressed(MouseEvent e) {
			        CancionMenu.SonidoBoton("src/Clips/SonidoPersonaje.wav");

				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseEntered(MouseEvent e) {

					botonSiguiente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					botonSiguiente.setCursor(Cursor.getDefaultCursor());
			  

					
				}

	    });
		add(botonSiguiente);
		botonSiguiente.addActionListener(this);
		
		botonAtras = new JButton(">");
		botonAtras.setBounds(1350, 400, 100, 100);
		botonAtras.setContentAreaFilled(true);
		botonAtras.setForeground(colorFuente);
		botonAtras.setBorder(null);
		botonAtras.setFont(font2);
       
		botonAtras.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent e) {
					
				}

				@Override
				public void mousePressed(MouseEvent e) {
			        CancionMenu.SonidoBoton("src/Clips/SonidoPersonaje.wav");

				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseEntered(MouseEvent e) {

					botonAtras.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					botonAtras.setCursor(Cursor.getDefaultCursor());
			  
	
				} 
	        });
		add(botonAtras);
		botonAtras.addActionListener(this);
		
		// Fondo 
		JLFondo = new JLabel();
		JLFondo.setBounds(0, 0, 1440, 900);
		ImageIcon iconoOriginal10 = new ImageIcon("src/Personaje_Img/SeleccionPersonajes0.png");
		Image imagenOriginal10 = iconoOriginal10.getImage();
		Image imagenRedimensionada10 = imagenOriginal10.getScaledInstance(1440, 900, Image.SCALE_SMOOTH);
		ImageIcon iconoRedimensionado10 = new ImageIcon(imagenRedimensionada10);
		JLFondo.setIcon(iconoRedimensionado10);
		add(JLFondo);

	}
	 
	@Override
	public void actionPerformed(ActionEvent e) {
		
		JFrame evento = (JFrame) SwingUtilities.getWindowAncestor(this);

		if (e.getSource() == botonSiguiente) {
	          evento.remove(this);
	          evento.getContentPane().add(new EventoSeleccionPersonaje2());
	          evento.setVisible(true);
	    }
		
		else if (e.getSource() == botonAtras) {
	          evento.remove(this);
	          evento.getContentPane().add(new EventoSeleccionPersonaje2());
	          evento.setVisible(true);
	    }
		
		else if (e.getSource() == botonPersonaje1) {
	          evento.remove(this);
	          evento.getContentPane().add(new EvCarPer1());
	          evento.setVisible(true);
	    }
		
		else if (e.getSource() == botonPersonaje2) {
	          evento.remove(this);
	          evento.getContentPane().add(new EvCarPer2());
	          evento.setVisible(true);
	    }
		
		else if (e.getSource() == botonPersonaje3) {
	          evento.remove(this);
	          evento.getContentPane().add(new EvCarPer3());
	          evento.setVisible(true);
	    }
		
		
	}

}

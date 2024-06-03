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

public class EventoSeleccionPersonaje2 extends JPanel implements ActionListener{
	
	private JLabel JLFondo;
	private JLabel jLTipoPersonaje;
	private JButton botonPersonaje4;
	private JButton botonPersonaje5;
	private JButton botonPersonaje6;
	private JButton botonSiguiente;
	private JButton botonAtras;
	
	public  EventoSeleccionPersonaje2() {
		
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
		botonPersonaje4 = new JButton();
		botonPersonaje4.setBounds(150, 180, 400, 540);
		ImageIcon iconoOriginal1 = new ImageIcon("src/Personaje_Img/TipoPersonajes4.png");
		Image imagenOriginal1 = iconoOriginal1.getImage();
		Image imagenRedimensionada1 = imagenOriginal1.getScaledInstance(400, 540, Image.SCALE_SMOOTH);
		ImageIcon iconoRedimensionado1 = new ImageIcon(imagenRedimensionada1);
		botonPersonaje4.setIcon(iconoRedimensionado1);
		botonPersonaje4.addMouseListener(new MouseListener() {

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
	
		        botonPersonaje4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				botonPersonaje4.setCursor(Cursor.getDefaultCursor());

				
			}  
        });
		botonPersonaje4.addActionListener(this);
		add(botonPersonaje4);

		//Personaje 2
		botonPersonaje5 = new JButton();
		botonPersonaje5.setBounds(560, 180, 400, 540);
		ImageIcon iconoOriginal2 = new ImageIcon("src/Personaje_Img/TipoPersonajes5.png");
		Image imagenOriginal2 = iconoOriginal2.getImage();
		Image imagenRedimensionada2 = imagenOriginal2.getScaledInstance(400, 540, Image.SCALE_SMOOTH);
		ImageIcon iconoRedimensionado2 = new ImageIcon(imagenRedimensionada2);
		botonPersonaje5.setIcon(iconoRedimensionado2);
		botonPersonaje5.addActionListener(this);
		botonPersonaje5.addMouseListener(new MouseListener() {

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


		        botonPersonaje5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				botonPersonaje5.setCursor(Cursor.getDefaultCursor());
				
				
			}  
        });
		add(botonPersonaje5);

		//Personaje 3
		botonPersonaje6 = new JButton();
		botonPersonaje6.setBounds(970, 180, 400, 540);
		ImageIcon iconoOriginal3 = new ImageIcon("src/Personaje_Img/TipoPersonajes6.png");
		Image imagenOriginal3 = iconoOriginal3.getImage();
		Image imagenRedimensionada3 = imagenOriginal3.getScaledInstance(400, 540, Image.SCALE_SMOOTH);
		ImageIcon iconoRedimensionado3 = new ImageIcon(imagenRedimensionada3);
		botonPersonaje6.setIcon(iconoRedimensionado3);
		botonPersonaje6.addActionListener(this);
		botonPersonaje6.addMouseListener(new MouseListener() {

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

			        botonPersonaje6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					botonPersonaje6.setCursor(Cursor.getDefaultCursor());
			  

					
				}
	            
	           
	        });
		add(botonPersonaje6);
		
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
	          evento.getContentPane().add(new EventoSeleccionPersonaje());
	          evento.setVisible(true);
	    }
		
		else if (e.getSource() == botonAtras) {
	          evento.remove(this);
	          evento.getContentPane().add(new EventoSeleccionPersonaje());
	          evento.setVisible(true);
	    }
		
		else if (e.getSource() == botonPersonaje4) {
	          evento.remove(this);
	          evento.getContentPane().add(new EvCarPer4());
	          evento.setVisible(true);
	    }
		
		else if (e.getSource() == botonPersonaje5) {
	          evento.remove(this);
	          evento.getContentPane().add(new EvCarPer5());
	          evento.setVisible(true);
	    }
		
		else if (e.getSource() == botonPersonaje6) {
	          evento.remove(this);
	          evento.getContentPane().add(new EvCarPer6());
	          evento.setVisible(true);
	    }
		
	
	}

}
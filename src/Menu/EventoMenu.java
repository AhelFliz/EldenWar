package Menu;

import Musica.CancionMenu;
import Normas.EventoNormas;
import Personaje.EventoNumeroPersonajes;
import Personaje.EventoSeleccionPersonaje;
import Victoriosos.EventoVictoriosos;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Configuracion.EventoConfiguracion;
import Creador.EventoCreador;

import java.io.File;
import java.io.IOException;


public class EventoMenu extends JPanel implements ActionListener {
	
	private JLabel JLFondo; 
	private JButton jBJugar;
	private JButton jBConfiguracion;
	private JButton jBVictoriosos;
	private JButton jBCreador;
	private JButton jbnormas;
	
	public EventoMenu() {
		
		setLayout(null);
		 
		Font font = null;
		Color colorFuente = Color.decode("#d4b877");

		try {
			font = Font.createFont(Font.TRUETYPE_FONT, new File("src/Fonts/Mantinia Regular.otf")).deriveFont(20f);
		} catch (FontFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        jBJugar = new JButton("EmpezaR PartidA");
        jBJugar.setBounds(600,660,230,25);
        jBJugar.setContentAreaFilled(false);
        jBJugar.setForeground(colorFuente);
        jBJugar.setBorder(null);
        jBJugar.setFont(font);
        
        jBJugar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	jBJugar.setBackground(Color.RED); // Cambia la imagen al entrar el mouse
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	jBJugar.setBackground(Color.BLUE);// Restaura la imagen al salir el mouse
            }
        });
        
        add(jBJugar);
        jBJugar.addActionListener(this);
        
        jBConfiguracion = new JButton("ConfiguracioN");
        jBConfiguracion.setBounds(600,685,230,25);
        jBConfiguracion.setContentAreaFilled(false);
        jBConfiguracion.setForeground(colorFuente);
        jBConfiguracion.setBorder(null);
        jBConfiguracion.setFont(font); 	
        add(jBConfiguracion);
        jBConfiguracion.addActionListener(this);
        
        jBVictoriosos = new JButton("VictoriosoS");
        jBVictoriosos.setBounds(600,710,230,25);
        jBVictoriosos.setContentAreaFilled(false);
        jBVictoriosos.setForeground(colorFuente);
        jBVictoriosos.setBorder(null);
        jBVictoriosos.setFont(font);
        add(jBVictoriosos);
        jBVictoriosos.addActionListener(this);
        
        jbnormas = new JButton("NormaS");
        jbnormas.setBounds(600,735,230,25);
        jbnormas.setContentAreaFilled(false);
        jbnormas.setForeground(colorFuente);
        jbnormas.setBorder(null);
        jbnormas.setFont(font);
        add(jbnormas);
        jbnormas.addActionListener(this);
        
        jBCreador = new JButton("CreadoR");
        jBCreador.setBounds(600,760,230,25);
        jBCreador.setContentAreaFilled(true);
        jBCreador.setForeground(colorFuente);
        jBCreador.setBorder(null);
        jBCreador.setFont(font);
        
        jBCreador.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
		        CancionMenu.SonidoBoton("src/Clips/SonidoBoton.wav");

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				jBCreador.setBackground(Color.RED);
		        jBCreador.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
		        jBCreador.setCursor(Cursor.getDefaultCursor());
		        jBCreador.setBackground(null);
				
			}
            
           
        });
        
        add(jBCreador);
        jBCreador.addActionListener(this);
        
        
        
        // Fondo
        JLFondo = new JLabel();
        JLFondo.setBounds(0, 0, 1440, 900); 
        JLFondo.setIcon(new ImageIcon("src/Menu_Img/MenuImagen01.png"));
        add(JLFondo);
        
        
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		JFrame evento = (JFrame) SwingUtilities.getWindowAncestor(this);
		
		if (e.getSource() == jBConfiguracion) {
          evento.remove(this);
          evento.getContentPane().add(new EventoConfiguracion());
          evento.setVisible(true);
        }
		
		if (e.getSource() == jBCreador) {
	          evento.remove(this);
	          evento.getContentPane().add(new EventoCreador());
	          evento.setVisible(true);
	    }
		
		if (e.getSource() == jBJugar) {
	          evento.remove(this);
	          evento.getContentPane().add(new EventoNumeroPersonajes());
	          evento.setVisible(true);
	    }
		
		if (e.getSource() == jBVictoriosos) {
				
	          evento.remove(this);
	          evento.getContentPane().add(new EventoVictoriosos());
	          evento.setVisible(true);
	          
	          
	    }if (e.getSource() == jbnormas) {	
			
	          evento.remove(this);
	          evento.getContentPane().add(new EventoNormas());
	          evento.setVisible(true);
	          
	          
	    }
		
	}
	
	
}

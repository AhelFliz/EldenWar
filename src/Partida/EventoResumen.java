package Partida;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;


import Personaje.ArrayPersonajes;
import Personaje.Personaje;

public class EventoResumen extends JPanel implements ActionListener{
	
	private JLabel JLFondo;
	private JButton JBSiguiente;
	private JTextArea JTResumen;
	
	public EventoResumen () {
		
		setLayout(null);
		
		Font font = null;
		
		Color colorFuente = Color.decode("#d4b877");

		try {
			font = Font.createFont(Font.TRUETYPE_FONT, new File("src/Fonts/Mantinia Regular.otf")).deriveFont(20f);
		} catch (FontFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Iterator<Personaje> iterator = ArrayPersonajes.personajes.iterator();
        
        while (iterator.hasNext()) {
        	
        	Personaje personaje = iterator.next();
            
            if (personaje.getVida() <= 0) { 
            	
                iterator.remove();
                
            }else if(personaje.getVida() > 200) {
            	
            	personaje.setVida(ArrayPersonajes.vida);
            	
            }else { 
            	
            	personaje.setMisiles_ronda(ArrayPersonajes.numMis); 
            }
            	
        }
        
		JTResumen = new JTextArea();
		JTResumen.setText(ArrayPersonajes.resumenRonda);
		JTResumen.setEditable(false);
		JTResumen.setBounds(280, 178, 880, 375); 
		JTResumen.setForeground(colorFuente);
		JTResumen.setOpaque(false);
		JTResumen.setBorder(null);
		JTResumen.setFont(font);
		add(JTResumen, BorderLayout.CENTER);
		
		int yOffset = 590; 
        int spacing = 40;
        
        JLabel tit = new JLabel("Guerreros vivos", SwingConstants.CENTER);
        tit.setFont(font);
        tit.setForeground(colorFuente);
        tit.setBounds(515, 560, 400, 50); 
        add(tit);
    
        for (Personaje personaje : ArrayPersonajes.personajes) {
        	
            JLabel label = new JLabel(personaje.getNombre() + "    -----    " + personaje.getVida(), SwingConstants.CENTER);
            label.setFont(font);
            label.setForeground(colorFuente);
            label.setBounds(515, yOffset, 400, 50); 
            add(label);
            yOffset += spacing; 
            
        }

		JBSiguiente = new JButton("SIGUIENTE");
		JBSiguiente.setBounds(540,815,345,53);
		JBSiguiente.setContentAreaFilled(true);
		JBSiguiente.setForeground(colorFuente);
		JBSiguiente.setBorder(null);
		JBSiguiente.setOpaque(false);
		JBSiguiente.setFont(font);
		JBSiguiente.setContentAreaFilled(true);
		add(JBSiguiente);
		JBSiguiente.addActionListener(this);
        
		JLFondo = new JLabel();
		JLFondo.setBounds(0, 0, 1440, 900);
		ImageIcon iconoOriginal10 = new ImageIcon("src/Partida_Img/FondoResumen02.jpeg");
		Image imagenOriginal10 = iconoOriginal10.getImage();
		Image imagenRedimensionada10 = imagenOriginal10.getScaledInstance(1440, 900, Image.SCALE_SMOOTH);
		ImageIcon iconoRedimensionado10 = new ImageIcon(imagenRedimensionada10);
		JLFondo.setIcon(iconoRedimensionado10);
		add(JLFondo);
		

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		JFrame evento = (JFrame) SwingUtilities.getWindowAncestor(this);
		
		if (e.getSource() == JBSiguiente ) {
			
			ArrayPersonajes.resumenRonda = "";
			
			if(ArrayPersonajes.personajes.size() == 1) {
				
				evento.remove(this);
		        evento.getContentPane().add(new Evento1Ganador());
		        evento.setVisible(true);
		        
			} else if(ArrayPersonajes.personajes.size() == 0) {
				
				evento.remove(this);
				evento.getContentPane().add(new EventoEmpate());
				evento.setVisible(true);
			}else {
				
				evento.remove(this);
		        evento.getContentPane().add(new EventoAtacDefe());
		        evento.setVisible(true);
			}
		
	        
		}
		
	}

}

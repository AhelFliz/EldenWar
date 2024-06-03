package Partida;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Menu.EventoMenu;
import Personaje.ArrayPersonajes;

public class EventoEmpate extends JPanel implements ActionListener {
	
	private JLabel JLFondo;
	private JButton JBNueva;
	private JButton JBSalir;
	
	public EventoEmpate () {
		
		setLayout(null);
		
		Color colorFuente = Color.decode("#d4b877");
	
		Font font = null;

		try {
			font = Font.createFont(Font.TRUETYPE_FONT, new File("src/Fonts/Mantinia Regular.otf")).deriveFont(25f);
		} catch (FontFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JBNueva = new JButton("MENU PRINCIPAL");
        JBNueva.setBounds(572,607,330,45);
        JBNueva.setContentAreaFilled(true);
        JBNueva.setForeground(colorFuente);
        JBNueva.setBorder(null);
        JBNueva.setFont(font);
        JBNueva.setContentAreaFilled(true);
		add(JBNueva);
		JBNueva.addActionListener(this);
		
		JBSalir = new JButton("SALIR");
		JBSalir.setBounds(572,680,330,45);
		JBSalir.setContentAreaFilled(true);
		JBSalir.setForeground(colorFuente);
		JBSalir.setBorder(null);
		JBSalir.setFont(font);
		JBSalir.setContentAreaFilled(true);
		add(JBSalir);
		JBSalir.addActionListener(this);
		
		JLFondo = new JLabel();
		JLFondo.setBounds(0, 0, 1440, 900);
		ImageIcon iconoOriginal10 = new ImageIcon("src/Partida_Img/FondoEmpate.png");
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
		
		if (e.getSource() == JBNueva) {
			
			ArrayPersonajes.turno = 0;
			ArrayPersonajes.personajes.clear();
			ArrayPersonajes.resumenRonda = "";

			evento.remove(this);
	        evento.getContentPane().add(new EventoMenu());
	        evento.setVisible(true);
			
		} else if (e.getSource() == JBSalir) {
			
			System.exit(0);
		}
		
	}
	
	

}

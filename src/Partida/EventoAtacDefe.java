package Partida;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

import Personaje.ArrayPersonajes;



public class EventoAtacDefe extends JPanel implements ActionListener {
	
	private JLabel JLFondo;
	private JButton btnAtacar;
	private JButton btnDefender;
	private JLabel JLNombre;
	private JLabel JLPosiones;
	Boolean esFinal = true;
	int turno = 0;
	int misilesDefensa;
	int deseaAtacarA;
	int misilesAtaque;
	
	public EventoAtacDefe () {
		
		Scanner input = new Scanner(System.in);
		
		setLayout(null);
		
		Color colorFuente = Color.decode("#d4b877");
		Font font = null;
		
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, new File("src/Fonts/Mantinia Regular.otf")).deriveFont(30f);
		} catch (FontFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JLNombre = new JLabel(ArrayPersonajes.personajes.get(ArrayPersonajes.turno).getNombre().toUpperCase(), SwingConstants.CENTER);
		JLNombre.setBounds(598, 228, 277, 40);
		JLNombre.setForeground(colorFuente);
		JLNombre.setFont(font);
		add(JLNombre);

		JLPosiones = new JLabel(""+ArrayPersonajes.personajes.get(ArrayPersonajes.turno).getMisiles_ronda());
		JLPosiones.setBounds(698, 400, 290, 40);
		JLPosiones.setForeground(colorFuente);
		JLPosiones.setBorder(null);
		JLPosiones.setFont(font);
        add(JLPosiones);
        
        btnAtacar = new JButton("ATACAR");
        btnAtacar.setBounds(540, 500, 400, 50);
        btnAtacar.setContentAreaFilled(false);
        btnAtacar.setForeground(colorFuente);
        btnAtacar.setBorder(null);
        btnAtacar.setFont(font); 	
        add(btnAtacar);
        btnAtacar.addActionListener(this);
        
        btnDefender = new JButton("DEFENDER");
        btnDefender.setBounds(540, 600, 400, 50);
        btnDefender.setContentAreaFilled(false);
        btnDefender.setForeground(colorFuente);
        btnDefender.setBorder(null);
        btnDefender.setFont(font); 	
        add(btnDefender);
        btnDefender.addActionListener(this);
        
		JLFondo = new JLabel();
		JLFondo.setBounds(0, 0, 1440, 900);
		ImageIcon iconoOriginal10 = new ImageIcon("src/Partida_Img/AtacarDefenderFondo02.jpeg");
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
		
		if (e.getSource() == btnAtacar ) {
			
			evento.remove(this);
	        evento.getContentPane().add(new EventoAtacar());
	        evento.setVisible(true);
	        
		}else if (e.getSource() == btnDefender ) {
			
			evento.remove(this);
	        evento.getContentPane().add(new EventoDefensa());
	        evento.setVisible(true);
		}
	}

}

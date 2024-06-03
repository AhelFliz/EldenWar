package Configuracion;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Menu.EventoMenu;
import Personaje.ArrayPersonajes;

public class EventoConfiguracion extends JPanel implements ActionListener{
	
	private JLabel JLFondo;
	private JButton JBAtras;
	private ImageIcon Icono01;
	private JTextField JTPociones;
	private JTextField JTVida;
	private JTextField JTJugMax;
	private JButton JBGuardar;
	private JTextField JTJugMin;
	
	public EventoConfiguracion () {
		
		setLayout(null);
		
		Font font = null;
		Color colorFuente = Color.decode("#d4b877");

		try {
			font = Font.createFont(Font.TRUETYPE_FONT, new File("src/Fonts/Mantinia Regular.otf")).deriveFont(20f);
		} catch (FontFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 
		JTPociones = new JTextField();
		JTPociones.setHorizontalAlignment(JTextField.CENTER); 
		JTPociones.setBounds(800, 225, 295, 25);
		JTPociones.setOpaque(false);
		JTPociones.setBackground(new Color(0, 0, 0, 0));
		JTPociones.setFont(font);
		//JTPociones.setBorder(null);
		JTPociones.setForeground(colorFuente);
		add(JTPociones);
		
		JTVida = new JTextField();
		JTVida.setHorizontalAlignment(JTextField.CENTER); 
		JTVida.setBounds(800, 266, 295, 25);
		JTVida.setOpaque(false);
		JTVida.setBackground(new Color(0, 0, 0, 0));
		JTVida.setFont(font);
		//JTVida.setBorder(null);
		JTVida.setForeground(colorFuente);
		add(JTVida);
		
		JTJugMax = new JTextField();
		JTJugMax.setHorizontalAlignment(JTextField.CENTER); 
		JTJugMax.setBounds(800, 310, 295, 25);
		JTJugMax.setOpaque(false);
		JTJugMax.setBackground(new Color(0, 0, 0, 0));
		JTJugMax.setFont(font);
		//JTVida.setBorder(null);
		JTJugMax.setForeground(colorFuente);
		add(JTJugMax);
		
		JTJugMin = new JTextField();
		JTJugMin.setHorizontalAlignment(JTextField.CENTER); 
		JTJugMin.setBounds(800, 350, 295, 25);
		JTJugMin.setOpaque(false);
		JTJugMin.setBackground(new Color(0, 0, 0, 0));
		JTJugMin.setFont(font);
		//JTJugMax.setBorder(null);
		JTJugMin.setForeground(colorFuente);
		add(JTJugMin);
		
		DocumentListener documentListener = new DocumentListener() {
		    public void changedUpdate(DocumentEvent e) {
		        toggleSaveButton();
		    }
		    public void removeUpdate(DocumentEvent e) {
		        toggleSaveButton();
		    }
		    public void insertUpdate(DocumentEvent e) {
		        toggleSaveButton();
		    }

		    public void toggleSaveButton() {
		    	JBGuardar.setEnabled(!JTJugMax.getText().trim().isEmpty() && !JTPociones.getText().trim().isEmpty()  && !JTVida.getText().trim().isEmpty() && !JTJugMin.getText().trim().isEmpty());
		    }
		};

		JTJugMax.getDocument().addDocumentListener(documentListener);
		JTPociones.getDocument().addDocumentListener(documentListener);
		JTVida.getDocument().addDocumentListener(documentListener);
		JTJugMin.getDocument().addDocumentListener(documentListener);
		
		JBGuardar = new JButton("GUARDAR");
		JBGuardar.setBounds(558,805,340,50);
		JBGuardar.setContentAreaFilled(true);
		JBGuardar.setForeground(colorFuente);
		JBGuardar.setBorder(null);
		JBGuardar.setFont(font);
		JBGuardar.setEnabled(false);
		JBGuardar.setContentAreaFilled(true);
		add(JBGuardar);
		JBGuardar.addActionListener(this);
		
		Icono01 = new ImageIcon("src/Creador_Img/BotonAtras.png");
		JBAtras = new JButton(Icono01);
		JBAtras.setBounds(1100, 590, 500,400 ); 
		JBAtras.setContentAreaFilled(false);
		JBAtras.setBorder(null);
	    add(JBAtras);
	    JBAtras.addActionListener(this);
		
		JLFondo = new JLabel();
        JLFondo.setBounds(0, 0, 1440, 900); 
        JLFondo.setIcon(new ImageIcon("src/Configuracion_Img/ConfigFondo.jpeg"));
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
		else if (e.getSource() == JBGuardar) {
			
			String pociones = JTPociones.getText();
			int numPotis = 0;
			
			String vida = JTVida.getText();
			int numVida = 0;
			
			String maxJug = JTJugMax.getText();
			int numMaxJ = 0;
			
			String minJug = JTJugMin.getText();
			int numMinJ = 0;
			
			
			try {
				
				numPotis = Integer.parseInt(pociones); 
				numVida = Integer.parseInt(vida); 
				numMaxJ = Integer.parseInt(maxJug); 
				numMinJ = Integer.parseInt(minJug); 
				
				if (numPotis <= 0 || numVida <= 0 || numMaxJ <= 0 || numMinJ <= 0  ){
					JOptionPane.showMessageDialog(this, "No introduzcas una cantidad negativa o igual a 0.", "Cantidad erronea", JOptionPane.WARNING_MESSAGE);
				}else if (numMinJ < 2) {
					JOptionPane.showMessageDialog(this, "Introduce como minimo 2 jugadores.", "Cantidad erronea", JOptionPane.WARNING_MESSAGE);	
				}else if( numMaxJ <= numMinJ) {
					JOptionPane.showMessageDialog(this, "Introcu un maximo de jugadores mayor al minimo.", "Cantidad erronea", JOptionPane.WARNING_MESSAGE);		
				}else {
					ArrayPersonajes.numMis = numPotis;
					ArrayPersonajes.vida = numVida;
					ArrayPersonajes.maxJug = numMaxJ;
					ArrayPersonajes.minJug = numMinJ;
					
					evento.remove(this);
					evento.getContentPane().add(new EventoMenu());
					evento.setVisible(true);
				}
				
			} catch (NumberFormatException ex) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "No se ha ingresado un numero. Introduce uno correcto.", "Numero erroneo", JOptionPane.WARNING_MESSAGE);
			}
	     }
			
	}

}

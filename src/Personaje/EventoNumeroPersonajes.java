package Personaje;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.ColorUIResource;

import java.awt.*;


public class EventoNumeroPersonajes extends JPanel implements ActionListener, ChangeListener {

	private JLabel JLFondo;
	private SpinnerModel model;
	private JSpinner spinner;
	private JButton JBGuardar;
	int personajes = 0;
	
	public EventoNumeroPersonajes () {
		
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
		
		try {
			font2 = Font.createFont(Font.TRUETYPE_FONT, new File("src/Fonts/Mantinia Regular.otf")).deriveFont(35f);
		} catch (FontFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		model = new SpinnerNumberModel(3, ArrayPersonajes.minJug, ArrayPersonajes.maxJug, 1); 
		spinner = new JSpinner(model);
		spinner.addChangeListener(this);
		spinner.setBounds(550, 435, 400, 60);
		JComponent editor = spinner.getEditor();
        JFormattedTextField textField = ((JSpinner.DefaultEditor) editor).getTextField();
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setFont(font2);
        JSpinner.DefaultEditor editor1 = (JSpinner.DefaultEditor) spinner.getEditor();
        editor1.getTextField().setEditable(false);
        textField.setForeground(colorFuente);
        textField.setOpaque(false);
        textField.setBackground(new Color(0, 0, 0, 0));
        textField.setBorder(BorderFactory.createEmptyBorder());
		add(spinner);
		
		JBGuardar = new JButton("GUARDAR");
		JBGuardar.setBounds(633,583,210,40);
		JBGuardar.setForeground(colorFuente);
		JBGuardar.setContentAreaFilled(true);
		JBGuardar.setBorder(null);
		JBGuardar.setFont(font);
		add(JBGuardar);
		JBGuardar.addActionListener(this);
		
		// Fondo 
		JLFondo = new JLabel();
		JLFondo.setBounds(0, 0, 1440, 900);
		ImageIcon iconoOriginal10 = new ImageIcon("src/Personaje_Img/NumPers02.jpeg");
		Image imagenOriginal10 = iconoOriginal10.getImage();
		Image imagenRedimensionada10 = imagenOriginal10.getScaledInstance(1440, 900, Image.SCALE_SMOOTH);
		ImageIcon iconoRedimensionado10 = new ImageIcon(imagenRedimensionada10);
		JLFondo.setIcon(iconoRedimensionado10);
		add(JLFondo);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		JSpinner spinner = (JSpinner) e.getSource();
		personajes = (int) spinner.getValue();
		
		ArrayPersonajes.setNumPerso(personajes);
			
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		JFrame evento = (JFrame) SwingUtilities.getWindowAncestor(this);
		
		if (e.getSource() == JBGuardar) {
			
			if(ArrayPersonajes.getNumPerso() == 0) {
				ArrayPersonajes.setNumPerso(3);
			}
			
			System.out.println(ArrayPersonajes.getNumPerso());
			evento.remove(this);
	        evento.getContentPane().add(new EventoSeleccionPersonaje());
	        evento.setVisible(true);
	        
	        
	    }
		
	}

}

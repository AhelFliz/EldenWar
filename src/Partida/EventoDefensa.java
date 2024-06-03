package Partida;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Personaje.ArrayPersonajes;
import Personaje.Personaje;

public class EventoDefensa extends JPanel implements ActionListener {
	
	private JLabel JLFondo;
	private JLabel JLAtaquesRes;
	private JButton JBAtacar;
	private JTextField JTPociones;
	
	public EventoDefensa () {
		
		setLayout(null);
		
		Color colorFuente = Color.decode("#d4b877");
		 
		Font font = null;
		Font font2 = null;
		
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, new File("src/Fonts/Mantinia Regular.otf")).deriveFont(35f);
		} catch (FontFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			font2 = Font.createFont(Font.TRUETYPE_FONT, new File("src/Fonts/Mantinia Regular.otf")).deriveFont(25f);
		} catch (FontFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JLAtaquesRes = new JLabel("" + ArrayPersonajes.personajes.get(ArrayPersonajes.turno).getMisiles_ronda());
        JLAtaquesRes.setBounds(720, 380, 400, 50);
        JLAtaquesRes.setFont(font);
        JLAtaquesRes.setForeground(colorFuente);
        add(JLAtaquesRes);
        

		JTPociones = new JTextField();
		JTPociones.setHorizontalAlignment(JTextField.CENTER);
		JTPociones.setBounds(579,581,333,30);
		JTPociones.setOpaque(false);
		JTPociones.setBackground(new Color(0, 0, 0, 0));
		JTPociones.setFont(font2);
		JTPociones.setBorder(null);
		JTPociones.setForeground(colorFuente);
		add(JTPociones);
		
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
		        JBAtacar.setEnabled(!JTPociones.getText().trim().isEmpty());
		    }
		};

		JTPociones.getDocument().addDocumentListener(documentListener);
         
		JBAtacar = new JButton("DEFENDERSE");
		JBAtacar.setBounds(630,785,255,40);
		JBAtacar.setContentAreaFilled(true);	
		JBAtacar.setForeground(colorFuente);
		JBAtacar.setBorder(null);
		JBAtacar.setFont(font2);
		JBAtacar.setEnabled(false);
		JBAtacar.setContentAreaFilled(true);
		add(JBAtacar);
		JBAtacar.addActionListener(this);
		
		JLFondo = new JLabel();
		JLFondo.setBounds(0, 0, 1440, 900);
		ImageIcon iconoOriginal10 = new ImageIcon("src/Partida_Img/FondoCuracion.png");
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
		
		if (e.getSource() == JBAtacar ) {

			String pociones = JTPociones.getText();

			Personaje atacantePersonaje = ArrayPersonajes.personajes.get(ArrayPersonajes.turno);
			
			int numPotis = 0;
				
			 try {
				 
				 numPotis = Integer.parseInt(pociones); 
                
				if(numPotis > atacantePersonaje.getMisiles_ronda()) {
					
					JOptionPane.showMessageDialog(this, "No tiene esa cantidad de pociones. Introduce una cantidad correcta.", "Pociones erroneas", JOptionPane.WARNING_MESSAGE);
				}else if(numPotis < 0) {
					
					JOptionPane.showMessageDialog(this, "No introduzcas una cantidad de pociones negativa.", "Cantidad erronea", JOptionPane.WARNING_MESSAGE);
				}else {
					
					ArrayPersonajes.resumenRonda += atacantePersonaje.curacion(numPotis);	
					
					if (ArrayPersonajes.turno == ArrayPersonajes.personajes.size() - 1){
						
						if (atacantePersonaje.getMisiles_ronda() > 0) {
	                        evento.remove(this);
	                        evento.getContentPane().add(new EventoAtacDefe());
	                        evento.setVisible(true);
	                    } else {
	                        ArrayPersonajes.turno = 0;
	                        evento.remove(this);
	                        evento.getContentPane().add(new EventoResumen());
	                        evento.setVisible(true);
	                    }
							
					} else if(atacantePersonaje.getMisiles_ronda() > 0) {
						
						evento.remove(this);
				        evento.getContentPane().add(new EventoAtacDefe());
				        evento.setVisible(true);
				        
					} else {
						
						ArrayPersonajes.turno++;
						
						evento.remove(this);
				        evento.getContentPane().add(new EventoAtacDefe());
				        evento.setVisible(true);
					}
	
				}
					
	            }catch (NumberFormatException ex) { 
	            	JOptionPane.showMessageDialog(this, "No se ha ingresado un numero. Introduce uno correcto.", "Numero erroneo", JOptionPane.WARNING_MESSAGE);
	            }	
			}
			
		}
}

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
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Personaje.ArrayPersonajes;
import Personaje.Personaje;

public class EventoAtacar extends JPanel implements ActionListener {
	
    private JLabel JLAtaquesRes;
    private JLabel JLFondo;
    private JTextField JTAtacado;
    private JTextField JTPociones;
    private JButton JBAtacar;
   

	public EventoAtacar() {
		
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
        JLAtaquesRes.setBounds(1070, 380, 400, 50);
        JLAtaquesRes.setFont(font);
        JLAtaquesRes.setForeground(colorFuente);
        add(JLAtaquesRes);
        
        int yOffset = 300; 
        int spacing = 40;

        for (Personaje personaje : ArrayPersonajes.personajes) {
            if (!personaje.getNombre().equals(ArrayPersonajes.personajes.get(ArrayPersonajes.turno).getNombre())) {
                JLabel label = new JLabel(personaje.getNombre(), SwingConstants.CENTER);
                label.setFont(font);
                label.setForeground(colorFuente);
                label.setBounds(180, yOffset, 400, 50); 
                add(label);
                yOffset += spacing; 
            }
        }
        
        JTAtacado = new JTextField();
        JTAtacado.setHorizontalAlignment(JTextField.CENTER); 
		JTAtacado.setBounds(211,597,334,30);
		JTAtacado.setOpaque(false);
		JTAtacado.setBackground(new Color(0, 0, 0, 0));
		JTAtacado.setFont(font2);
		JTAtacado.setBorder(null);
		JTAtacado.setForeground(colorFuente);
		add(JTAtacado);
		
		JTPociones = new JTextField();
		JTPociones.setHorizontalAlignment(JTextField.CENTER);
		JTPociones.setBounds(950,597,334,30);
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
		        JBAtacar.setEnabled(!JTAtacado.getText().trim().isEmpty() && !JTPociones.getText().trim().isEmpty());
		    }
		};

		JTAtacado.getDocument().addDocumentListener(documentListener);
		JTPociones.getDocument().addDocumentListener(documentListener);
		
		JBAtacar = new JButton("ATACAR");
		JBAtacar.setBounds(572,784,330,40);
		JBAtacar.setContentAreaFilled(true);
		JBAtacar.setForeground(colorFuente);
		JBAtacar.setBorder(null);
		JBAtacar.setFont(font);
		JBAtacar.setEnabled(false);
		JBAtacar.setContentAreaFilled(true);
		add(JBAtacar);
		JBAtacar.addActionListener(this);
		
		
		JLFondo = new JLabel();
		JLFondo.setBounds(0, 0, 1440, 900);
		ImageIcon iconoOriginal10 = new ImageIcon("src/Partida_Img/fondoAtakDefend02.png");
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
			
			String nombre = JTAtacado.getText().toLowerCase();
			String pociones = JTPociones.getText();
			Boolean existe = false;
			int posAtac = 0;
			boolean mismo = false;

			for (int i = 0; i < ArrayPersonajes.personajes.size(); i++) {
			    if (ArrayPersonajes.personajes.get(i).getNombre().toLowerCase().equals(nombre)) {
			        if (ArrayPersonajes.personajes.get(i).getNombre().equals(ArrayPersonajes.personajes.get(ArrayPersonajes.turno).getNombre())) {
			            mismo = true;
			            break;
			        } else {
			            existe = true;
			            posAtac = i;
			            break;
			        }
			    }
			}	
			
			Personaje atacantePersonaje = ArrayPersonajes.personajes.get(ArrayPersonajes.turno);
			
			if (mismo) {
				JOptionPane.showMessageDialog(this, "No puedes atacarte a tu mismo. Introduce un nombre distinto.", "Nombre erróneo", JOptionPane.WARNING_MESSAGE);
			}
			else if (existe) {
				
				int numPotis = 0;
				
				 try {
					 numPotis = Integer.parseInt(pociones); 
	                
					if(numPotis > atacantePersonaje.getMisiles_ronda()) {
						JOptionPane.showMessageDialog(this, "No tienes esa cantidad de pociones. Introduce una cantidad correcta.", "Pociones erroneas", JOptionPane.WARNING_MESSAGE);
					}else if (numPotis < 0){
						JOptionPane.showMessageDialog(this, "No introduzcas una cantidad de pociones negativa.", "Cantidad erronea", JOptionPane.WARNING_MESSAGE);
					}else {

						ArrayPersonajes.resumenRonda += atacantePersonaje.ataque(numPotis, ArrayPersonajes.personajes.get(posAtac));
						
						
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

						}
						
						else if(atacantePersonaje.getMisiles_ronda() > 0) {
							
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
				
			}else {
				JOptionPane.showMessageDialog(this, "El nombre del personaje no existe. Introduce otro nombre.", "Nombre erroneo", JOptionPane.WARNING_MESSAGE);
			}	
		}
	}	
}

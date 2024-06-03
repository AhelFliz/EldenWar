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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import Clases.Confessor;
import Clases.Prisoner;
import Menu.EventoMenu;
import Musica.CancionMenu;
import Partida.EventoAtacDefe;

public class EvCarPer3 extends JPanel implements ActionListener{
	
	private JLabel JLFondo;
	private JButton JBAtras;
	private ImageIcon Icono01;
	private JLabel JLpersonaje;
	private JLabel jLTipoPersonaje;
	private JLabel JLNombre;
	private JTextField nameTextField;
	private JButton JBGuardar;
	
	public EvCarPer3 () {
		
		setLayout(null);
		
		Color colorFuente = Color.decode("#d4b877");
		Font font = null;
		
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, new File("src/Fonts/Mantinia Regular.otf")).deriveFont(20f);
		} catch (FontFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		jLTipoPersonaje = new JLabel("Caracteristicas de Personaje");
		jLTipoPersonaje.setBounds(95, 40, 280, 20);
		jLTipoPersonaje.setForeground(colorFuente);
		jLTipoPersonaje.setBorder(null);
		jLTipoPersonaje.setFont(font);
		add(jLTipoPersonaje);
		

		JLNombre = new JLabel("Introduce el nombre");
		JLNombre.setBounds(115, 147, 280, 20);
		JLNombre.setForeground(colorFuente);
		JLNombre.setBorder(null);
		JLNombre.setFont(font);
		add(JLNombre);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(372,139,297,30);
		nameTextField.setOpaque(false);
		nameTextField.setBackground(new Color(0, 0, 0, 0));
		nameTextField.setForeground(Color.WHITE);
		add(nameTextField);
		
		JLNombre = new JLabel("Hace el doble de daño A ");
		JLNombre.setBounds(115, 195, 280, 20);
		JLNombre.setForeground(colorFuente);
		JLNombre.setBorder(null);
		JLNombre.setFont(font);
		add(JLNombre);
		
		JLNombre = new JLabel("Astrologer");
		JLNombre.setBounds(472, 194, 280, 20);
		JLNombre.setForeground(colorFuente);
		JLNombre.setBorder(null);
		JLNombre.setFont(font);
		add(JLNombre);
		
		JLNombre = new JLabel("Recibe el doble de daño dE ");
		JLNombre.setBounds(115, 240, 280, 20);
		JLNombre.setForeground(colorFuente);
		JLNombre.setBorder(null);
		JLNombre.setFont(font);
		add(JLNombre);
		
		JLNombre = new JLabel("Confessor");
		JLNombre.setBounds(477, 240, 280, 20);
		JLNombre.setForeground(colorFuente);
		JLNombre.setBorder(null);
		JLNombre.setFont(font);
		add(JLNombre);
		
		JLNombre = new JLabel("Edad");
		JLNombre.setBounds(115, 336, 280, 20);
		JLNombre.setForeground(colorFuente);
		JLNombre.setBorder(null);
		JLNombre.setFont(font);
		add(JLNombre);
		
		JLNombre = new JLabel("1000 años");
		JLNombre.setBounds(472, 332, 280, 20);
		JLNombre.setForeground(colorFuente);
		JLNombre.setBorder(null);
		JLNombre.setFont(font);
		add(JLNombre);
		
		JLNombre = new JLabel("Clase");
		JLNombre.setBounds(115, 376, 280, 20);
		JLNombre.setForeground(colorFuente);
		JLNombre.setBorder(null);
		JLNombre.setFont(font);
		add(JLNombre);
		
		JLNombre = new JLabel("Prisoner");
		JLNombre.setBounds(472, 378, 280, 20);
		JLNombre.setForeground(colorFuente);
		JLNombre.setBorder(null);
		JLNombre.setFont(font);
		add(JLNombre);
		
	  	JBGuardar = new JButton("Guardar");
		JBGuardar.setBounds(294,738,230,40);
		JBGuardar.setContentAreaFilled(true);
		JBGuardar.setForeground(colorFuente);
		JBGuardar.setBorder(null);
		JBGuardar.setFont(font);
		add(JBGuardar);
		JBGuardar.addActionListener(this);
		
		JLpersonaje = new JLabel();
		JLpersonaje.setBounds(890, 130, 400, 540); 
        ImageIcon iconoOriginal = new ImageIcon("src/Personaje_Img/Cart03.png");
        Image imagenOriginal = iconoOriginal.getImage();
        Image imagenRedimensionada = imagenOriginal.getScaledInstance(400, 540, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);
        JLpersonaje.setIcon(iconoRedimensionado);
        add(JLpersonaje);
        
		Icono01 = new ImageIcon("src/Creador_Img/BotonAtras.png");
		JBAtras = new JButton(Icono01);
		JBAtras.setBounds(1100, 590, 500,400 ); 
		JBAtras.setContentAreaFilled(false);
		JBAtras.setBorder(null);
		
		JBAtras.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
		    
				
			}
	
			@Override
			public void mousePressed(MouseEvent e) {
			    CancionMenu.MusicaMenu("src/Clips/SonidoAtras.wav");				
			}
	
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
	
			@Override
			public void mouseEntered(MouseEvent e) {
				JBAtras.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	
	
				
			}
	
			@Override
			public void mouseExited(MouseEvent e) {
				JBAtras.setCursor(Cursor.getDefaultCursor());
				
			}
        
       
		});
        

	    add(JBAtras);
	    JBAtras.addActionListener(this);
		
		
		// Fondo 
		JLFondo = new JLabel();
		JLFondo.setBounds(0, 0, 1440, 900);
		ImageIcon iconoOriginal10 = new ImageIcon("src/Personaje_Img/CaracteristicasFondo.jpeg");
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

		if (e.getSource() == JBAtras) {
	          evento.remove(this);
	          evento.getContentPane().add(new EventoSeleccionPersonaje());
	          evento.setVisible(true);
	    
		} else if (e.getSource() == JBGuardar) {
            
			String nombre = nameTextField.getText().toLowerCase().trim();
            String clase = "Prisoner"; 

            boolean repetido = false;
            
            for (int i = 0; i < ArrayPersonajes.personajes.size(); i++) {
                if (nombre.equals(ArrayPersonajes.personajes.get(i).getNombre())) {
                    repetido = true;
                    break;
                }
            }
            
            if (repetido) {
            	JOptionPane.showMessageDialog(this, "El nombre del personaje ya está en uso. Introduce otro nombre.", "Nombre Repetido", JOptionPane.WARNING_MESSAGE);
            } else {
            	Prisoner personaje = new Prisoner(nombre, ArrayPersonajes.vida, ArrayPersonajes.numMis, clase);
                
            	ArrayPersonajes.personajes.add(personaje);
                
                ArrayPersonajes.numPerso--;
                
                if (ArrayPersonajes.getNumPerso() == 0) {
                    evento.remove(this);
                    evento.getContentPane().add(new EventoAtacDefe());
                    evento.setVisible(true);
                } else {
                    evento.remove(this);
                    evento.getContentPane().add(new EventoSeleccionPersonaje());
                    evento.setVisible(true);
                }
            }
        }
	}
	
}

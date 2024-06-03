package Normas;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Menu.EventoMenu;

public class EventoNormas extends JPanel implements ActionListener{
	
	private JLabel JLFondo;
	private ImageIcon Icono01;
	private JButton JBAtras;
	
	public EventoNormas() {
		
		setLayout(null);
		
		Icono01 = new ImageIcon("src/Creador_Img/BotonAtras.png");
		JBAtras = new JButton(Icono01);
		JBAtras.setBounds(1100, 590, 500,400 ); 
		JBAtras.setContentAreaFilled(false);
		JBAtras.setBorder(null);
	    add(JBAtras);
	    JBAtras.addActionListener(this);
	    
		JLFondo = new JLabel();
		JLFondo.setBounds(0, 0, 1440, 900);
		ImageIcon iconoOriginal10 = new ImageIcon("src/Normas/NormasFondo2.png");
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
	          evento.getContentPane().add(new EventoMenu());
	          evento.setVisible(true);
	     }
		
	}

}

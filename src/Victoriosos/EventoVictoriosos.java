package Victoriosos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import Menu.EventoMenu;
import Musica.CancionMenu;

import java.awt.*;
import java.io.*;
import javax.swing.*;

public class EventoVictoriosos extends JPanel implements ActionListener {

    private JLabel JLFondo;
    private JButton JBAtras;
    private ImageIcon Icono01;
    public static JTextPane textArea;
    private JLabel JLVictoriosos;

    public EventoVictoriosos() {
        
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
			font2 = Font.createFont(Font.TRUETYPE_FONT, new File("src/Fonts/Mantinia Regular.otf")).deriveFont(40f);
		} catch (FontFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		JLVictoriosos = new JLabel("VICTORIOSOS");
		JLVictoriosos.setBounds(570, 100, 400, 50);
		JLVictoriosos.setForeground(colorFuente);
		JLVictoriosos.setBorder(null);
		JLVictoriosos.setFont(font2);
		add(JLVictoriosos);

        textArea = new JTextPane();
        textArea.setOpaque(false); 
        textArea.setBorder(null); 
        textArea.setEditable(false);
        textArea.setForeground(colorFuente); 
        textArea.setFont(font);
        textArea.setBounds(580, 200, 300, 500); 
        add(textArea);

        Icono01 = new ImageIcon("src/Creador_Img/BotonAtras.png");
        JBAtras = new JButton(Icono01);
        JBAtras.setBounds(1100, 590, 500, 400);
        JBAtras.setContentAreaFilled(false);
        JBAtras.setBorder(null);

        leerFichero();

        JBAtras.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {
                CancionMenu.MusicaMenu("src/Clips/SonidoAtras.wav");
            }

            @Override
            public void mouseReleased(MouseEvent e) {}

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
        ImageIcon iconoOriginal10 = new ImageIcon("src/Victoriosos/FondoVictoriosos.jpeg");
        Image imagenOriginal10 = iconoOriginal10.getImage();
        Image imagenRedimensionada10 = imagenOriginal10.getScaledInstance(1440, 900, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado10 = new ImageIcon(imagenRedimensionada10);
        JLFondo.setIcon(iconoRedimensionado10);
        add(JLFondo);
    }

    static String ruta = "src/Victoriosos/ganadores.txt";
    static ArrayList<Datos> listaDatos = new ArrayList<Datos>();

    public static void guardarFichero(String ganador) { 
    	boolean existe = false;

        try {
            FileReader fr = new FileReader(ruta);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            listaDatos.clear();

            do {
                if ((line = br.readLine()) != null) {
                    String[] lineP = line.split(" ");
                    Datos d = new Datos(lineP[0], Integer.parseInt(lineP[1]));

                    listaDatos.add(d);
                }

            } while ((line = br.readLine()) != null);

            fr.close();
            br.close();
        } catch (IOException e) {
            System.out.println("Error E/S: " + e);
        }

        for (Datos datos : listaDatos) {

            if (datos.getNombre().equalsIgnoreCase(ganador)) {

                datos.setVictorias(datos.getVictorias() + 1);

                existe = true;

                break;
            }
        }
        if (!existe) {
            Datos d = new Datos(ganador, 1);
            listaDatos.add(d);
        }

        escribirFichero();
    }

    public static void escribirFichero() { // Funcion para escribir el fichero

        try {

            FileWriter fw = new FileWriter(ruta, false);

            BufferedWriter bw = new BufferedWriter(fw);

            for (Datos d : listaDatos) {

                bw.write(d.getNombre() + " " + d.getVictorias() + "\n");
            }

            bw.close();

            fw.close();

        } catch (IOException e) {

            System.out.println("Error E/S: " + e);
        }
    }

    public static void leerFichero() { // Funcion para leer el fichero

        StringBuilder contenido = new StringBuilder();
        try {
            FileReader fr = new FileReader(ruta);
            BufferedReader br = new BufferedReader(fr);
            String line;

            while ((line = br.readLine()) != null) {
                contenido.append(line).append("\n");
            }

            fr.close();
            br.close();
        } catch (IOException e) {
            System.out.println("Error E/S: " + e);
        }
        
        StyledDocument doc = textArea.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
        
        textArea.setText(contenido.toString());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JFrame evento = (JFrame) SwingUtilities.getWindowAncestor(this);

        if (e.getSource() == JBAtras) {
            evento.remove(this);
            evento.getContentPane().add(new EventoMenu());
            evento.setVisible(true);
        }

    }

}


/**
 * 
 */
package uptc.edu.taller.gui;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * @author Carolina Cardozo
 * clase que contiene todos los elementos que hacen parte de la interfaz grafica
 */
public class Panel extends JPanel {

	private VentanaPrincipal ventana;
	private JLabel modulo1,modulo2,modulo3,estadomodulo1,estadomodulo2,estadomodulo3, estado;
	private JScrollPane contFila;
	private JPanel fila;
	private JTextArea modulo1info, modulo2info, modulo3info;
	private JButton anadir;
	private JProgressBar barra1, barra2, barra3;

	/**
	 * @param constructor de la clase que tiene como parametro VentanaPrincipal y
	 * agrega los componentes 
	 */
	public Panel(VentanaPrincipal ventana){
		this.ventana = ventana;
		setLayout(null);
		inicializarComponentes();

		add(modulo1);
		add(modulo2);
		add(modulo3);

		JLabel a = new JLabel("MODULO A");
		a.setBounds(80, 20, 250, 20);

		JLabel b = new JLabel("MODULO B");
		b.setBounds(310, 20, 250, 20);

		JLabel c = new JLabel("MODULO C");
		c.setBounds(550, 20, 250, 20);

		add(a);
		add(b);
		add(c);

		estadomodulo1 = new JLabel("    LIBRE"); 
		estadomodulo1.setBounds(80, 220, 250, 20);
		add(estadomodulo1);

		estadomodulo2 = new JLabel("    LIBRE"); 
		estadomodulo2.setBounds(310, 220, 250, 20);
		add(estadomodulo2);

		estadomodulo3 = new JLabel("    LIBRE"); 
		estadomodulo3.setBounds(550, 220, 250, 20);
		add(estadomodulo3);

		add(contFila);
	}
	
	/**
	 * metodo que inicializa los componentes y agrega imagenes a los modulos
	 */
	private void inicializarComponentes(){
		
		modulo1 = new JLabel();
		modulo1.setIcon(new ImageIcon(getClass().getResource("/icons/deskman.png")));
		
		modulo2 = new JLabel();
		modulo2.setIcon(new ImageIcon(getClass().getResource("/icons/deskwoman.png")));
		
		modulo3 = new JLabel();
		modulo3.setIcon(new ImageIcon(getClass().getResource("/icons/deskwoman2.png")));
		
		modulo1.setBounds(20, 40, 250, 200);
		modulo2.setBounds(255, 40, 250, 200);
		modulo3.setBounds(492, 40, 250, 200);

		modulo1info = new JTextArea();
		modulo1info.setOpaque(false);
		modulo1info.setEditable(false);
		modulo1info.setBounds(20, 240, 250, 100);
		add(modulo1info);

		barra1 = new JProgressBar();
		barra1.setBounds(20, 270, 185, 20);
		add(barra1);

		modulo2info = new JTextArea();
		modulo2info.setEditable(false);
		modulo2info.setOpaque(false);
		modulo2info.setBounds(255, 240, 250, 200);
		add(modulo2info);

		barra2 = new JProgressBar();
		barra2.setBounds(255, 270, 185, 20);
		add(barra2);

		modulo3info = new JTextArea();
		modulo3info.setEditable(false);
		modulo3info.setOpaque(false);
		modulo3info.setBounds(492, 240, 250, 200);
		add(modulo3info);

		barra3 = new JProgressBar();
		barra3.setBounds(492, 270, 185, 20);
		add(barra3);

		fila = new JPanel();
		fila.setLayout(new BoxLayout(fila, BoxLayout.Y_AXIS));
		fila.setBackground(Color.white);
		contFila = new JScrollPane(fila);
		contFila.setBounds(240, 330, 210, 320);
		estado = new JLabel();
		estado.setBounds(230, 140, 250, 342);
		add(estado);

		anadir = new JButton("Agregar a la cola");
		anadir.setBounds(268, 660, 150, 30);
		anadir.setFocusable(false);
		anadir.addActionListener(ventana.getEventos());
		anadir.setActionCommand(GestionEventos.ADD);

		add(anadir);
	}

	/**
	 * @return the ventana
	 */
	public VentanaPrincipal getVentana() {
		return ventana;
	}

	/**
	 * @param ventana the ventana to set
	 */
	public void setVentana(VentanaPrincipal ventana) {
		this.ventana = ventana;
	}

	/**
	 * @return the modulo1
	 */
	public JLabel getModulo1() {
		return modulo1;
	}

	/**
	 * @param modulo1 the modulo1 to set
	 */
	public void setModulo1(JLabel modulo1) {
		this.modulo1 = modulo1;
	}

	/**
	 * @return the modulo2
	 */
	public JLabel getModulo2() {
		return modulo2;
	}

	/**
	 * @param modulo2 the modulo2 to set
	 */
	public void setModulo2(JLabel modulo2) {
		this.modulo2 = modulo2;
	}

	/**
	 * @return the modulo3
	 */
	public JLabel getModulo3() {
		return modulo3;
	}

	/**
	 * @param modulo3 the modulo3 to set
	 */
	public void setModulo3(JLabel modulo3) {
		this.modulo3 = modulo3;
	}

	/**
	 * @return the estadomodulo1
	 */
	public JLabel getEstadomodulo1() {
		return estadomodulo1;
	}

	/**
	 * @param estadomodulo1 the estadomodulo1 to set
	 */
	public void setEstadomodulo1(JLabel estadomodulo1) {
		this.estadomodulo1 = estadomodulo1;
	}

	/**
	 * @return the estadomodulo2
	 */
	public JLabel getEstadomodulo2() {
		return estadomodulo2;
	}

	/**
	 * @param estadomodulo2 the estadomodulo2 to set
	 */
	public void setEstadomodulo2(JLabel estadomodulo2) {
		this.estadomodulo2 = estadomodulo2;
	}

	/**
	 * @return the estadomodulo3
	 */
	public JLabel getEstadomodulo3() {
		return estadomodulo3;
	}

	/**
	 * @param estadomodulo3 the estadomodulo3 to set
	 */
	public void setEstadomodulo3(JLabel estadomodulo3) {
		this.estadomodulo3 = estadomodulo3;
	}

	/**
	 * @return the estado
	 */
	public JLabel getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(JLabel estado) {
		this.estado = estado;
	}

	/**
	 * @return the contFila
	 */
	public JScrollPane getContFila() {
		return contFila;
	}

	/**
	 * @param contFila the contFila to set
	 */
	public void setContFila(JScrollPane contFila) {
		this.contFila = contFila;
	}

	/**
	 * @return the fila
	 */
	public JPanel getFila() {
		return fila;
	}

	/**
	 * @param fila the fila to set
	 */
	public void setFila(JPanel fila) {
		this.fila = fila;
	}

	/**
	 * @return the modulo1info
	 */
	public JTextArea getModulo1info() {
		return modulo1info;
	}

	/**
	 * @param modulo1info the modulo1info to set
	 */
	public void setModulo1info(JTextArea modulo1info) {
		this.modulo1info = modulo1info;
	}

	/**
	 * @return the modulo2info
	 */
	public JTextArea getModulo2info() {
		return modulo2info;
	}

	/**
	 * @param modulo2info the modulo2info to set
	 */
	public void setModulo2info(JTextArea modulo2info) {
		this.modulo2info = modulo2info;
	}

	/**
	 * @return the modulo3info
	 */
	public JTextArea getModulo3info() {
		return modulo3info;
	}

	/**
	 * @param modulo3info the modulo3info to set
	 */
	public void setModulo3info(JTextArea modulo3info) {
		this.modulo3info = modulo3info;
	}

	/**
	 * @return the anadir
	 */
	public JButton getAnadir() {
		return anadir;
	}

	/**
	 * @param anadir the anadir to set
	 */
	public void setAnadir(JButton anadir) {
		this.anadir = anadir;
	}

	/**
	 * @return the barra1
	 */
	public JProgressBar getBarra1() {
		return barra1;
	}

	/**
	 * @param barra1 the barra1 to set
	 */
	public void setBarra1(JProgressBar barra1) {
		this.barra1 = barra1;
	}

	/**
	 * @return the barra2
	 */
	public JProgressBar getBarra2() {
		return barra2;
	}

	/**
	 * @param barra2 the barra2 to set
	 */
	public void setBarra2(JProgressBar barra2) {
		this.barra2 = barra2;
	}

	/**
	 * @return the barra3
	 */
	public JProgressBar getBarra3() {
		return barra3;
	}

	/**
	 * @param barra3 the barra3 to set
	 */
	public void setBarra3(JProgressBar barra3) {
		this.barra3 = barra3;
	}
	
}

/**
 * 
 */
package uptc.edu.taller.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Carolina Cardozo
 * clase que realiza la gestion de los eventos (botonera)para la interfaz grafica
 *
 */
public class GestionEventos implements ActionListener{

	private VentanaPrincipal ventana;
    public static final String ADD = "Agregar a la cola";
    
	/**
	 * @param constructor de la clase
	 */
	public GestionEventos(VentanaPrincipal ventana) {
		super();
		this.ventana = ventana;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand().equals(ADD)) {

		    ventana.anadiraCola();
		}
	}
}

/**
 * 
 */
package uptc.edu.taller.logic;

/**
 * @author Carolina Cardozo
 * clase que describe el objeto Nodo
 *
 */
public class Nodo {

	/**  atributos */
	private Turno turno;
	private Nodo next;
	
	/**
	 * @param turno
	 * constructor de la clase nodo que recibe como parametro un Turno
	 */
	public Nodo(Turno turno) {
		super();
		this.turno = turno;
	}

	/**
	 * @return the turno
	 */
	public Turno getTurno() {
		return turno;
	}

	/**
	 * @param turno the turno to set
	 */
	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	/**
	 * @return the next
	 */
	public Nodo getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(Nodo next) {
		this.next = next;
	}
	
}

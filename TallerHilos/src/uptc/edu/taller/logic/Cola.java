/**
 * 
 */
package uptc.edu.taller.logic;

/**
 * @author Carolina Cardozo
 * clase que describe el objeto Cola
 *
 */
public class Cola {

	/**  atributos */
	private Nodo head;

	/**
	 *  constructor de la clase Cola
	 */
	public Cola() {
		super();
	}

	/**
	 *   @param Turno
	 *   metodo que agrega un turno(nodo) busca si existe, si no el turno es igual a head
	 *   retorna vacio
	 */
	public  void addTurno(Turno turno) {

		Nodo aux;
		Nodo newNode = new Nodo(turno);

		if (isEmpty()) {
			head = newNode;
		}

		else {

			aux = head;

			while (aux.getNext() != null) {
				aux = aux.getNext();
			}
			aux.setNext(newNode);
		}
	}

	/**
	 *   metodo que retorna un entero con el valor del peso y lo acumula en un contador.
	 */
	public int getWeight(){
		int cuenta = 0;
		Nodo  aux = head;
		while (aux != null) {
			cuenta += 1;
			aux = aux.getNext();
		}
		return cuenta;
	}

	public void removeHead(){
		head = head.getNext();
	}

	/**
	 *   metodo que retorna un boolean si el nodo esta vacio
	 */
	public boolean isEmpty() {

		if (head == null) {
			return true;
		}
		return false;
	}

	/**
	 *   metodo que lista cada uno de los nodos existentes 
	 */
	public void listNodes() {

		Nodo aux = head;
		String next;

		if (isEmpty()) {
			System.out.println("la cola esta vacia");
		} else {
			do {

				if (aux.getNext() != null) {
					next = aux.getNext().getTurno().toString();
				} else {
					next = "null";
				}

				System.out.println(aux.getTurno().toString() + "  --  " + "next= "
						+ next);
				aux = aux.getNext();
			} while (aux != null);
		}

	}

	/**
	 * @return the head
	 */
	public Nodo getHead() {
		return head;
	}

	/**
	 * @param head the head to set
	 */
	public void setHead(Nodo head) {
		this.head = head;
	}
}

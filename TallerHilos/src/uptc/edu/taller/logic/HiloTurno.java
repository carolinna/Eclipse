/**
 * 
 */
package uptc.edu.taller.logic;

import java.util.ArrayList;

/**
 * @author  Carolina Cardozo
 * clase que describe el objeto HiloTurno y extiende de Thread
 */
public class HiloTurno extends Thread{

	/**  atributos */
	private Cola  cola;
    private int ultimoTurno = 0; 
	
	/**
	 * constructor de la clase que recibe como parametro un objeto Cola
	 * @param cola
	 */
	public HiloTurno(Cola cola) {
		super();
		this.cola = cola;
	}
	 @Override
	    public void run() {
		if (cola.isEmpty()){
		    Turno turno = new Turno(ultimoTurno+1);
		        cola.addTurno(turno);
		        ultimoTurno = ultimoTurno + 1;
		}
		else{
		    Nodo ultimo = null;
		    Nodo aux = cola.getHead();
		    while(aux != null){
			if (aux.getNext() == null){
			    ultimo = aux;
			}
			aux = aux.getNext();
		    }
		    Turno turno = new Turno(ultimo.getTurno().getTurno()+1);
		        cola.addTurno(turno);
		        ultimoTurno = ultimo.getTurno().getTurno()+1;
		}
	        
	    }
	}

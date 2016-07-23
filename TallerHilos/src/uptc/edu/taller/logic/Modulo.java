/**
 * 
 */
package uptc.edu.taller.logic;

import java.util.Random;

/**
 * @author Carolina Cardozo
 *  clase que describe el objeto Modulo y extiende de Thread
 */
public class Modulo extends Thread{
	
	/**  atributos */
    private Turno cliente;
	private String nombre;
    private boolean ocupado;
    private int tiempo;
    
	/**
	 * contructor de la clase Modulo que tiene como parametro un String
	 * @param nombre
	 */
	public Modulo(String nombre) {
		super();
		this.nombre = nombre;
		ocupado = false;
		cliente = null;
	}
	/**
	 * metodo de tipo boolean que retorna si el modulo se encuentra ocupado o no.
	 */
    public boolean isOcupado() {
	return ocupado;
    }
    
	 /**
	 * @return the cliente
	 */
	public Turno getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Turno cliente) {
		this.cliente = cliente;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return the tiempo
	 */
	public int getTiempo() {
		return tiempo;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * @param ocupado the ocupado to set
	 */
	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

	@Override
	    public void run() {
		while (true) {
		    try {
			sleep(0);

			if (ocupado == true) {

			    Random rnd = new Random();
			    int numero = 7000;
			    tiempo = numero;
			    sleep(numero+1000);
			    setOcupado(false);
			    tiempo = 0;

			}
		    } catch (InterruptedException e1) {
			e1.printStackTrace();
		    }
		}

	    }
    }

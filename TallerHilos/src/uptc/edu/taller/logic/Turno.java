/**
 * 
 */
package uptc.edu.taller.logic;

import java.util.Random;

/**
 * @author Carolina Cardozo
 * clase que describe el objeto Turno
 * 
 */
public class Turno {
	
	/**  atributos */
	private String cliente;
    private int turno;
          
    /**
	 * @param turno
	 *
	 */ 
	public Turno(int turno) {
		super();
		this.turno = turno;
		this.cliente = generarIdCliente();
	}
	
	/**
	  * metodo que genera aleatoriamente la identificacion del cliente
	  * apartir de 5 valores entre letras y numeros.
     */

	private String generarIdCliente(){
    	String cod = "";
    	char[] elementos={'0','1','2','3','4','5','6','7','8','9' ,'a',
    		'b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t',
    		'u','v','w','x','y','z','A',
    		'B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T',
    		'U','V','W','X','Y','Z'};
    	
    	for (int i = 0; i < 5; i++) {
    	    Random rnd = new Random();
    	    cod += elementos[rnd.nextInt(elementos.length)];   
    	}
    	return cod;
        }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Turno [cliente=" + cliente + ", turno=" + turno + "]";
	}

	/**
	 * @return the cliente
	 */
	public String getCliente() {
		return cliente;
	}

	/**
	 * @return the turno
	 */
	public int getTurno() {
		return turno;
	}
    	}

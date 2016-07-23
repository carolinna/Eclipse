/**
 * 
 */
package uptc.edu.taller.logic;

import java.util.ArrayList;

/**
 * @author Carolina Cardozo
 * clase que describe el objeto HHiloGestion y extiende de Thread
 *
 */
public class HiloGestion extends Thread {

	/**  atributos */
	private Cola turnos;
	private ArrayList<Modulo> modulos;

	/**
	 * metodo que recibe como parametros n cantidad de modulos para atender 
	 * a los clientes y respectivamente su turno
	 * @param modulo1
	 * @param modulo2
	 * @param modulo3
	 * @param turnos
	 */
	public HiloGestion(Modulo modulo1, Modulo modulo2, Modulo modulo3, Cola turnos) {
		super();
		this.turnos = turnos;
		modulos = new ArrayList<Modulo>();
		modulos.add(modulo1);
		modulos.add(modulo2);
		modulos.add(modulo3);
		this.modulos = modulos;
	}

	/**
	 * metodo que permite visualizar si un modulo esta disponible
	 */
	private Modulo getModuloDisponible() {
		for (int i = 0; i < 3; i++) {
			if (modulos.get(i).isOcupado() == false) {
				return modulos.get(i);
			}
		}
		return null;
	}

	/**
	 * metodo que permite empezar el hilo
	 */
	private void iniciarHilos() {
		for (int i = 0; i < modulos.size(); i++) {
			modulos.get(i).start();
		}
	}

	/**
	 * @return the turnos
	 */
	public Cola getTurnos() {
		return turnos;
	}

	/**
	 * @return the modulos
	 */
	public ArrayList<Modulo> getModulos() {
		return modulos;
	}

	@Override
	public void run() {
		iniciarHilos();
		while (true) {
			try {
				Modulo disponible = getModuloDisponible();
				if (disponible != null) {
					sleep(500);
					if (!turnos.isEmpty()) {
						Turno cliente = turnos.getHead().getTurno();
						disponible.setCliente(cliente);
						turnos.removeHead();
						disponible.setOcupado(true);
					}

				} else {
					sleep(2000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}


}

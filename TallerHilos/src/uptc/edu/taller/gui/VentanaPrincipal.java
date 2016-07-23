/**
 * 
 */
package uptc.edu.taller.gui;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import uptc.edu.taller.logic.Cola;
import uptc.edu.taller.logic.HiloGestion;
import uptc.edu.taller.logic.HiloTurno;
import uptc.edu.taller.logic.Modulo;
import uptc.edu.taller.logic.Nodo;

/**
 * @author Carolina Cardozo
 *clase que contiene en main 
 */
public class VentanaPrincipal extends JFrame{
	
	private HiloGestion HiloGestion;
    private Panel panel;
    private GestionEventos eventos;
    private HiloTurno hilo;
    private int time1 = 0, time2 = 0, time3 = 0;
    private boolean contar1 = false, contar2 = false, contar3 = false;

    /**
     *  Constructor de la clase 
     */
    public VentanaPrincipal() {
	super();
	setTitle("Simulacion Atencion al Cliente");
	setSize(700, 720);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setResizable(false);
	inicializarComponentes();
	iniciarHilos();
    }

    /**
     *  metodo que inicializa los componentes  
     */
    public void inicializarComponentes() {
	Modulo m1 = new Modulo("MODULO A");
	Modulo m2 = new Modulo("MODULO  B");
	Modulo m3 = new Modulo("MODULO  C");
	
	Cola turnos = new Cola();
	HiloGestion= new HiloGestion(m1, m2, m3, turnos);
	eventos = new GestionEventos(this);
	panel = new Panel(this);
	hilo = new HiloTurno(HiloGestion.getTurnos());
	add(panel);
    }

    private void llenarFila() {
	Nodo aux = HiloGestion.getTurnos().getHead();
	JTextArea t = new JTextArea();
	Font font = new Font("a", Font.BOLD, 13);
	t.setFont(font);
	String lista = "Cola:\n";
	while (aux != null) {
	    lista += "Turno: " + aux.getTurno().getTurno() + " Cliente: "
		    + aux.getTurno().getCliente() + "\n";
	    aux = aux.getNext();
	}
	t.setText(lista);
	t.setEditable(false);
	panel.getFila().removeAll();
	panel.getFila().add(t);
	panel.updateUI();
    }
     
    /**
     *  metodo que agrega un usuario al modulo  
     */
    public void anadiraCola() {
	hilo.run();
    }

    /**
     *  metodo que ejecuta los hilos  
     */
    private void iniciarHilos() {
	llenarFila();
	Thread monitor = new Thread(new Runnable() {

	    @Override
	    public void run() {
		try {
		    Thread.sleep(1000);
		    HiloGestion.start();
		    while (true) {
			Thread.sleep(20);
			llenarFila();
			boolean estadom1 = HiloGestion.getModulos().get(0)
				.isOcupado();
			boolean estadom2 = HiloGestion.getModulos().get(1)
				.isOcupado();
			boolean estadom3 = HiloGestion.getModulos().get(2)
				.isOcupado();
			if (estadom1 && estadom2 && estadom3) {
			    panel.getEstado().setText(
				    "Modulos ocupados, esperando...");
			} else {
			    panel.getEstado().setText("");
			}
			if (!estadom1 && !estadom2 && !estadom3) {
			    panel.getEstado().setText(
				    "Esperando por nuevos clientes...");
			}
			if (estadom1 == true) {
			    panel.getEstadomodulo1().setText("OCUPADO");
			    panel.getModulo1info().setText(
				    "Turno: "
					    + HiloGestion.getModulos().get(0)
						    .getCliente().getTurno()
					    + "\nCliente: "
					    + HiloGestion.getModulos().get(0)
						    .getCliente().getCliente());
			    if (HiloGestion.getModulos().get(0).getTiempo() != 0) {
				time1 = HiloGestion.getModulos().get(0).getTiempo();
				int timepart = (time1 / 100) * 7;
				panel.getBarra1().setMaximum(time1-timepart);
				contar1 = true;
			    }

			} else {
			    panel.getEstadomodulo1().setText("    LIBRE");
			    panel.getModulo1info().setText("Esperando Cliente...");
			}
			if (estadom2 == true) {
			    panel.getEstadomodulo2().setText("OCUPADO");
			    panel.getModulo2info().setText(
				    "Turno: "
					    + HiloGestion.getModulos().get(1)
						    .getCliente().getTurno()
					    + "\nCliente: "
					    + HiloGestion.getModulos().get(1)
						    .getCliente().getCliente());
			    if (HiloGestion.getModulos().get(1).getTiempo() != 0) {
				time2 = HiloGestion.getModulos().get(1).getTiempo();
				int timepart = (time2 / 100) * 7;
				panel.getBarra2().setMinimum(0);
				panel.getBarra2().setMaximum(time2-timepart);
				contar2 = true;
			    }
			} else {
			    panel.getEstadomodulo2().setText("    LIBRE");
			    panel.getModulo2info().setText("Esperando Cliente...");
			}
			if (estadom3 == true) {
			    panel.getEstadomodulo3().setText("OCUPADO");
			    panel.getModulo3info().setText(
				    "Turno: "
					    + HiloGestion.getModulos().get(2)
						    .getCliente().getTurno()
					    + "\nCliente: "
					    + HiloGestion.getModulos().get(2)
						    .getCliente().getCliente());
			    if (HiloGestion.getModulos().get(2).getTiempo() != 0) {
				time3 = HiloGestion.getModulos().get(2).getTiempo();
				int timepart = (time3 / 100) * 7;
				panel.getBarra3().setMaximum(time3-timepart);
				contar3 = true;
			    }
			} else {
			    panel.getEstadomodulo3().setText("    LIBRE");
			    panel.getModulo3info().setText("Esperando Cliente...");
			}
		    }
		} catch (InterruptedException e) {
		    // TODO Bloque catch generado automáticamente
		    e.printStackTrace();
		}

	    }
	});
	Thread hilobarra1 = new Thread(new Runnable() {

	    @Override
	    public void run() {
		while (true) {
		    try {
			Thread.sleep(0);
			int n = 0;
			while (contar1 == true) {
			    n += 1;
			    Thread.sleep(1);
			    panel.getBarra1().setValue(n);
			    if(n==time1){
				contar1=false;
			    }
			}
			time1 = 0;
			panel.getBarra1().setValue(0);
		    } catch (InterruptedException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		    }
		}

	    }
	});
	Thread hilobarra2 = new Thread(new Runnable() {

	    @Override
	    public void run() {
		while (true) {
		    try {
			Thread.sleep(0);
			int n = 0;
			while (contar2 == true) {
			    n += 1;
			    Thread.sleep(1);
			    panel.getBarra2().setValue(n);
			    if(n==time2){
				contar2=false;
			    }
			}
			time2 = 0;
			panel.getBarra2().setValue(0);
		    } catch (InterruptedException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		    }
		}

	    }
	});
	Thread hilobarra3 = new Thread(new Runnable() {

	    @Override
	    public void run() {
		while (true) {
		    try {
			Thread.sleep(0);
			int n = 0;
			while (contar3 == true) {
			    n += 1;
			    Thread.sleep(1);
			    panel.getBarra3().setValue(n);
			    if(n==time3){
				contar3=false;
			    }
			}
			time3 = 0;
			panel.getBarra3().setValue(0);
		    } catch (InterruptedException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		    }
		}

	    }
	});
	hilobarra1.start();
	hilobarra2.start();
	hilobarra3.start();
	monitor.start();
    }

	/**
	 * @return the hiloGestion
	 */
	public HiloGestion getHiloGestion() {
		return HiloGestion;
	}

	/**
	 * @return the eventos
	 */
	public GestionEventos getEventos() {
		return eventos;
	}

	/**
	 * @return the hilo
	 */
	public HiloTurno getHilo() {
		return hilo;
	}
	 public static void main(String[] args) {
			VentanaPrincipal ventana = new VentanaPrincipal();
			ventana.setVisible(true);
		    }
}

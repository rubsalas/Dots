package colas;

/**
 * Representa un Nodo de la Cola.
 *
 * @author Gabriel Gonzales
 */
public class NodoCola {
	
	private NodoCola next;
	private Jugador dato;

	/**
	 * Constructor de NodoCola.
	 * @param dato - Datos
	 * @param next - Siguiente
	 */
	public NodoCola(Jugador dato, NodoCola next){
		
		this.next = next;
		this.dato = dato;
		
	}

	//Métodos Getters y Setters

	public NodoCola getNext() {
		return next;
	}

	public void setNext(NodoCola next) {
		this.next = next;
	}

	public Jugador getDato() {
		return dato;
	}

	public void setDato(Jugador dato) {
		this.dato = dato;
	}

}
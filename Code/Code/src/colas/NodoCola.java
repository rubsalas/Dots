package colas;

public class NodoCola {
	
	private NodoCola next;
	private Jugador dato;
	
	public NodoCola(Jugador dato, NodoCola next){
		
		this.next = next;
		this.dato = dato;
		
	}

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











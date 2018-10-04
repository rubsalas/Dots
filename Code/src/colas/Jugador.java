package colas;

/**
 * Representa un Jugador.
 *
 * @author Gabriel Gonzales
 */
public class Jugador {
	
	private String usuario;
	private int cantidadFiguras;
	private int totalPuntos;
	private boolean ingame;

	/**
	 * Constructor de Jugador.
	 */
	public Jugador(){

		this.usuario = usuario;
		this.cantidadFiguras = cantidadFiguras;
		this.totalPuntos = totalPuntos;
		this.ingame = false;
		
	}

	//Métodos Getters y Setters.

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public int getCantidadFiguras() {
		return cantidadFiguras;
	}

	public void setCantidadFiguras(int cantidadFiguras) {
		this.cantidadFiguras = cantidadFiguras;
	}

	public int getTotalPuntos() {
		return totalPuntos;
	}

	public void setTotalPuntos(int totalPuntos) {
		this.totalPuntos = totalPuntos;
	}

    public boolean isIngame() { return ingame; }

    public void setIngame(boolean ingame) { this.ingame = ingame; }

}

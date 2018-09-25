package colas;

public class Jugador {
	
	private String usuario;
	private int cantidadFiguras;
	private int totalPuntos;
	private boolean ingame;
	
	public Jugador(){

		this.usuario = usuario;
		this.cantidadFiguras = cantidadFiguras;
		this.totalPuntos = totalPuntos;
		this.ingame = false;
		
	}

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

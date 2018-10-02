package game;

/**
 * Representa a un jugador.
 *
 * @author Rubén Salas
 * @version 1.1
 * @since 12/09/18
 */
public class Player {

    private String usuario;
    private int cantidadFiguras;
    private int totalPuntos;
    private boolean ingame;

    /**
     * Constructor de Player.
     */
    public Player(){
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

package plane;

/**
 * Representación de un Dot
 *
 * @author Rubén Salas
 * @version 1.0
 * @since 09/11/18
 */
public class Dot {

    private Dot next;
    private Dot prev;
    private int diametro;
    private double posX; //posicion en X
    private double posY; //posicion en Y
    private String name;

    public Dot(String name){
        this.next = null;
        this.prev = null;
        this.diametro = 50;
        this.posX = 0;
        this.posY = 0;
        this.name = name;
    }

    public Dot(double x, double y){
        this.next = null;
        this.prev = null;
        this.diametro = 50;
        this.posX = x;
        this.posY = y;
    }


    public Dot getNext() {
        return next;
    }

    public void setNext(Dot next) {
        this.next = next;
    }

    public Dot getPrev() {
        return prev;
    }

    public void setPrev(Dot prev) {
        this.prev = prev;
    }

    public int getDiametro() {
        return diametro;
    }

    public void setDiametro(int diametro) {
        this.diametro = diametro;
    }

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

}

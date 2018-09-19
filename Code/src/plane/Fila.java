package plane;

/**
 * Representación de una Fila
 *
 * @author Rubén Salas
 * @version 1.0
 * @since 09/11/18
 */
public class Fila {

    private Dot head;
    private Dot tail;
    private int size;
    private String name;

    private Fila next;
    private Fila prev;

    public Fila(String name) {
        this.head = null;
        this. tail = null;
        this.size = 0;
        this.next = null;
        this.prev = null;
        this.name = name;

    }

    public Dot getHead() {
        return head;
    }

    public void setHead(Dot head) {
        this.head = head;
    }

    public Object getTail() {
        return tail;
    }

    public void setTail(Dot tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) { this.size = size; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Fila getNext() {
        return next;
    }

    public void setNext(Fila next) {
        this.next = next;
    }

    public Fila getPrev() {
        return prev;
    }

    public void setPrev(Fila prev) {
        this.prev = prev;
    }

    /**
     * Consulta si la lista está vacía.
     *
     * @return true si el primer Enemy (head), no apunta a otro Enemy.
     */
    public boolean itsEmpty(){
        return this.head == null;
    }

    /**
     * Agrega un nuevo Dot al final de la lista.
     * @param newDot - nuevo Dot por ingresar en lista
     */
    public void add(Dot newDot){
        if (this.itsEmpty()) { //Verifica que la lista esté vacia
            setHead(newDot); //Agrega como head a newDot
        }
        else { //Recorre la lista hasta llegar al último Dot
            Dot temp = this.getHead(); //Crea un Dot temporal para referencia
            while(temp.getNext() != null){ //Recorre la lista hasta llegar al ultimo Dot
                temp = temp.getNext();
            }
            temp.setNext(newDot); //Agrega a newDot al final de la lista
        }
        this.setSize(this.getSize()+1);
    }

    /**
     * Imprime la Fila
     */
    public void print(){
        Dot temp = getHead();
        while (temp != null){
            System.out.print(temp.getName() + "   ");
            temp = temp.getNext();
        }
    }

}
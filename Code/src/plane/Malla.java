package plane;

/**
 * Representación de la Malla
 *
 * @author Rubén Salas
 * @version 1.0
 * @since 09/11/18
 */
public class Malla {

    private Fila head;
    private Fila tail;
    private int size;
    private String name;


    public Malla(){
        this.head = null;
        this.tail = null;
        this.size = 0;
        this.name = "Malla";
    }

    public Fila getHead() {
        return head;
    }

    public void setHead(Fila head) {
        this.head = head;
    }

    public Fila getTail() {
        return tail;
    }

    public void setTail(Fila tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
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
     * Agrega una nueva Fila al final de la lista.
     * @param newFila - nueva Fila por ingresar en lista
     */
    public void add(Fila newFila){
        if (this.itsEmpty()) { //Verifica que la lista esté vacia
            this.setHead(newFila); //Agrega como head a newFila
        }
        else { //Recorre la lista hasta llegar a la última Fila
            Fila temp = this.getHead(); //Crea una Fila temporal para referencia
            while(temp.getNext() != null){ //Recorre la lista hasta llegar a la ultima Fila
                temp = temp.getNext();
            }
            temp.setNext(newFila); //Agrega a newFila al final de la lista
        }
        this.setSize(this.getSize()+1);
        //System.out.println("Added: " + newFila.getName());
    }

    /**
     * Imprime la Malla
     */
    public void print(){
        Fila temp = getHead();
        while (temp != null){
            System.out.print(temp.getName() + ":   ");
            temp.print(); //Imprime la Fila
            System.out.println("");
            temp = temp.getNext();
        }
    }




}



package plane;

import org.json.JSONException;

import static game.Main.drawFromSegment;

/**
 * Representacion de una Lista
 *
 * @author Rubén Salas
 * @version 1.4
 * @since 11/09/18
 *
 */
public class Lista {

    private Segmento head;
    private Segmento tail;
    private int size;
    private String name;

    /**
     * Constructor de Lista.
     * @param name - Nombre
     */
    public Lista(String name){
        this.head = null;
        this.tail = null;
        this.size = 0;
        this.name = name;
    }

    //Métodos setters y getters

    public Segmento getHead() {
        return head;
    }

    public void setHead(Segmento head) {
        this.head = head;
    }

    public Segmento getTail() {
        return tail;
    }

    public void setTail(Segmento tail) {
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
     * @return true si el primer Enemy (head), no apunta a otro Enemy.
     */
    public boolean itsEmpty(){
        return this.head == null;
    }

    /**
     * Agrega una nueva Line al final de la lista.
     * @param newLine - nueva Line por ingresar en lista
     */
    public void add(Segmento newLine){
        if (this.itsEmpty()) { //Verifica que la lista esté vacia
            this.setHead(newLine); //Agrega como head a newFila
        }
        else { //Recorre la lista hasta llegar a la última Fila
            Segmento temp = this.getHead(); //Crea una Fila temporal para referencia
            while(temp.getNext() != null){ //Recorre la lista hasta llegar a la ultima Fila
                temp = temp.getNext();
            }
            temp.setNext(newLine); //Agrega a newLine al final de la lista
        }
        this.setSize(this.getSize()+1);
    }

    /**
     * Muestra la lista en la interfaz.
     */
    public void show() throws JSONException {
        Segmento temp = this.getHead();

        while (temp != null){

            drawFromSegment(temp);

            temp = temp.getNext();
        }
    }

    /**
     * Busca un segmento con dos Dots dados.
     * @param dot1 - Dot inicial
     * @param dot2 - Dot final
     * @return Segmento encontrado
     */
    public Segmento search(Dot dot1, Dot dot2){
        Segmento temp = this.getHead();

        while (temp != null){

            if (temp.getFirst() == dot1 ||  temp.getLast() == dot1){
                if (temp.getFirst() == dot2 ||  temp.getLast() == dot2){
                    return temp;
                }
            }

            temp = temp.getNext();
        }
        return null;
    }

}

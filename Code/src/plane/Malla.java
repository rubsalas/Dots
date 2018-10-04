package plane;

/**
 * Representación de la Malla
 *
 * @author Rubén Salas
 * @version 1.2
 * @since 09/11/18
 */
public class Malla {

    private Fila head;
    private int size;

    /**
     * Constructor de Malla.
     */
    public Malla(){
        this.head = null;
        this.size = 0;
    }

    //Métodos setters y getters

    public Fila getHead() {
        return head;
    }

    public void setHead(Fila head) {
        this.head = head;
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
     * Muestra la malla en la interfaz.
     */
    public void show(){
        Fila temp = getHead();

        System.out.println("Showing Malla");

        while (temp != null){

            temp.show(); //Imprime la Fila
            temp = temp.getNext(); //Pasa a la siguiente Fila
        }
    }

    /**
     * Buscará en todas sus filas a un Dot específico con sus coordenadas x y y dadas.
     * @param x - coordenada x
     * @param y - coordenada y
     * @return Dot encontrado
     */
    public Dot search(double x, double y){
        //Crea un temporal para las filas
        Fila temp = getHead();

        //Define un punto para guardar el encontrado
        Dot found = null;

        //Mientras recorre la malla (lista de Filas)
        while (temp != null){

            //Se guardará el resultado de la busqueda de cada fila
            Dot aux = temp.search(x,y); //Busca en la Fila

            //Si se encuentra el Dot
            if (aux != null){
                //Se guarda en la variable
                found = aux;
            }

            //Pasa a la siguiente Fila
            temp = temp.getNext();

        }

        //Retorna el Dot encontrado
        return found;

    }

}
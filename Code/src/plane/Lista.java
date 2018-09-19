package plane;

/**
 * Representacion de una Lista
 *
 * @author Rubén Salas
 * @version 1.0
 * @since 11/09/18
 *
 */
public class Lista {




    public Lista(){

    }







    /**
     * Muestra la Hilera en pantalla
     */
    /**
    public void show(){
        Enemy temp = this.getHead();

        this.setYs();

        while(temp != null){ //Recorre la lista hasta llegar al ultimo Enemy
            temp.getImage().setFitHeight(80);
            temp.getImage().setFitWidth(80);
            temp.getImage().setLayoutX(temp.getPosX()-25);
            temp.getImage().setLayoutY(temp.getPosY());

            System.out.println(temp.getImage().getLayoutX());
            System.out.println(temp.getImage().getLayoutY());

            TranslateTransition trans = new TranslateTransition();
            trans.setDuration(Duration.millis(super.getSpeedY()));
            trans.setNode(temp.getImage());
            trans.setToY(430);
            trans.play();

            TranslateTransition trans2 = new TranslateTransition();
            trans2.setDuration(Duration.millis(4000));
            trans2.setNode(temp.getImage());
            trans2.setToX(50);
            trans2.setAutoReverse(true);
            trans2.setCycleCount(TranslateTransition.INDEFINITE);
            trans2.play();

            temp = temp.getNext();
        }

    }
    **/



}
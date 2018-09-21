package game;

import javafx.scene.image.ImageView;
import server.*;
import colas.Jugador;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import org.json.JSONException;

import java.awt.*;
import java.awt.geom.Line2D;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Main, tiene la interfaz del juego.
 *
 * @author Rubén Salas
 * @version 2.0
 * @since 09/11/18
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    //Variables de interfaz

    private int width = 575; //largo en pixeles
    private int height = 625; //alto en pixeles

    private String[] args; //variable para iniciar el cliente

    private Stage stage;

    private Stage stageInGame = new Stage();
    private Stage stageInQueue = new Stage();

    private Scene sceneConnection;
    private Scene sceneGame;

    Image imageDot = new Image(getClass().getResourceAsStream("/images/dot1.png"));;

    static ImageView imageDot11;
    static ImageView imageDot12;
    static ImageView imageDot13;
    static ImageView imageDot14;
    static ImageView imageDot15;

    static ImageView imageDot21;
    static ImageView imageDot22;
    static ImageView imageDot23;
    static ImageView imageDot24;
    static ImageView imageDot25;

    static ImageView imageDot31;
    static ImageView imageDot32;
    static ImageView imageDot33;
    static ImageView imageDot34;
    static ImageView imageDot35;

    static ImageView imageDot41;
    static ImageView imageDot42;
    static ImageView imageDot43;
    static ImageView imageDot44;
    static ImageView imageDot45;

    static ImageView imageDot51;
    static ImageView imageDot52;
    static ImageView imageDot53;
    static ImageView imageDot54;
    static ImageView imageDot55;

    private BackgroundImage backgroundConnection;

    //Coordenadas para dibujar los segmentos
    static double point1X;
    static double point1Y;
    static double point2X;
    static double point2Y;

    static boolean dosPuntos = false; //Flag que verifica si se han oprimido ambos puntos para dibujar la linea

    //Corre la interfaz
    @Override
    public void start(Stage primaryStage) throws IOException, JSONException {

        Cliente1 client = new Cliente1();
        //client.main(args); //Corre el cliente
        Jugador player = new Jugador(); //Objeto jugador
        player.setIngame(true); //Flag si está en cola o no

        stage = primaryStage; //Redefine el primary stage

        //SceneConnection

        TextField portText = new TextField(); //TextField para el IP
        portText.setLayoutX(150);
        portText.setLayoutY(350);

        TextField IPText = new TextField(); //TextField para el Puerto
        IPText.setLayoutX(150);
        IPText.setLayoutY(400);

        Button connectButton = new Button("Connect"); //Botón para probar conección
        connectButton.setMinSize(50,50);
        connectButton.setMaxSize(50,50);
        connectButton.setLayoutX(225);
        connectButton.setLayoutY(212);

        //Evento al oprimir el botón
        connectButton.setOnAction(event -> {
            if (player.isIngame()){ //Si el cliente está listo para jugar
                setStageInGame(); //Crea la ventana de espera del juego
            } else{ //Si debe esperar en la cola
                setStageInQueue(); //Crea ventana de espera en cola
            }
            stage.close(); //Cierra la ventana de conección
        });


        Pane paneConnection = new Pane(); //Pane de la primera ventana
        paneConnection.getChildren().addAll(connectButton,portText,IPText); //Ingresa el botón, y los TextFields

        //Fondo paneConnection
        backgroundConnection = new BackgroundImage(new Image("/images/wallpaper.jpg"),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        paneConnection.setBackground(new Background(backgroundConnection)); //Agrega el background

        sceneConnection = new Scene(paneConnection, width, height); //Crea un scene para la  primera ventana (Conección)


        //Scene Game

        Button gameTestButton = new Button("Close"); //Botón de prueba para cerrar el programa en la ventana del juego.
        connectButton.setMinSize(50,50);
        connectButton.setMaxSize(50,50);
        connectButton.setLayoutX(225);
        connectButton.setLayoutY(212);

        //Evento al oprimir el botón
        gameTestButton.setOnAction(event -> {
            stage.close(); //Cierra la ventana del juego
        });

        //Instancia los ImageViews de los Dots
        imageDot11 = new ImageView(imageDot);
        imageDot12 = new ImageView(imageDot);
        imageDot13 = new ImageView(imageDot);
        imageDot14 = new ImageView(imageDot);
        imageDot15 = new ImageView(imageDot);

        imageDot21 = new ImageView(imageDot);
        imageDot22 = new ImageView(imageDot);
        imageDot23 = new ImageView(imageDot);
        imageDot24 = new ImageView(imageDot);
        imageDot25 = new ImageView(imageDot);

        imageDot31 = new ImageView(imageDot);
        imageDot32 = new ImageView(imageDot);
        imageDot33 = new ImageView(imageDot);
        imageDot34 = new ImageView(imageDot);
        imageDot35 = new ImageView(imageDot);

        imageDot41 = new ImageView(imageDot);
        imageDot42 = new ImageView(imageDot);
        imageDot43 = new ImageView(imageDot);
        imageDot44 = new ImageView(imageDot);
        imageDot45 = new ImageView(imageDot);

        imageDot51 = new ImageView(imageDot);
        imageDot52 = new ImageView(imageDot);
        imageDot53 = new ImageView(imageDot);
        imageDot54 = new ImageView(imageDot);
        imageDot55 = new ImageView(imageDot);

        Pane paneGame = new Pane(); //Crea un Pane para la ventana del juego
        paneGame.getChildren().addAll(/*gameTestButton,*/
                imageDot11, imageDot12, imageDot13, imageDot14, imageDot15,
                imageDot21, imageDot22, imageDot23, imageDot24, imageDot25,
                imageDot31, imageDot32, imageDot33, imageDot34, imageDot35,
                imageDot41, imageDot42, imageDot43, imageDot44, imageDot45,
                imageDot51, imageDot52, imageDot53, imageDot54, imageDot55); //Ingresa el botón

        MallaCreator mallaCreator = new MallaCreator(); //Creador de la malla
        mallaCreator.buildPlane(); //Llama a su función para crear la malla

        sceneGame = new Scene(paneGame, width, height); //Crea un scene para la ventana del juego

        //Al iniciar

        stage.setScene(sceneConnection); //Primer scene será para establecer la conección con el servidor por medio del cliente
        stage.setTitle("Dots"); //Titulo al borde de la ventana
        stage.setHeight(height); //alto
        stage.setWidth(width); //ancho
        stage.setResizable(false); //No se puede cambiar su tamaño
        stage.show(); //Muestra el stage

    }

    /**
     * Muestra la ventana de espera del juego.
     */
    private void setStageInGame(){
        System.out.println("Ready to play");

        Button connectButton = new Button("Play");
        connectButton.setLayoutX(125);
        connectButton.setLayoutY(125);

        connectButton.setOnAction(event -> {
            stageInGame.close();
            stage.setScene(sceneGame);
            stage.show();
        });

        Pane paneConnection = new Pane();
        paneConnection.getChildren().addAll(connectButton);

        Scene sceneConnection = new Scene(paneConnection, width, height);

        stageInGame.setScene(sceneConnection);

        stageInGame.setTitle("Game");
        stageInGame.setHeight(300);
        stageInGame.setWidth(300);
        stageInGame.setResizable(false);
        stageInGame.show();
    }

    /**
     * Muestra la ventana de espera al estar en cola.
     */
    private void setStageInQueue(){
        System.out.println("In Queue");


        Button connectButton = new Button("Play");
        connectButton.setMinSize(50,50);
        connectButton.setMaxSize(50,50);
        connectButton.setLayoutX(125);
        connectButton.setLayoutY(112);

        connectButton.setOnAction(event -> {
            stageInQueue.close();
            stage.setScene(sceneGame);
            stage.show();
        });

        connectButton.setOnMouseEntered(event -> {
            System.out.println("Mouse");
        });

        Pane paneConnection = new Pane();
        paneConnection.getChildren().addAll(connectButton);

        Scene sceneConnection = new Scene(paneConnection, width, height);

        stageInQueue.setScene(sceneConnection);

        stageInQueue.setTitle("Queue");
        stageInQueue.setHeight(300);
        stageInQueue.setWidth(300);
        stageInQueue.setResizable(false);
        stageInQueue.show();
    }

    /**
     * DIBUJARÁ los segmentos entre Dots mientras verifica si es posible dibujarlos.
     * @param x
     * @param y
     */
    public static void draw(double x, double y){

        if(!dosPuntos){
            point1X = x;
            point1Y = y;
            dosPuntos = true;
            System.out.println(point1X + "  " + point1Y);
        } else{

            //Hacer if que si x y y son iguales a x y y del 1 se quite la seleccion del punto 1

            point2X = x;
            point2Y = y;
            System.out.println(point2X + "  " + point2Y);

            double x1 = point1X;
            double y1 = point1Y;
            double x2 = point2X;
            double y2 = point2Y;

            if (Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1)) <= 150) {
                System.out.println("Segment Drawn");
                dosPuntos = false;

            }else{
                System.out.println("Segment Not Drawn");
                dosPuntos = false;
            }
        }

    }

}
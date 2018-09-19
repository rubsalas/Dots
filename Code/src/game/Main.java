package game;

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
import java.io.IOException;

/**
 * Main, tiene la interfaz del juego.
 *
 * @author Rubén Salas
 * @version 1.4
 * @since 09/11/18
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    //Variables de interfaz

    private int width = 500; //largo en pixeles
    private int height = 500; //alto en pixeles

    private String[] args; //variable para iniciar el cliente

    private Stage stage;

    private Stage stageInGame = new Stage();
    private Stage stageInQueue = new Stage();

    private Scene sceneConnection;
    private Scene sceneGame;

    private BackgroundImage backgroundConnection;

    //Corre la interfaz
    @Override
    public void start(Stage primaryStage) throws IOException, JSONException {

        Cliente client = new Cliente();
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

        GameWindow gameWindow = new GameWindow();
        gameWindow.buildPlane();

        Button gameTestButton = new Button("Close"); //Botón de prueba para cerrar el programa en la ventana del juego.
        connectButton.setMinSize(50,50);
        connectButton.setMaxSize(50,50);
        connectButton.setLayoutX(225);
        connectButton.setLayoutY(212);

        //Evento al oprimir el botón
        gameTestButton.setOnAction(event -> {
            stage.close(); //Cierra la ventana del juego
        });


        Pane paneGame = new Pane(); //Crea un Pane para la ventana del juego
        paneGame.getChildren().addAll(gameTestButton); //Ingresa el botón

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
        connectButton.setMinSize(50,50);
        connectButton.setMaxSize(50,50);
        connectButton.setLayoutX(125);
        connectButton.setLayoutY(112);

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

}
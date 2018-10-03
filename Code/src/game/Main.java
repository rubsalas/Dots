package game;

import colas.Jugador;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import org.json.JSONException;
import org.json.JSONObject;
import plane.*;
import server.Cliente;
import java.io.IOException;

/**
 * Main, tiene la interfaz del juego.
 *
 * @author Rubén Salas
 * @version 3.1
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

    static Cliente client;

    private static Stage stage;

    static JSONObject jsonSegment = new JSONObject();

    private Stage stageInGame = new Stage();
    private Stage stageInQueue = new Stage();

    private Scene sceneConnection;
    private static Scene sceneGame;

    private static Malla malla;

    private Image imageDot = new Image(getClass().getResourceAsStream("/images/dot1.png"));

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

    private static Pane paneGame;
    private static Button gameTestButton;

    //private static Lista listaSegmentos = new Lista("ListaSegmentos");

    private BackgroundImage backgroundConnection;

    //Punto inicial donde se creará el segmento
    private static Dot dot0;

    //Coordenadas para dibujar los segmentos
    private static double point1X;
    private static double point1Y;
    private static double point2X;
    private static double point2Y;

    //Flag que verifica si se han oprimido ambos puntos para dibujar la linea
    private static boolean dosPuntos = false;

    //Corre la interfaz
    @Override
    public void start(Stage primaryStage) throws IOException, JSONException {

        client = new Cliente();
        client.main(args);
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

        gameTestButton = new Button("Close"); //Botón de prueba para cerrar el programa en la ventana del juego.
        connectButton.setMinSize(50,50);
        connectButton.setMaxSize(50,50);
        connectButton.setLayoutX(225);
        connectButton.setLayoutY(212);

        //Evento al oprimir el botón
        gameTestButton.setOnAction(event -> {
            stage.close(); //Cierra la ventana del juego
            //testDrawSegmentList();
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

        paneGame = new Pane(); //Crea un Pane para la ventana del juego
        paneGame.getChildren().addAll(//gameTestButton,
                imageDot11, imageDot12, imageDot13, imageDot14, imageDot15,
                imageDot21, imageDot22, imageDot23, imageDot24, imageDot25,
                imageDot31, imageDot32, imageDot33, imageDot34, imageDot35,
                imageDot41, imageDot42, imageDot43, imageDot44, imageDot45,
                imageDot51, imageDot52, imageDot53, imageDot54, imageDot55); //Ingresa el botón
        paneGame.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY))); //Fondo blanco


        MallaCreator mallaCreator = new MallaCreator(); //Creador de la malla
        mallaCreator.buildPlane(); //Llama a su función para crear la malla
        mallaCreator.buildSegments(); //Llama a función para crear los segmentos horizontales
        malla = mallaCreator.getMalla(); //Instancia la malla

        sceneGame = new Scene(paneGame, width, height); //Crea un scene para la ventana del juego

        //Al iniciar

        stage.setScene(sceneConnection); //Primer scene será para establecer la conección con el servidor por medio del cliente
        stage.setTitle("Inicio"); //Titulo al borde de la ventana
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

        //Crea un botón
        Button connectButton = new Button("Play");
        connectButton.setLayoutX(125);
        connectButton.setLayoutY(125);

        //Acción del botón
        connectButton.setOnAction(event -> {
            stageInGame.close();
            stage.setScene(sceneGame);
            stage.show();
        });

        //Crea un pane
        Pane paneInGame = new Pane();
        paneInGame.getChildren().addAll(connectButton);
        paneInGame.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY))); //Fondo blanco

        Scene sceneConnection = new Scene(paneInGame, width, height);

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

        //Crea un botón
        Button connectButton = new Button("Play");
        connectButton.setMinSize(50,50);
        connectButton.setMaxSize(50,50);
        connectButton.setLayoutX(125);
        connectButton.setLayoutY(112);

        //Acción del botón
        connectButton.setOnAction(event -> {
            stageInQueue.close();
            stage.setScene(sceneGame);
            stage.show();
        });

        //Test Mouse
        connectButton.setOnMouseEntered(event ->
                System.out.println("Mouse"));

        //Crea un pane
        Pane paneQueue = new Pane();
        paneQueue.getChildren().addAll(connectButton);
        paneQueue.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY))); //Fondo blanco

        Scene sceneConnection = new Scene(paneQueue, width, height);

        stageInQueue.setScene(sceneConnection);

        stageInQueue.setTitle("Queue");
        stageInQueue.setHeight(300);
        stageInQueue.setWidth(300);
        stageInQueue.setResizable(false);
        stageInQueue.show();
    }


    /**
     * Dibuja la linea en la interfaz desde un segmento dado al inicio ya predefinido.
     * @param segment Segmento
     */
    public static void drawFromSegment(Segmento segment){

        //Agrega la linea al pane
        paneGame.getChildren().add(segment.getLine());

        //Pone los Dots al frente de la linea
        segment.getFirst().getImage().toFront();
        segment.getLast().getImage().toFront();

    }


    /**
     * Dibuja la linea en la interfaz desde un par de puntos dados por turno.
     * @param dot Dot
     */
    public static void draw(Dot dot){

        //Cuando no hay ningun Dot seleccionado
        if (!dosPuntos) {
            //Dot inicial es guardado en la variable
            dot0 = dot;
            //Guarda sus coordenadas
            point1X = dot.getPosX();
            point1Y = dot.getPosY();

            //dot0.setActualSegments(dot.getActualSegments() + 1);

            //Hace el flag verdadero para que el segundo Dot pueda escogerse
            dosPuntos = true;
            //Imprime la coordenada del Dot seleccionado
            System.out.println("(" + point1X + "  " + point1Y + ")");

        } else {
            //El segundo segmento se queda en la variable entrante de la función

            //Guarda sus coordenadas
            point2X = dot.getPosX();
            point2Y = dot.getPosY();

            //Imprime la coordenada del segundo Dot seleccionado
            System.out.println("(" + point2X + "  " + point2Y + ")");

            //Guarda las coordenadas de ambos Dots
            double x1 = point1X;
            double y1 = point1Y;
            double x2 = point2X;
            double y2 = point2Y;



            //client.setJSON(jsonSegment);

            //Obtiene la distancia entre los Dots
            double distance = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));

            /*
            La maxima distancia que se puede dibujar un segmento son 150 pixeles debido a que es la distancia entre Dots en diagonal.
            Hay 100 pixeles entre Dots horizontales y entre Dots verticales también.
            Solo tomará en cuenta cuando se escogen Dots en esa distancia ya que despues de eso ningun segmento debería ser dibujado.
            */
            if (distance <= 150 && distance > 0) {

                //Busca al segmento que esté formado por ambos Dots seleccionados
                Segmento segment = searchSegment(dot0, dot);

                //Verifica que el segmento esté disponible
                if (segment.isAvailable()) {

                    //Cuando el segmento no es diagonal
                    if (!segment.isDiagonal()) {

                        //Busca la linea con los dos Dots dados
                        Line line = segment.getLine();

                        //Pinta la linea deseada
                        line.setStroke(Color.RED);
                        line.toFront();

                    }
                    //Cuando el segmento es diagonal
                    else {

                        //Busca su diagonal contraria y la deshabilita
                        Segmento antidiagonal = getAntiDiagonal(segment);
                        antidiagonal.setAvailable(false);

                        //Busca la linea con los dos Dots dados
                        Line line = segment.getLine();

                        //Pinta la linea deseada
                        line.setStroke(Color.BLUE);
                        line.toFront();

                    }

                    //Cambia los flags de cada segmento para llevar el control de las figuras
                    segment.setDrawn(true);
                    segment.setAvailable(false);

                    //Pone los Dots al frente de la linea
                    dot0.getImage().toFront();
                    dot.getImage().toFront();

                    System.out.println("Segment Drawn");
                    //Hace el flag falso para que se vuelva a escoger el Dot inicial
                    dosPuntos = false;

                    //Agrega las coordenadas al JSON
                    try {
                        jsonPut(x1,y1,x2,y2);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    client.setJSON(jsonSegment);

                }
                //Cuando no esté disponible el segmento
                else {
                    System.out.println("Not available");
                    //Hace el flag falso para que se vuelva a escoger el Dot inicial
                    dosPuntos = false;
                }


            }
            //Cuando la distancia es 0 signiifca que el mismo Dot ha sido seleccionado, por lo tanto se deseleccionará
            else if (distance == 0) {
                //dot0.setActualSegments(dot0.getActualSegments() - 1);
                System.out.println("Unselected");
                //Hace el flag falso para que se vuelva a escoger el Dot inicial
                dosPuntos = false;

            }
            //Selección erronea de Dots
            else {
                //dot0.setActualSegments(dot0.getActualSegments() - 1);
                System.out.println("Segment Not Drawn");
                //Hace el flag falso para que se vuelva a escoger el Dot inicial
                dosPuntos = false;
            }

        }

    }

    public static void jsonPut(double x1, double y1, double x2, double y2) throws JSONException {
        jsonSegment.put("x1",x1);
        jsonSegment.put("y1",y1);
        jsonSegment.put("x2",x2);
        jsonSegment.put("y2",y2);
    }

    public static void getFromJSON(String json){
        String hola = "12345";
        char[] charArray = hola.toCharArray();
        Character g = charArray[0];
        int i = 0;
        while(i <= charArray.length){
            if(String.valueOf(charArray[0]) == ":"){

            }
        }
    }



    /**
     * Dibuja un triangulo dependiendo de su posición en los cuadrantes.
     * @param triangulo Triangulo
     * @param name Posición
     */
    public static void drawTrianguloTest(Triangulo triangulo, String name){

        //Inicializa las varibales para las coordenadas del triangulo
        double x1,y1,x2,y2,x3,y3;

        //Dependiendo de la posición del triangulo en el cuadrante se tiene que usar coordenadas diferentes de sus puntos.

        //Cuando es Lower Right o Upper Left
        if (name.equals("TriangulosLowerRight") || name.equals("TriangulosUpperLeft")) {
            x1 = triangulo.getHipotenusa().getFirst().getPosX() + 12.5;
            y1 = triangulo.getHipotenusa().getFirst().getPosY() + 12.5;
            x2 = triangulo.getVertical().getLast().getPosX() + 12.5;
            y2 = triangulo.getVertical().getLast().getPosY() + 12.5;
            x3 = triangulo.getHorizontal().getFirst().getPosX() + 12.5;
            y3 = triangulo.getHorizontal().getFirst().getPosY() + 12.5;
        }

        //Cuando es Lower Left o Upper Right
        else {
            x1 = triangulo.getHipotenusa().getFirst().getPosX() + 12.5;
            y1 = triangulo.getHipotenusa().getFirst().getPosY() + 12.5;
            x2 = triangulo.getVertical().getLast().getPosX() + 12.5;
            y2 = triangulo.getVertical().getLast().getPosY() + 12.5;
            x3 = triangulo.getHorizontal().getLast().getPosX() + 12.5;
            y3 = triangulo.getHorizontal().getLast().getPosY() + 12.5;
        }

        //Crea el triangulo con las coordenadas previamente indicadas
        Polygon triangle = new Polygon(x1, y1, x2, y2, x3, y3);

        //Ingresa el triangulo a la ventana de un color blanco
        triangle.setFill(Color.WHITE);
        triangle.setStroke(Color.WHITE);
        triangle.setStrokeWidth(1);

        //Añade el triangulo al pane
        paneGame.getChildren().add(triangle);

        //Lleva los puntos al frente de los triangulos
        triangulo.getHipotenusa().getFirst().getImage().toFront();
        triangulo.getHipotenusa().getLast().getImage().toFront();
        triangulo.getHorizontal().getFirst().getImage().toFront();
        triangulo.getHorizontal().getLast().getImage().toFront();
        triangulo.getVertical().getFirst().getImage().toFront();
        triangulo.getVertical().getLast().getImage().toFront();

    }


    /**
     * Busca a cual segmento pertenecen los puntos dados.
     * @param dot1 Dot1
     * @param dot2 Dot2
     * @return segmento
     */
    public static Segmento searchSegment(Dot dot1, Dot dot2){

        //Toma las coordenadas de los puntos
        double x1 = dot1.getPosX();
        double y1 = dot1.getPosY();
        double x2 = dot2.getPosX();
        double y2 = dot2.getPosY();

        //Verifica que tipo de segmento es
        if (x1 == x2){
            //Es un segmento horizontal al tener la misma coordenada x
            return MallaCreator.segmentosVerticales.search(dot1,dot2);
        } else if (y1 == y2) {
            //Es un segmento vertical al tener la misma coordenada y
            return MallaCreator.segmentosHorizontales.search(dot1,dot2);
        } else {
            //Es un segmento diagonal: busca en ambas listas de segmentos
            Segmento diagIzqDer = MallaCreator.segmentosDiagIzqDer.search(dot1,dot2);
            Segmento diagDerIzq = MallaCreator.segmentosDiagDerIzq.search(dot1,dot2);

            //Una de las variables será null, por lo tanto, devuelve la que es el segmento
            if (diagIzqDer != null) {
                return diagIzqDer;
            } else {
                return diagDerIzq;
            }
        }

    }


    /**
     * Busca el segmento diagonal contrario del segmento dado.
     * @param segment - Segmento diagonal
     * @return segmento diagonal contrario
     */
    public static Segmento getAntiDiagonal(Segmento segment){

        //Verifica que el segmento sea diagonal
        if (segment.isDiagonal()){

            //Toma las coordenadas de sus puntos
            double x1 = segment.getFirst().getPosX();
            double y1 = segment.getFirst().getPosY();
            double x2 = segment.getLast().getPosX();
            double y2 = segment.getLast().getPosY();

            Dot aDFirst;
            Dot aDLast;

            //Se verifica su dirección al comparar sus coordenadas

            //Si el segmento diagonal va de Izquierda a Derecha
            if(x1 < x2){
                //Se buscan los puntos en la malla
                aDFirst = malla.search(x1+100, y1);
                aDLast = malla.search(x2-100, y2);

            }
            //Si el segmento diagonal va de Derecha a Izquierda
            else {
                //Se buscan los puntos en la malla
                aDFirst = malla.search(x1-100, y1);
                aDLast = malla.search(x2+100, y2);

            }
            //Busca el segmento con los puntos buscados y lo retorna
            return searchSegment(aDFirst,aDLast);

        } else {
            return null;
        }

    }

    public void createSegmentFromJSON(double x1, double y1, double x2, double y2){
        Dot dot1 = malla.search(x1,y1);
        Dot dot2 = malla.search(x2,y2);
        Segmento segment = searchSegment(dot1,dot2);
        draw(segment.getFirst());
        draw(segment.getLast());


    }

}
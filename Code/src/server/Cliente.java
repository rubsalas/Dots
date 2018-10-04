package server;

/**
 Se descargan las librerias a utilizar para la implementacion del proyecto
 **/

import javafx.application.Platform;
import org.json.JSONObject;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.*;
import static game.Main.*;

/**
 * Creacion de la clase Cliente
 * @author Gabriel Gonzalez
 * Se crea el main de la clase para poder correrlo
 * Se instancia el MarcoCliente y se llama a este
 */
public class Cliente {

	static MarcoCliente1 mimarco1;

	public static void main(String[] args) {

		mimarco1 = new MarcoCliente1();

		mimarco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	/**
	 *
	 * @param json
	 * se crea el metodo setJSON, en el cual se crea el json que sera pasado de el cliente al servidor
	 *
	 **/
	public void setJSON(JSONObject json){
		mimarco1.setJSON(json);
	}

}

/**
 * @author Gabriel Gonzalez
 * Se crea la clase MarcoCliente, el cual es un JFrame que contendra la lamina para escribir los json
 *
 **/
class MarcoCliente1 extends JFrame {

	LaminaMarcoCliente1 milamina1;

	public MarcoCliente1() {

		setBounds(600, 300, 280, 350);

		milamina1 = new LaminaMarcoCliente1();

		add(milamina1);

		setVisible(true);

	}
	/**
	 * Metodo setJSON  de la lamina que crea el JSON que sera pasado como mensaje
	 **/
	public void setJSON(JSONObject json){
		milamina1.setJSON(json);
	}

}

/**
 * @author Gabriel Gonzalez
 * se crea la lamina implementando Runnable
 * Se define el json
 * Se da la utilizacion de todos los elementos de la interfaz principal del cliente
 * Tambien se obtienen los nombres de usuario y el ip mediante sus respectivos gets
 * Se crea el hilo que permitira que la comunicacion entre cliente y servidor se haga las veces que sea necesario
 **/
class LaminaMarcoCliente1 extends JPanel implements Runnable {

	JSONObject json;

	public LaminaMarcoCliente1() {

		JLabel n_nick = new JLabel("   Player:");

		n_nick.setLocation(50, 50);;

		add(n_nick);

		nick1 = new JLabel();

		nick1.setText(getUserText());

		add(nick1);

		JLabel i_ip = new JLabel("   IP:");

		add(i_ip);

		ip1 = new JLabel();

		ip1.setText(getIPText());

		ip1.setLocation(200, 20);

		add(ip1);

		campochat1 = new JTextArea(12, 20);

		add(campochat1);

		miboton = new JButton("Finalizar Turno");

		EnviaTexto1 mievento1 = new EnviaTexto1();

		miboton.addActionListener(mievento1);

		add(miboton);

		Thread mihilo1 = new Thread(this);

		mihilo1.start();



	}
	/**
	 *
	 * @param json
	 * se crea el metodo setJSON, en el cual se crea el json que sera pasado de el cliente al servidor
	 *
	 **/
	public void setJSON(JSONObject json){
		this.json = json;
	}

	/**
	 * Se crea la clase envia texto implementando ActionListener
	 * Esta clase ayuda a que el boton cumpla su funcion de realizar la comunicacion
	 * Se define datos1 como un paquete de envio que debera ser entregado al servidor
	 * Mediante getters y setters se acceden a las variables posteriormente definidas
	 * Se convierte el JSON a string para mandarlo al servidor
	 * Se crea el flujo de salida de datos mediante el ObjectOutputStream
	 * Se escribe el paquete de datos enviado y se cierra la conexion del paquete de datos
	 */
	private class EnviaTexto1 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				Socket misocket1 = new Socket("172.20.10.4", 9999);

				PaqueteEnvio datos1 = new PaqueteEnvio();

				datos1.setNick(getUserText());

				datos1.setIp(getIPText());

				datos1.setMensaje(json.toString());

				// Flujo de salida

				ObjectOutputStream paquete_datos1 = new ObjectOutputStream(misocket1.getOutputStream());

				// Flujo esrcibe los datos

				paquete_datos1.writeObject(datos1);

				paquete_datos1.close();

			} catch (IOException e1) {
				e1.printStackTrace();
			}

		}

	}

	/**
	 * se definen las variables de la interfaz utlizadas en la clase LaminaMarcoCliente
	 **/

	private JTextField campo;

	private JLabel nick1, ip1;

	private JTextArea campochat1;

	private JButton miboton;

	/**
	 * se crea el metodo run
	 * Cunado este sea llamado, se creara un socket que recibira los datos del servidor
	 * Se define un paquete de datos recibido
	 * Mientras el try sea verdadero, se aceptara la conexion con el servidor
	 * se creara el flujo de datos recibidos mediante el ObjectInputStream
	 * El Platform.runLater permite actualizar la interfaz por fuera del main y permite que se actualice la malla
	 **/
	@Override
	public void run() {

		try {

			ServerSocket servidorCliente1 = new ServerSocket(9002);

			Socket cliente1;

			PaqueteEnvio Recibido1;

			while (true) {

				cliente1 = servidorCliente1.accept();

				ObjectInputStream entrada1 = new ObjectInputStream(cliente1.getInputStream());

				Recibido1 = (PaqueteEnvio) entrada1.readObject();

				campochat1.append("\n" + Recibido1.getNick() + ": " + Recibido1.getMensaje());

				System.out.println(Recibido1.getMensaje());

				PaqueteEnvio finalRecibido = Recibido1;

				//PaqueteEnvio finalRecibido1 = Recibido1;

				Platform.runLater(
						() -> {
							setTextPlayer2(finalRecibido.getNick());
							getFromJSON(finalRecibido.getMensaje(),2);
						}
				);



				System.out.println(Recibido1.getMensaje());

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}

/**
 * @author Gabriel Gonzalez
 * Se crea la clase paquete envio
 * Se definen las variables a utliziran privadaspara no permitir su acceso directo
 * Se accede a estas mediante los getters y setters respectivos
 **/
class PaqueteEnvio implements Serializable {

	private String nick1, ip1, mensaje1;

	public String getNick() {
		return nick1;
	}

	public void setNick(String nick1) {
		this.nick1 = nick1;
	}

	public String getIp() {
		return ip1;
	}

	public void setIp(String ip1) {
		this.ip1 = ip1;
	}

	public String getMensaje() {
		return mensaje1;
	}

	public void setMensaje(String mensaje1) {
		this.mensaje1 = mensaje1;
	}

}
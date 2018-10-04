package server;

/**
 * Se importan las librerias necasarias para la implementacion
 **/

import javax.swing.*;

import org.json.JSONException;
import org.json.JSONObject;

import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Gabriel Gonzalez
 * Se crea la clase Servidor con su respectivo main
 **/
public class Servidor {

	public static void main(String[] args) {

		MarcoServidor1 mimarco1 = new MarcoServidor1();

		mimarco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}

/**
 * @author gabriel Gonzalez
 * se crea la clase MarcoServidor que implementa Runnable para correrlo
 * El marcoServidor es un Jfram con los elementos necesarios para la intefaz del servidor
 * Se crea el hilo para correrlo las veces que sea necesario
 **/
class MarcoServidor1 extends JFrame implements Runnable {

	public MarcoServidor1(){

		setBounds(1200, 300, 280, 350);

		JPanel milamina1 = new JPanel();

		milamina1.setLayout(new BorderLayout());

		areatexto1 = new JTextArea();

		milamina1.add(areatexto1, BorderLayout.CENTER);

		add(milamina1);

		setVisible(true);

		Thread hilo1 = new Thread(this);

		hilo1.start();

	}

	/**
	 * Se define el JTextArea donde se agregaran los mensajes del ciente
	 * Se crea el metodo run, el cual cada vez que se corra crea un socket con el puerto 9999
	 * Mientras el try sea verdadero, se aceptara la conexion del socket del cliente
	 * se creara un flujo de entrada de datos para recibir por parte del cliente
	 * Se creara de nuevo el JSONObject recibido y se agregaran los datos al area de texto
	 * Luego se creara un socket nuevo para enviar los datos recibidos al otro cliente conectado
	 * se abrira un puerto de salida con ObjectOutputStream y se escribiran los datos.
	 * Por utimo se cerrara la conexion de los sockets para no permitir la comunicacion
	 **/


	private JTextArea areatexto1;

	@Override
	public void run(){

		try {
			ServerSocket servidor1 = new ServerSocket(9999);

			String nick1, ip1, mensaje1;

			PaqueteEnvio recibido1;

			while (true) {

				Socket misocket1 = servidor1.accept();

				ObjectInputStream paquete_datos1 = new ObjectInputStream(misocket1.getInputStream());

				recibido1 = (PaqueteEnvio) paquete_datos1.readObject();

				nick1 = recibido1.getNick();
				ip1 = recibido1.getIp();
				mensaje1 = recibido1.getMensaje();

				JSONObject json = new JSONObject();

				json.put("action", recibido1.getMensaje());

				areatexto1.append("\n" + nick1 + ": " + json+ " para " + ip1);

				Socket Destinatario1 = new Socket(ip1, 9002);

				ObjectOutputStream Reenvio1 = new ObjectOutputStream(Destinatario1.getOutputStream());

				Reenvio1.writeObject(recibido1);

				Reenvio1.close();

				Destinatario1.close();

				misocket1.close();

			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}


	}
}
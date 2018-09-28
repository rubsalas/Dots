package server;

import colas.Cola;

import javax.swing.*;

import java.awt.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Servidor{

	Cola colaJugadores = new Cola();


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MarcoServidor mimarco = new MarcoServidor();

		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}

class MarcoServidor extends JFrame implements Runnable {

	public MarcoServidor() {

		setBounds(1200, 300, 280, 350);

		JPanel milamina = new JPanel();

		milamina.setLayout(new BorderLayout());

		areatexto = new JTextArea();

		milamina.add(areatexto, BorderLayout.CENTER);

		add(milamina);

		setVisible(true);

		Thread hilo = new Thread(this);

		hilo.start();

	}

	private JTextArea areatexto;

	@Override
	public void run() {

		try {
			ServerSocket servidor = new ServerSocket(9999);

			String nick, ip, mensaje;

			PaqueteEnvio recibido;

			while (true) {

				Socket misocket = servidor.accept();

				ObjectInputStream paquete_datos = new ObjectInputStream(misocket.getInputStream());

				recibido = (PaqueteEnvio) paquete_datos.readObject();

				nick = recibido.getNick();
				ip = recibido.getIp();
				mensaje = recibido.getMensaje();

				/*
				 * DataInputStream entrada = new
				 * DataInputStream(misocket.getInputStream()); String mensaje =
				 * entrada.readUTF();
				 *
				 * areatexto.append("\n" + mensaje);
				 */

				areatexto.append("\n" + nick + ": " + mensaje + " para " + ip);

				// Socket para enviar a destinatario
				Socket Destinatario = new Socket(ip, 9002);

				ObjectOutputStream Reenvio = new ObjectOutputStream(Destinatario.getOutputStream());

				Reenvio.writeObject(recibido);

				Reenvio.close();

				Destinatario.close();

				misocket.close();

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// System.out.println("Hola");
	}
}
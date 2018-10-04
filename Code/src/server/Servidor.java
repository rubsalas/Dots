package server;
//*
import javax.swing.*;

import org.json.JSONException;
import org.json.JSONObject;

import java.awt.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;




public class Servidor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MarcoServidor1 mimarco1 = new MarcoServidor1();

		mimarco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}

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

				/*
				 * DataInputStream entrada = new
				 * DataInputStream(misocket.getInputStream()); String mensaje =
				 * entrada.readUTF();
				 *
				 * areatexto.append("\n" + mensaje);
				 */

				areatexto1.append("\n" + nick1 + ": " + json+ " para " + ip1);

				// Socket para enviar a destinatario
				Socket Destinatario1 = new Socket(ip1, 9002);

				ObjectOutputStream Reenvio1 = new ObjectOutputStream(Destinatario1.getOutputStream());

				Reenvio1.writeObject(recibido1);

				Reenvio1.close();

				Destinatario1.close();

				misocket1.close();

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// System.out.println("Hola");
	}
}
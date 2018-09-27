package progra;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.*;

import org.json.JSONException;
import org.json.JSONObject;

public class Cliente1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MarcoCliente mimarco = new MarcoCliente();

		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoCliente extends JFrame {

	public MarcoCliente() {

		setBounds(600, 300, 280, 350);

		LaminaMarcoCliente milamina = new LaminaMarcoCliente();

		add(milamina);

		setVisible(true);

	}

}

class LaminaMarcoCliente extends JPanel implements Runnable {

	public LaminaMarcoCliente() {

		nick = new JTextField(5);

		add(nick);

		JLabel texto = new JLabel("CHAT");

		add(texto);

		ip = new JTextField(8);

		add(ip);

		campochat = new JTextArea(12, 20);

		add(campochat);

		campo1 = new JTextField(20);

		add(campo1);

		miboton = new JButton("Enviar");

		EnviaTexto mievento = new EnviaTexto();

		miboton.addActionListener(mievento);

		add(miboton);

		Thread mihilo = new Thread(this);

		mihilo.start();

	}

	private class EnviaTexto implements ActionListener {

		JSONObject json = new JSONObject();
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {

				Socket misocket = new Socket("172.19.13.186", 9999);

				PaqueteEnvio datos = new PaqueteEnvio();

				datos.setNick(nick.getText());

				datos.setIp(ip.getText());
				
				JSONObject json = new JSONObject();
				
				json.put("action", campo1.getText());

				datos.setMensaje(campo1.getText());
				
			

				// Flujo de salida

				ObjectOutputStream paquete_datos = new ObjectOutputStream(misocket.getOutputStream());

				// Flujo esrcibe los datos
				paquete_datos.writeObject(datos);

				/*
				 * DataOutputStream salida = new
				 * DataOutputStream(misocket.getOutputStream());
				 * salida.writeUTF(campo1.getText());;
				 *
				 * salida.close();
				 */

				paquete_datos.close();

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

	}

	private JTextField campo1, nick, ip;

	private JTextArea campochat;

	private JButton miboton;

	@Override
	public void run() {

		try {

			ServerSocket servidorCliente = new ServerSocket(9002);

			Socket cliente;

			PaqueteEnvio Recibido;

			while (true) {

				cliente = servidorCliente.accept();

				ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());

				Recibido = (PaqueteEnvio) entrada.readObject();

				campochat.append("\n" + Recibido.getNick() + ": " + Recibido.getMensaje());

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}

class PaqueteEnvio implements Serializable {

	private String nick, ip, mensaje;

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
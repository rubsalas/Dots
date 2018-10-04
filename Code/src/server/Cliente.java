package server;

import org.json.JSONObject;

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
import static game.Main.*;

public class Cliente {

	static MarcoCliente1 mimarco1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		mimarco1 = new MarcoCliente1();

		mimarco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void setJSON(JSONObject json){
		mimarco1.setJSON(json);
	}

}

class MarcoCliente1 extends JFrame {

	LaminaMarcoCliente1 milamina1;

	public MarcoCliente1() {

		setBounds(600, 300, 280, 350);

		milamina1 = new LaminaMarcoCliente1();

		add(milamina1);

		setVisible(true);

	}

	public void setJSON(JSONObject json){
		milamina1.setJSON(json);
	}


}

class LaminaMarcoCliente1 extends JPanel implements Runnable {

	JSONObject json;

	public LaminaMarcoCliente1() {
		
		JLabel n_nick = new JLabel("   Nickname:");
		
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

		campo = new JTextField(20);

		add(campo);

		miboton = new JButton("Enviar");

		EnviaTexto1 mievento1 = new EnviaTexto1();

		miboton.addActionListener(mievento1);

		add(miboton);

		Thread mihilo1 = new Thread(this);

		mihilo1.start();



	}

	public void setJSON(JSONObject json){
		this.json = json;
	}

	private class EnviaTexto1 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				Socket misocket1 = new Socket("192.168.56.1", 9999);

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
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

	}

	private JTextField campo;
	
	private JLabel nick1, ip1;

	private JTextArea campochat1;

	private JButton miboton;

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

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}

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
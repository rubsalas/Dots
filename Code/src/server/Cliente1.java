package server;

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

public class Cliente1 {
	



		public static void main(String[] args) {
			// TODO Auto-generated method stub

			MarcoCliente1 mimarco1 = new MarcoCliente1();

			mimarco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		}

	}

	class MarcoCliente1 extends JFrame {

		public MarcoCliente1() {

			setBounds(600, 300, 280, 350);

			LaminaMarcoCliente1 milamina1 = new LaminaMarcoCliente1();

			add(milamina1);

			setVisible(true);

		}

	}

	class LaminaMarcoCliente1 extends JPanel implements Runnable {

		public LaminaMarcoCliente1() {

			nick1 = new JTextField(5);

			add(nick1);

			JLabel texto1 = new JLabel("CHAT");

			add(texto1);

			ip1 = new JTextField(8);

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

		private class EnviaTexto1 implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					Socket misocket1 = new Socket("192.168.0.20", 9999);

					PaqueteEnvio datos1 = new PaqueteEnvio();

					datos1.setNick(nick1.getText());

					datos1.setIp(ip1.getText());

					datos1.setMensaje(campo.getText());

					// Flujo de salida

					ObjectOutputStream paquete_datos1 = new ObjectOutputStream(misocket1.getOutputStream());

					// Flujo esrcibe los datos
					
					paquete_datos1.writeObject(datos1);

					/*
					 * DataOutputStream salida1 = new
					 * DataOutputStream(misocket1.getOutputStream());
					 * salida.writeUTF(campo.getText());;
					 * 
					 * salida1.close();
					 */

					paquete_datos1.close();

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		}

		private JTextField campo, nick1, ip1;

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

	// 192.168.0.20
	// Video 192



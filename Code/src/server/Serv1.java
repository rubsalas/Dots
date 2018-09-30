package server;

import java.awt.BorderLayout;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.json.JSONObject;

import server.LaminaMarcoCliente.PaqueteEnvio;



public class Serv1 {
	

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
		// TODO Auto-generated method stub
		
		try {
			ServerSocket servidor = new ServerSocket(9999);
			
			String nick, ip;
			
			JSONObject json;
			
			PaqueteEnvio recibido;
			
			while(true){
				
				Socket misocket = servidor.accept();
				
				ObjectInputStream paquete_datos = new ObjectInputStream(misocket.getInputStream());
				
				recibido = (PaqueteEnvio) paquete_datos.readObject();
				
				JSONObject json1 = new JSONObject(recibido);
				
				nick = recibido.getNick();
				ip = recibido.getIp();
				json = recibido.getJson();
				
				areatexto.append("\n" + nick + ": " + json + " para " + ip);
				
				
				Socket destinatario = new Socket(ip,9002);
				
				ObjectOutputStream Reenvio = new ObjectOutputStream(destinatario.getOutputStream());
					
				Reenvio.writeObject(recibido);
				
				destinatario.close();
				
				misocket.close();
			}
		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

package server;

import java.awt.BorderLayout;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.IOException.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import server.LaminaMarcoCliente.PaqueteEnvio;

public class Serv1{
	
	public static void main(String[] args){
		
		MarcoServidor mimarco = new MarcoServidor();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}



class MarcoServidor extends JFrame implements Runnable{
	public MarcoServidor(){
		
		setBounds(1200,300,280,350);
		
		JPanel milamina = new JPanel();
		
		milamina.setLayout(new BorderLayout());
		
		areatexto = new JTextArea();
		
		milamina.add(areatexto,BorderLayout.CENTER);
		
		add(milamina);
		
		setVisible(true);
		
		Thread hilo = new Thread(this);
		
		hilo.start();
		
		}
	
	private JTextArea areatexto;

	@Override
	public void run() {
		
		//System.out.println("Sirve");
		
		try {
			
				final String HOST = "localhost";
		
				ServerSocket servidor = new ServerSocket(9900);
				
				String nickname, IP, mensaje;
				
				PaqueteEnvio paquete_recibido;
				
				
				while(true){
			
				Socket misocket = servidor.accept();
				
				ObjectInputStream paquete_datos = new ObjectInputStream(misocket.getInputStream());
				
				paquete_recibido = (PaqueteEnvio) paquete_datos.readObject();
			
				nickname = paquete_recibido.getNickname();
				
				IP = paquete_recibido.getIp();
				
				mensaje = paquete_recibido.getMensaje();
				
				
				//DataInputStream flujo_entrada = new DataInputStream(misocket.getInputStream());
				areatexto.append("\n" + nickname + ": " + mensaje + " para" );
				
				Socket enviaDestinatario = new Socket(IP, 9090);
				
				ObjectOutputStream paqueteReenvio = new ObjectOutputStream(enviaDestinatario.getOutputStream());
				
				paqueteReenvio.writeObject(paquete_recibido);
				
				paqueteReenvio.close();
				
				enviaDestinatario.close();
				
				misocket.close();
			
				//String mensaje_texto = flujo_entrada.readUTF();
			
				//areatexto.append("\n" + mensaje_texto);
			
				
			
			}
			
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}


//Curso Java. Sockets II. Vídeo 191

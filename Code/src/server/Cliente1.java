package server;

//192.168.0.20


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Cliente1 {
	
	public static void main(String[] args){
	
	MarcoCliente mimarco= new MarcoCliente();
	mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}

}

class MarcoCliente extends JFrame{
	
	public MarcoCliente(){
		
		setBounds(600,300,280,350);
		
		LaminaMarcoCliente milamina = new LaminaMarcoCliente();
		
		add(milamina);
		
		setVisible(true);
	}
}
 
class LaminaMarcoCliente extends JPanel implements Runnable{
	
	public LaminaMarcoCliente(){
		
		nickname = new JTextField(5);
		
		add(nickname);
		
		JLabel texto = new JLabel("CHAT");
		
		add(texto);
		
		IP = new JTextField(8);
		
		add(IP);
		
		campochat = new JTextArea(12,20);
		
		add(campochat);
		
		campo1 = new JTextField(20);
		
		add(campo1);
		
		miboton = new JButton("Enviar");
		
		EnviarTexto mievento = new EnviarTexto();
		miboton.addActionListener(mievento);
		
		add(miboton);
		
		Thread hilo = new Thread(this);
		
		hilo.start();
	}
	

	
	
	private class EnviarTexto implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			//System.out.println(campo1.getText());
			
			campochat.append("\n" + campo1.getText());
			
			try {
				String ip = null;
				Socket misocket = new Socket(ip,9900);
				
				PaqueteEnvio datos = new PaqueteEnvio();
				
				datos.setNickname(nickname.getText());
				
				datos.setIp(IP.getText());
				
				datos.setMensaje(campo1.getText());
				
				ObjectOutputStream paquete_datos = new ObjectOutputStream(misocket.getOutputStream());
				
				paquete_datos.writeObject(datos);
			
				misocket.close();
				
				
				//DataOutputStream flujo_salida = new DataOutputStream(misocket.getOutputStream());
				
				//flujo_salida.writeUTF(campo1.getText());
				
				//flujo_salida.close();
				
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		
		
		
	}
	
	
	private JTextField campo1, nickname, IP;
	
	private JTextArea campochat;
	
	private JButton miboton;
	
class PaqueteEnvio implements Serializable{
	
	private String nickname, ip, mensaje;

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
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

@Override
public void run() {
	
	try{
		
		ServerSocket servidor_cliente = new ServerSocket(9090);
		
		Socket cliente;
		PaqueteEnvio paqueteRecibido;
		
		while (true){
			cliente = servidor_cliente.accept();
			
			ObjectInputStream flujo_entrada = new ObjectInputStream(cliente.getInputStream());
			
			paqueteRecibido = (PaqueteEnvio) flujo_entrada.readObject();
			
			campochat.append("\n" + paqueteRecibido.getNickname()+ ": " + paqueteRecibido.getMensaje());
			
			
			
		}
		
	}catch(Exception e){
		
		System.out.println(e.getMessage());
	}
	
}
	
}

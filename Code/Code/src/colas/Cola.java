package colas;

public class Cola {
	
	private NodoCola inicio;
	private NodoCola fin;
	private int size;
	
	
	public Cola(){
		inicio = null;
		fin = null;
		size = 0;
	}
	
	public boolean isEmpty(){
		if (inicio == null){
			return true;
		}else{
			
			return false;
		}
	}

	public void insertar(Jugador jugador){
		
		NodoCola actual;

		if(isEmpty()){
			actual = new NodoCola(jugador,null);
			inicio = actual;
			fin = actual;

		}else{
			actual = new NodoCola(jugador,null);
			fin.setNext(actual);
			fin = actual;
			size++;
		}
		
		
	}
	

	

}

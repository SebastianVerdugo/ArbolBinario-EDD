package ArbolBinario;

public class Nodo {
	private Nodo izquierdo, derecho;
	private int dato;

	public Nodo(int dato)
	{
		this.dato=dato;
		izquierdo=derecho=null;
	}
	public Nodo()
	{
		this(0);
	}
	public Nodo getIzquierdo() {
		return izquierdo;
	}
	public void setIzquierdo(Nodo izquierdo) {
		this.izquierdo = izquierdo;
	}
	public Nodo getDerecho() {
		return derecho;
	}
	public void setDerecho(Nodo derecho) {
		this.derecho = derecho;
	}
	public int getDato() {
		return dato;
	}
	public void setDato(int dato) {
		this.dato = dato;
	}
	
	


}

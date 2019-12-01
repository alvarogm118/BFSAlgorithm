package es.upm.dit.adsw.ej2;
/**
 * @author Alvaro Gomez Martinez 
 *
 */

public class Node extends java.lang.Object {
	
	private java.lang.String name;
	private int x;
	private int y;
	private boolean visited;
	private Node papu;
	
	public Node(java.lang.String name, int x,int y) throws java.lang.IllegalArgumentException {
		
		if (name == null) throw new java.lang.IllegalArgumentException("Nombre nulo"); // Si el nombre es nulo o vacio.
		
		this.name = name; // Nombre del nodo
		this.x = x; // Coordenada x
		this.y = y; // Coordenada y (orientacion negativa)
		this.visited = false;
		this.papu = null;
	}
	
	@Override
	public java.lang.String toString() {
		return "Node [name=" + name + ", x=" + x + ", y=" + y + "]";
	}
	
	public java.lang.String getName() {
		return this.name;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public boolean getvisited() {
		return this.visited;
	}
	
	public void setvisited(boolean b) {
		this.visited = b;
	
	}
	
	public Node getpapu() {
		return this.papu;
	}
	
	public void setpapu(Node nd) {
		this.papu = nd;
	}
}


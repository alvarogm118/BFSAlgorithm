package es.upm.dit.adsw.ej2;
/**
 * @author Alvaro Gomez Martinez 
 *
 */

public class Link extends java.lang.Object {
	
	private java.lang.String src;
	private java.lang.String dst;
	private int weight;
	
	public Link(java.lang.String src, java.lang.String dst, int weight) throws java.lang.IllegalArgumentException {
		
		if (src == null || dst == null || weight < 0) throw new java.lang.IllegalArgumentException("Parametros invalidos");
		
		this.src = src; // Nodo de origen
		this.dst = dst; // Nodo de llegada
		this.weight = weight; // Nombre (Numero) del camino
	}

	@Override
	public java.lang.String toString() {
		return "Link [src=" + src + ", dst=" + dst + ", weight=" + weight + "]";
	}
	
	public java.lang.String getSrc() {
		return this.src;
	}
	
	public java.lang.String getDst() {
		return this.dst;
	}
	
	public int getWeight() {
		return this.weight;
	}

}

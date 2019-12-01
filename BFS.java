package es.upm.dit.adsw.ej2;
/**
 * @author Alvaro Gomez Martinez 
 *
 */

import java.util.ArrayList;
import java.util.List;

import java.util.LinkedList;
import java.util.Queue;


public class BFS extends java.lang.Object {
	
	private Graph graph;
	
	public BFS(Graph graph) {
		this.graph = graph;
	}
	
	public java.util.List<Node> nodosAdyacentes(Node n) {
		List<Link> enlacescont = new ArrayList<Link>() ;
		List<Node> nodosady = new ArrayList<Node>() ;
		enlacescont = graph.getLinks(n);

		for (int i=0; i< enlacescont.size(); i++){
			java.lang.String strn = enlacescont.get(i).getDst();

			nodosady.add(graph.getNode(strn));
		}

		return nodosady;
	}	

	public java.util.List<Node> search(Node src, Node dst) {

		Queue<Node> cola = new LinkedList<Node>(); // Creamos una cola y dos listas de nodos auxiliares.
		List<Node> listaux = new ArrayList<Node>();
		List<Node> listdef = new ArrayList<Node>();

		Node n = null; // La n es el nodo que comprobamos.
		boolean a = true; // condiciones para para bucles.
		boolean b = true;

		cola.add(src); // Establecemos src como visitado, sin padre y lo metemos en la cola.
		src.setvisited(true); 
		src.setpapu(null);

		while (!cola.isEmpty() && b == true) { // El while para cuando la cola está vacia o cuando se llega al destino, b = false.

			Node element = cola.remove(); //Es el elemento de la cola, que se usa para saber sus nodosAdyacentes y para decir que es el padre de los que salgan de ese metodo
			List<Node> nodos = nodosAdyacentes(element);

			for (int i = 0; i < nodos.size(); i++) { 
				n = nodos.get(i); // Aqui, ya igualamos n a todos los adyacentes de element. 

				if (n==dst){ // Si n es el destino, decimos que está visitado, que el padre es element y que pare el bucle while, ya que hemos llegado al destino.
					n.setvisited(true);
					n.setpapu(element);
					b = false;
					break;
				}


				if (n!=null && n.getvisited()==false) // Como no es el destino, lo ponemos como visitado y su padre (element) y lo añadimos a la cola, para estudiar sus adyacentes
				{
					n.setvisited(true);
					n.setpapu(element);
					cola.add(n);
				}
			}
		}
		
		if (n != dst) return listdef; // Si hemos recorrido todo y el nodo final, n, no es el destino, devolvemos la lista vacia. Es para asegurarnos de que llegamos a dst.
		
		while (a == true) {
			if (n.getpapu()==src) { //Si el padre de n, el destino, es el origen, pues es facil, metemos los 2 en la listaux que luego se invierte (listadef) y se devuelve.
				listaux.add(n);
				listaux.add(src);
				a = false;
			}
			else if (n.getpapu()!=src){ //Si no es el origen, añade n a la lista auxilar y ahora n es el padre del que teniamos, Esto sirve para llegar al nodo anterior de src.
				listaux.add(n);
				n=n.getpapu();
			}

			else {
				listdef.add(src); //Eso es porque el origen y destino es src, por lo que devolvemos la lista solo con él.
				a = false;
				return listdef;
			}
		}

		for (int j = listaux.size()-1; j > -1 ; j--) { // Aqui invertimos la lista aux, ya que se recorre lo del padre al reves(desde n=dst hasta el de antes de src) 

			listdef.add(listaux.get(j)); 
		}

		return listdef; // devolvemos listdef, que es el camino que se coge para ir desde src a dst, en orden.
	}



}

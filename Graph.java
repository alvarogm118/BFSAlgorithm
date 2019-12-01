package es.upm.dit.adsw.ej2;
/**
 * @author Alvaro Gomez Martinez 
 *
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;





public class Graph extends java.lang.Object {

	private List<Node> nodos;
	private List<Link> enlaces;
	private Map<String, Node> nodeMap;
	private Map<Node, List<Link>> linkMap;

	public Graph() {

		this.nodos = new ArrayList<Node>();
		this.enlaces = new ArrayList<Link>();
		this.nodeMap = new HashMap<String, Node>();
		this.linkMap = new HashMap<Node, List<Link>>();

	}

	public void addNode(Node node) {
		this.nodos.add(node);
		this.nodeMap.put(node.getName(),node);
	}

	public void addLink(Link link) {
		this.enlaces.add(link);	
		List<Link> list = new ArrayList<Link>();
		Node nodo = getNode(link.getSrc());

		if (linkMap.containsKey(nodo) == false){
			list.add(link);
			this.linkMap.put(nodo,list);
		}

		list = linkMap.get(nodo);
		linkMap.remove(nodo);
		list.add(link);
		this.linkMap.put(nodo,list);
	}

	public void addLink2D(java.lang.String a, java.lang.String b, int w) {
		addLink(new Link(a, b, w));
		addLink(new Link(b, a, w));

	}

	public java.util.List<Node> getNodes() {
		return this.nodos;
	}

	public Node getNode(java.lang.String name) {

		if (nodeMap.containsKey(name) == true)
			return nodeMap.get(name);
		return null;
	}

	public java.util.List<Link> getLinks() {
		return this.enlaces;
	}

	public java.util.List<Link> getLinks(Node node) {
		
		List<Link> listaLinks = new ArrayList<Link>() ;
		if (linkMap.containsKey(node) == true)
			listaLinks = linkMap.get(node);
		return listaLinks ;
	}


	public Link getLink(Node src, Node dst) {

		for (int i=0; i< enlaces.size(); i++){
			Link aux = this.enlaces.get(i);
			if (aux.getSrc() == src.getName() && aux.getDst() == dst.getName())
				return aux;
		}
		return null;
	}

	public int getWeight(java.util.List<Node> path) { // Se tendria que especificar lo que se quiere.

		ArrayList<Link> EnlacesPath = new ArrayList<Link>() ;
		int Peso = 0;

		for (int i=0; i< path.size()-1; i++){

			Link enl = getLink(path.get(i),path.get(i+1));
			if (enl == null) {
				return -1;
			}
			else {
				EnlacesPath.add(enl);
			}

		}
		for (int j=0; j< EnlacesPath.size(); j++){

			Peso += EnlacesPath.get(j).getWeight();

		}

		return Peso;

	}

}

package es.upm.dit.adsw.ej2;
/**
 * @author Alvaro Gomez Martinez 
 *
 */
public class BFSMeter {




	public static void load(Graph graph, int n){

		for (int j=0; j< n; j++){
			Node nodo = new Node(String.valueOf(j),0,j);
			graph.addNode(nodo);
		}	
		// Pongo 6 enlaces por nodo y de peso 5
		for (int i=0; i< n; i++){	
			graph.addLink(new Link(String.valueOf(i), String.valueOf((int)(Math.random() * n)) ,5));
			graph.addLink(new Link(String.valueOf(i), String.valueOf((int)(Math.random() * n)) ,5));
			graph.addLink(new Link(String.valueOf(i), String.valueOf((int)(Math.random() * n)) ,5));
			graph.addLink(new Link(String.valueOf(i), String.valueOf((int)(Math.random() * n)) ,5));
			graph.addLink(new Link(String.valueOf(i), String.valueOf((int)(Math.random() * n)) ,5));
			graph.addLink(new Link(String.valueOf(i), String.valueOf((int)(Math.random() * n)) ,5));


		}
	}



	private static long doit(Graph graph) {
		BFS bfs = new BFS(graph);
		long t0 = System.currentTimeMillis();

		bfs.search(graph.getNode("536"), graph.getNode("998"));
		bfs.search(graph.getNode("608"), graph.getNode("710"));
		bfs.search(graph.getNode("0"), graph.getNode("189"));
		bfs.search(graph.getNode("11"), graph.getNode("348"));
		bfs.search(graph.getNode("250"), graph.getNode("846"));
		bfs.search(graph.getNode("200"), graph.getNode("788"));
		bfs.search(graph.getNode("100"), graph.getNode("400"));
		bfs.search(graph.getNode("15"), graph.getNode("789"));
		bfs.search(graph.getNode("411"), graph.getNode("648"));
		bfs.search(graph.getNode("550"), graph.getNode("847"));		
		bfs.search(graph.getNode("230"), graph.getNode("720"));
		bfs.search(graph.getNode("7"), graph.getNode("299"));
		bfs.search(graph.getNode("36"), graph.getNode("448"));
		bfs.search(graph.getNode("251"), graph.getNode("896"));
		bfs.search(graph.getNode("220"), graph.getNode("888"));
		bfs.search(graph.getNode("150"), graph.getNode("408"));
		bfs.search(graph.getNode("1"), graph.getNode("769"));
		bfs.search(graph.getNode("691"), graph.getNode("990"));
		bfs.search(graph.getNode("150"), graph.getNode("620"));
		bfs.search(graph.getNode("536"), graph.getNode("998"));
		bfs.search(graph.getNode("608"), graph.getNode("710"));
		bfs.search(graph.getNode("0"), graph.getNode("189"));
		bfs.search(graph.getNode("11"), graph.getNode("348"));
		bfs.search(graph.getNode("250"), graph.getNode("846"));
		bfs.search(graph.getNode("200"), graph.getNode("788"));
		bfs.search(graph.getNode("100"), graph.getNode("400"));
		bfs.search(graph.getNode("15"), graph.getNode("789"));
		bfs.search(graph.getNode("411"), graph.getNode("648"));
		bfs.search(graph.getNode("550"), graph.getNode("847"));		
		bfs.search(graph.getNode("230"), graph.getNode("720"));
		bfs.search(graph.getNode("7"), graph.getNode("299"));
		bfs.search(graph.getNode("36"), graph.getNode("448"));
		bfs.search(graph.getNode("251"), graph.getNode("896"));
		bfs.search(graph.getNode("220"), graph.getNode("888"));
		bfs.search(graph.getNode("150"), graph.getNode("408"));
		bfs.search(graph.getNode("1"), graph.getNode("769"));
		bfs.search(graph.getNode("691"), graph.getNode("990"));
		bfs.search(graph.getNode("150"), graph.getNode("620"));
		

		long t2 = System.currentTimeMillis();

		return t2 - t0;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int n=1000; n< 100000; n+=5000){
			Graph graph = new Graph();
			load(graph,n);
			long t = doit(graph);
			System.out.printf("%s %d%n",n,t);
		}
	}

}

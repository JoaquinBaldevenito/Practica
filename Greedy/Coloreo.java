import java.util.ArrayList;


public class Coloreo {

    public static ArrayList<ArrayList<Integer>> coloreoGrafo(GrafoNoDirigido grafo) {
        ArrayList<Integer> color = new ArrayList<>();
        ArrayList<ArrayList<Integer>> todosColores = new ArrayList<>();
        for (Vertice k : grafo.vertices()) {
            
            ArrayList<Integer> newColor = new ArrayList<>();

            for (Vertice vertice : grafo.vertices()) {
            
                if (!color.contains(vertice.getId())) {
                    boolean adyacenteAColoreado = false;
                    for (Vertice vecino : vertice.getAdyacentes()) {
                        if(newColor.contains(vecino.getId())){
                            adyacenteAColoreado = true;
                            break;
                        }
                    }
                    if (!adyacenteAColoreado) {
                        color.add(vertice.getId());
                        newColor.add(vertice.getId());
                    }
                }
            }
            todosColores.add(newColor);
        }
       return todosColores;
    } 


    public static void main(String[] args) {
        GrafoNoDirigido grafo = new GrafoNoDirigido();

        grafo.agregarVertice(new Vertice(1));
		grafo.agregarVertice(new Vertice(2));
		grafo.agregarVertice(new Vertice(3));
		grafo.agregarVertice(new Vertice(4));
		grafo.agregarVertice(new Vertice(5));
		grafo.agregarVertice(new Vertice(6));
		grafo.agregarVertice(new Vertice(7));
		grafo.agregarVertice(new Vertice(8));

		grafo.agregarArista(new Vertice(1), new Vertice(5));
		grafo.agregarArista(new Vertice(1), new Vertice(2));
		grafo.agregarArista(new Vertice(1), new Vertice(3));
		grafo.agregarArista(new Vertice(1), new Vertice(4));
		grafo.agregarArista(new Vertice(2), new Vertice(4));
		grafo.agregarArista(new Vertice(3), new Vertice(2));
		grafo.agregarArista(new Vertice(5), new Vertice(7));
		grafo.agregarArista(new Vertice(5), new Vertice(6));
		grafo.agregarArista(new Vertice(7), new Vertice(8));
		grafo.agregarArista(new Vertice(6), new Vertice(7));
		grafo.agregarArista(new Vertice(6), new Vertice(8));
		grafo.agregarArista(new Vertice(2), new Vertice(8));

		System.out.println(grafo.toString());

		ArrayList<ArrayList<Integer>> colores = coloreoGrafo(grafo);
      
        for (int i = 0; i < colores.size(); i++) {
			ArrayList<Integer> color = colores.get(i);
			System.out.println("color" + i + ": ");
			for (int j = 0; j < color.size(); j++) {
				System.out.println(color.get(j));
			}
		}
	}
    
}


package grafodirigido;
import java.util.ArrayList;

public class correlatividades {

    public static boolean  aciclico(Vertice origen,ArrayList<Vertice> visitados){
        visitados.add(origen);
        for (Vertice adyacente : origen.getAdyacentes() ) {
            if (!visitados.contains(adyacente)) {
                aciclico(adyacente, visitados);
            }else{
                if (visitados.contains(adyacente)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void listaMaterias(Vertice origen,ArrayList<Vertice> visitados,ArrayList<Integer> recorrido){
        visitados.add(origen);
        for (Vertice adyacente : origen.getAdyacentes()) {
            if (!visitados.contains(adyacente)) {
                listaMaterias(adyacente, visitados, recorrido);
            }
        }
        recorrido.add(origen.getId());
    }

    public static void main(String[] args) {
        GrafoNoDirigido grafo = new GrafoNoDirigido();

        Vertice v1 = new Vertice(1);
        Vertice v2 = new Vertice(2);
        Vertice v3 = new Vertice(3);
        Vertice v4 = new Vertice(4);
        Vertice v5 = new Vertice(5);
        Vertice v6 = new Vertice(6);
        Vertice v7 = new Vertice(7);
        Vertice v8 = new Vertice(8);

        v1.agregarAdyacente(v2);
        v1.agregarAdyacente(v5);
        v1.agregarAdyacente(v6);

        v2.agregarAdyacente(v7);

        v3.agregarAdyacente(v4);
        v3.agregarAdyacente(v7);

        v4.agregarAdyacente(v8);

        v5.agregarAdyacente(v6);

        v7.agregarAdyacente(v8);

        grafo.agregarVertice(v1);
        grafo.agregarVertice(v2);
        grafo.agregarVertice(v3);
        grafo.agregarVertice(v4);
        grafo.agregarVertice(v5);
        grafo.agregarVertice(v6);
        grafo.agregarVertice(v7);
        grafo.agregarVertice(v8);
        System.out.println(grafo);
        ArrayList<Vertice> visitados = new ArrayList<>();
        boolean ciclos = aciclico(v1,visitados);
        System.out.println(ciclos);

        ArrayList<Vertice> visitados2 = new ArrayList<>();
        ArrayList<Integer> recorrido = new ArrayList<>();
        for (Vertice nodo : grafo.vertices()) {
            if (!visitados2.contains(nodo)) {
                listaMaterias(nodo,visitados2,recorrido);
            }
            
        }
        
        for (Integer id : recorrido) {
            System.out.println(id);
        }
        
    }
}

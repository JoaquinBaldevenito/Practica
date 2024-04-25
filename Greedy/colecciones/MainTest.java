
public class MainTest {
    /**
     * Crea en grafo y prueba las operaciones realizadas
     * @param args argumento de la linea de comandos.
     */
    public static void main(String[] args) {
        // Crear un grafo no dirigido
        GrafoNoDirigido grafo = new GrafoNoDirigido();

        // Agregar vértices
        Vertice v1 = new Vertice(1);
        Vertice v2 = new Vertice(2);
        Vertice v3 = new Vertice(3);
        Vertice v4 = new Vertice(4);

        grafo.agregarVertice(v1);
        grafo.agregarVertice(v2);
        grafo.agregarVertice(v3);
        grafo.agregarVertice(v4);

        // Agregar aristas
        grafo.agregarArista(v1, v2);
        grafo.agregarArista(v2, v3);
        grafo.agregarArista(v3, v4);
        grafo.agregarArista(v4, v1);

        // Mostrar información del grafo
        System.out.println("Vertices en el grafo:");
        for (Vertice vertice : grafo.vertices()) {
            System.out.println(vertice);
        }

        System.out.println("Aristas en el grafo:");
        for (Arista arista : grafo.aristas()) {
            System.out.println(arista);
        }

        System.out.println("Cantidad de vértices: " + grafo.cantidadVertices());
        System.out.println("Cantidad de aristas: " + grafo.cantidadAristas());

        // Verificar si existe una arista
        Vertice v5 = new Vertice(5);
        System.out.println("¿Existe la arista entre v1 y v2? " + grafo.sonArco(v1, v2));
        System.out.println("¿Existe la arista entre v1 y v5? " + grafo.sonArco(v1, v5));

        // Eliminar una arista
        grafo.eliminarArista(v1, v2);
        System.out.println("Aristas en el grafo después de eliminar la arista entre v1 y v2:");
        for (Arista arista : grafo.aristas()) {
            System.out.println(arista);
        }
        // Eliminar un vértice
        grafo.eliminarVertice(v3);
        System.out.println("Vertices en el grafo después de eliminar v3:");
        for (Vertice vertice : grafo.vertices()) {
            System.out.println(vertice);
        }
    }
}

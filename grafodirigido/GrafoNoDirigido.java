package grafodirigido;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;


/**
 * Implementacion de Grafos no dirigidos basadas en listas de adyacencia.
 */
public class GrafoNoDirigido  {
  /**
   * Lista de Vertices de enteros
   */
  private List<Vertice> vertices;
    /**
   * Coleccion de Aristas.
   */
  private Collection<Arista> aristas;

  /**
   * Inicializa Grafo vacio.
   */
  public GrafoNoDirigido() {
    vertices = new ArrayList<>();
    aristas = new ArrayList<>();
  }

  /**
   * Crea un arreglo de Vertices y un arreglo de arista con los parametros pasados.
   * @param vertices Listas de vertices del grafo a construir.
   * @param aristas coleccion de aristas del grafo a construir.
   */
  public GrafoNoDirigido(List<Vertice> vertices, Collection<Arista> aristas) {
    this.vertices = new ArrayList<>(vertices);
    this.aristas = new ArrayList<>(aristas);
  }

  /**{@inheritDoc}*/
  public boolean agregarVertice(Vertice nodo) {
    if (existe(nodo)) {
      return false;
    }
    int i = 0;
    while (i < vertices.size() && vertices.get(i).getId() < nodo.getId()) {
      i++;
    }
    for (Vertice vert : nodo.getAdyacentes()) {
      agregarArista(nodo, vert);
    }
    vertices.add(i, nodo);
    return true;
  }

  /**{@inheritDoc}*/
  public boolean eliminarVertice(Vertice nodo) {
    if (!existe(nodo)) {
      return false;
    }

    for (int i = 0; i< nodo.getAdyacentes().size();i++) {
      eliminarArista(nodo.getAdyacentes().get(i), nodo);
      eliminarArista(nodo, nodo.getAdyacentes().get(i));
    }
    vertices.remove(nodo);
    return true;
  }

  /**{@inheritDoc}*/
  public boolean existe(Vertice nodo) {
    return busquedaDicotomica(nodo.getId(), 0, vertices.size() - 1);
  }
    /**
    * Performs a binary search in a sorted list of elements to determine if the given element exists.
    *
    * @param id  The id to be searched for in the list of vertex.
    * @param begin The start index of the current sublist.
    * @param end   The end index of the current sublist.
    * @return true if the element is found in the list, false otherwise.
    */
    private boolean busquedaDicotomica(int id, int begin, int end) {
      int pivot = begin + ((end - begin) / 2);
      if (begin <= end) {
          if (this.vertices.get(pivot).getId() == id) {
              return true;
          }
          if (this.vertices.get(pivot).getId() > id) {
              return busquedaDicotomica(id, begin, pivot - 1);
          }

          if (this.vertices.get(pivot).getId() < id) {
              return busquedaDicotomica(id, pivot + 1, end);
          }
      }
      return false;
  }
  /**{@inheritDoc}*/
  public List<Vertice> vertices() {
    return this.vertices;
  }

  /**{@inheritDoc}*/
  public Collection<Arista> aristas() {
    return this.aristas;
  }

  /**{@inheritDoc}*/
  public boolean agregarArista(Vertice vertice1, Vertice vertice2) {
    Arista aux = new Arista(vertice1, vertice2);
    if (aristas.contains(aux)) {
      return false;
    }

    int i = buscarIndice(vertice1, 0, vertices.size() - 1);
    int j = buscarIndice(vertice2, 0, vertices.size() - 1);

    if (i == -1 || j == -1) {
      return false;
    }
    vertices.get(i).agregarAdyacente(vertice2);
    
    aristas.add(aux);
    return true;
  }

  private Integer buscarIndice(Vertice v, int begin, int end) {
    int pivot = begin + ((end - begin) / 2);

    if (begin <= end) {
        if (this.vertices.get(pivot).getId() == v.getId()) {
            return pivot;
        }
        if (this.vertices.get(pivot).getId() > v.getId()) {
            return buscarIndice(v, begin, pivot - 1);
        }

        if (this.vertices.get(pivot).getId() < v.getId()) {
            return buscarIndice(v, pivot + 1, end);
        }

    }
    return -1;
}

  /**{@inheritDoc}*/
  public boolean eliminarArista(Vertice vertice1, Vertice vertice2) {
    Arista aux = new Arista(vertice1, vertice2);
    if (!aristas.contains(aux)) {
      return false;
    }

    int i = buscarIndice(vertice1, 0, vertices.size() - 1);
    int j = buscarIndice(vertice2, 0, vertices.size() - 1);

    vertices.get(i).eliminarAdyacente(vertice2);
    
    aristas.remove(aux);
    return true;
  }


  /**{@inheritDoc}*/
  public List<Vertice> obtenerAdyacentes(Vertice v) {
    if (vertices.indexOf(v) == -1) {
      return new ArrayList<>();
    }
    return new ArrayList<>(v.getAdyacentes());
  }

  /**{@inheritDoc}*/
  public int cantidadVertices() {
    return vertices.size();
  }

   /**{@inheritDoc}*/
  public boolean esVacio() {
    return vertices.size() == 0;
  }

  /**{@inheritDoc}*/
  public int cantidadAristas() {
    return aristas.size();
  }

  /**{@inheritDoc}*/
  public boolean sonArco(Vertice v1, Vertice v2) {
    Arista aux = new Arista(v1, v2);
    return aristas.contains(aux);
  }

  public void markDFS(Vertice nodo,List<Boolean> mark) {
    mark.set(buscarIndice(nodo, 0, vertices().size()-1),true);
    for (Vertice vertex : nodo.getAdyacentes()) {
      int i = buscarIndice(vertex, 0, vertices().size()-1);
      if (mark.get(i) == false) {
        markDFS(vertex, mark);
      }
    }
    
  }
  /**
   * Representacion de Grafo como lista de adyacencia.
   * Los Vertices se reprentan en la primera columna y sus adyacentes en cada fila.
   * @return Representacion de los vertices y arcos del grafo en forma de String.
   */
  @Override
  public String toString() {
    String cad = "";
    for (int i = 0; i < vertices.size(); i++) {
      cad += vertices.get(i).toString() + "\n";
    }
    return cad;
  }

}

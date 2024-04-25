import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;


public class Prims {
    

    public void prims(GrafoNoDirigido g, Vertice v,HashMap<Vertice,Integer> path){

        for (Vertice u : g.vertices()) {
            u.setKey(Integer.MAX_VALUE);
        }

        v.setKey(0);

        PriorityQueue<Vertice> q = new PriorityQueue<Vertice>(Comparator.comparingInt(i -> i.getKey()));

        path.put(v, null);
        
        while (!q.isEmpty()) {
            Vertice u = q.peek();
            q.poll();

            for (Arista x : g.aristas()) {
                if (x.getPrimero() == u && !q.contains(x.getSegundo())) {
                    if (x.getSegundo().getKey() < g.) {
                        
                    }
                }
            }
        }
    }
}

import java.util.HashMap;
import java.util.Map;
import edificios.Tuple;

public class combinatoria {
    

    public static int combDC(int n, int m) {

        if (n<0 || m <0)
        throw new IllegalArgumentException("error");
        if (m > n) return 0;
        if (m == 0 || n == m) return 1;
        return comb((n-1),(m-1)) + comb ((n-1),m);
        
    }

    public static int combPD(int n, int m) {
        int arr[][] = new int[n+1][m+1];
        if (n<0 || m <0)
        throw new IllegalArgumentException("error");
        if (m > n) arr[n][m]=0;
        if (m == 0 || n == m) arr[n][m]= 1;
        else arr[n][m]=combPD(n-1, m-1) + combPD(n-1, m);
        return arr[n][m];
    }

    public static int combMemo(int n, int m,HashMap<Tuple<Integer,Integer>,Integer> cache){
     
      Tuple<Integer,Integer> aux = new Tuple<Integer,Integer>(n, m);
      if (!cache.containsKey(aux)) {
        if (n<0 || m <0) {
            throw new IllegalArgumentException("error");
        }
        else if (m>n) {
            cache.put(aux, 0);
        }
        else if (m == 0 || n == m) {
            cache.put(aux, 1);
        }else {
        cache.put(aux, combMemo(n-1, m-1,cache) + combMemo(n-1, m,cache));
        }
      }
      return cache.get(aux);
    }

    public static int comb(int n, int m){
        HashMap<Tuple<Integer,Integer>,Integer> cache = new HashMap<>();
        return combMemo(n, m,cache);
    }

    public static void main(String[] args) {
        
        System.out.println("La Combinatoria es:"+combinatoria.comb(30, 9));
        
    }
}

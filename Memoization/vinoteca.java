import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class vinoteca {
    

    public static int gananciaMaxima(List<Integer> precios,int start, int end,HashMap<List<Integer>,Integer> cache){
        
        if (cache.containsKey(precios)) {
            return cache.get(precios);
        }

        if (start==end) {
            return precios.get(start)* (end);
        }
        
        int left = precios.get(start)* (end+1) + gananciaMaxima(precios, start+1, end, cache);
        int rigth = precios.get(end) * (end+1) + gananciaMaxima(precios, start, end-1, cache);

        int max = Math.max(left, rigth);
        cache.put(precios, max);
        return cache.get(precios);
    }


    public static void main(String[] args) {

        List<Integer> arr = new ArrayList();
        arr.add(7);
        arr.add(3);
    
        HashMap<List<Integer>,Integer> cache = new HashMap<>();
        int res = vinoteca.gananciaMaxima(arr, 0, arr.size()-1, cache);

        System.out.println("La Ganancia Maxima va a ser:"+res);
    }
}

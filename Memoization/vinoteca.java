import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import edificios.Tuple;

public class vinoteca {
    
    private static HashMap<Tuple<Integer,Integer>,Integer> cache = new HashMap<>();

    public static int gananciaMaxima(int[] precios,int start, int end,int y){
        Tuple<Integer,Integer> aux =new Tuple<Integer,Integer>(start, end);
        if (cache.containsKey(aux)) {
            return cache.get(aux);
        }
        if (start>end) {
            return 0;
        }
        
        int left = (precios[start]*y) + gananciaMaxima(precios, start+1, end,y+1);
        int rigth = (precios[end]*y)+ gananciaMaxima(precios, start, end-1,y+1);

        int max = Math.max(left, rigth);
        cache.put(aux, max);
        return cache.get(aux);
    }


    public static void main(String[] args) {

        int[] arr = {2,4,6,2,5};
        //Valor esperado 64, [2,4,6,2,5]
        HashMap<Tuple<Integer,Integer>,Integer> cache = new HashMap<>();
        int res = vinoteca.gananciaMaxima(arr, 0, arr.length-1,1);

        System.out.println("La Ganancia Maxima va a ser:"+res);
    }
}

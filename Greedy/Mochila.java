import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Mochila {
    
    private static HashMap<Tuple<Integer,Integer>,Integer> prop = new HashMap<Tuple<Integer,Integer>,Integer>();

    public static int mochila(Tuple<Integer,Integer>[] pesoValor,int K){

        Arrays.sort(pesoValor, new Comparator<Tuple<Integer,Integer>>() {
            @Override
            public int compare(Tuple<Integer,Integer> item1, Tuple<Integer,Integer> item2){

                int a = item1.getX()/item1.getY();

                int b = item2.getX()/item2.getY();

                if (a<b) {
                    return 1;
                }else{
                    return -1;
                }
            }
        });
         
        int ganancia = 0;
        for (Tuple<Integer,Integer> tuple : pesoValor) {
            if (K-tuple.getX()>=0) {
                K = K - tuple.getX();
                ganancia = ganancia + tuple.getY();
            }
        }
        return ganancia;
    }

   
}

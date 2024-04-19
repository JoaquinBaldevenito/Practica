import java.util.ArrayList;
import java.util.Arrays;

public class MasterMind {
    
    public static ArrayList<ArrayList<Integer>> candidateSolutions(ArrayList<Integer> clave, int k){

        [1,2, , ]

        [ ,2,3 , ]
        
        [ , ,3,4]


        for (int j = 0; j < clave.length - k; j++) {
            
            for (int i = 0; i < 10; i++) {
                if (clave.contains(i)) {
                    continue;
                }
                ArrayList<Integer> aux = new ArrayList<>(clave);
                aux.set(j, i);
            }

        }
    }
}

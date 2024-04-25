import java.util.ArrayList;

public class MonedasGreedy {
    



    public static ArrayList<Integer> monedas(int[] moneda,int[] cantidad,int C){
        ArrayList<Integer> res = new ArrayList<>();
        int i =0;

        while (i < moneda.length) {
            if (moneda[i] <= C && cantidad[i]>=1) {
                res.add(moneda[i]);
                cantidad[i] = cantidad[i] - 1; 
                C = C-moneda[i];
             }else{
                i++;
             }
        }
        System.out.println(C);
        return res;
    }

    public static void main(String[] args) {
        int[] moneda ={7,5,1};
        int[] cantidad ={10,10,10};
        ArrayList<Integer> res = monedas(moneda,cantidad,25);
        for (Integer integer : res) {
            System.out.println(integer+",");    
        }
        
    }
}

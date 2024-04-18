import java.util.Arrays;

public class knapsack {
    
    private static int[][] F = new int[50][50];
    private static int[] weigths ={2,1,3,2};
    private static int[] values ={12,10,20,15};

    public static int mochila(int i,int j){

        if (i==0 || j==0) {
            return 0;
        }
        if (F[i][j]<0) {
            int aux;
            
            
            if (j<weigths[i]) {
                aux = mochila(i-1, j);
            } else{
                aux = Math.max(mochila(i-1, j), values[i] + mochila(i-1, j-weigths[i]));
            }
            F[i][j] = aux;
        }
       
        return F[i][j];
        
    }


    public static void main(String[] args) {
        
        for (int[] row : F) {
            Arrays.fill(row,-1);
        }

        int res = knapsack.mochila(weigths.length-1, 5);

        System.out.println("El valor mas grande que puedes lleva es de:"+res);
    }
}

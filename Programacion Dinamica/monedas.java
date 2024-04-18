import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class monedas {

    // m is size of coins array (number of different coins)
    static int minCoins(int coins[], int m, int V)
    {
       // base case
       if (V == 0) return 0;
      
       // Initialize result
       int res = Integer.MAX_VALUE;
      
       // Try every coin that has smaller value than V
       for (int i=0; i<m; i++)
       {
         if (coins[i] <= V)
         {
             int sub_res = minCoins(coins, m, V-coins[i]);
      
             // Check for INT_MAX to avoid overflow and see if
             // result can minimized
             if (sub_res != Integer.MAX_VALUE && sub_res + 1 < res)
                res = sub_res + 1;
         }
       }
       return res;
    }

    static int minCoinsPD(int coins[], int m, int V)
    {
        // table[i] will be storing 
        // the minimum number of coins
        // required for i value. So 
        // table[V] will have result
        int table[] = new int[V + 1];
 
        // Base case (If given value V is 0)
        table[0] = 0;
 
        // Initialize all table values as Infinite
        for (int i = 1; i <= V; i++)
        table[i] = Integer.MAX_VALUE;
 
        // Compute minimum coins required for all
        // values from 1 to V
        for (int i = 1; i <= V; i++)
        {
            // Go through all coins smaller than i
            for (int j = 0; j < m; j++)
            if (coins[j] <= i)
            {
                int sub_res = table[i - coins[j]];
                if (sub_res != Integer.MAX_VALUE 
                       && sub_res + 1 < table[i])
                       table[i] = sub_res + 1;
                        
                 
            }
             
        }
       
          if(table[V]==Integer.MAX_VALUE)
            return -1;
       
        return table[V];
         
    }
    



    public static void main(String[] args) {
        int[] arr = {5,2};
        int res = monedas.minCoinsPD(arr,arr.length,12);
        
        System.out.println("La cantidad de monedas minimas para el vuelto es de:" + res);
    }
}

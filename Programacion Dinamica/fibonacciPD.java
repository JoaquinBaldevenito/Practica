import java.util.HashMap;

public class fibonacciPD {
    
    int[] arr;

    public fibonacciPD(int n){
        arr = new int[n];
    }

    public  int fibonacci(int n){
        arr[0]=0;
        arr[1]=1;

        for (int i = 2; i < arr.length; i++) {
            int j = i;
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n];
    }

    public int catalan(int n){
        int[][] arreglo = new int[n+1][n+1];  
        int[] c = new int[n+1];
        c[0] = 1;
      
       for (int i = 1; i <= n; i++) {
        for (int k = 1; k <= i; k++) {
            int sum = 0;
            arreglo[i][k] = c[k-1] * c[(i-k)];
           
            for (int j = 0; j <= k; j++) {
                sum = sum + arreglo[i][j];
            }
            c[i] = sum ;
        }
       }
     

   

       return c[n];
    }


    public int catalanMemo(int n ,HashMap<Integer,Integer> cache){
        if (!cache.containsKey(n)) {
            if (n == 0) {
                cache.put(0, 1);
            }else{
                int sum = 0;
                for (int k = 1; k <= n; k++) {
                    sum += (catalanMemo(k-1, cache) * catalanMemo(n-k, cache));
                }
                cache.put(n, sum);
            }
        }
        return cache.get(n);
    }


    public static void main(String[] args) {
        int n = 18;
        fibonacciPD arr = new fibonacciPD(n+1);

        int res = arr.fibonacci(n);

        System.out.println("Fibonacci:"+res);

        int cat = 4;

        HashMap<Integer,Integer> cache = new HashMap<Integer,Integer>();
        int r = arr.catalanMemo(cat,cache);

        System.out.println("EL numero Catalan es:"+r);

      
    }
}

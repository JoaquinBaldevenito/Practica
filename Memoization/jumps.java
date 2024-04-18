public class jumps {
    
    public static int minJumpsMemo(int arr [],int l, int h, int[] cache){
        
        if (h==l) {
            return 0;
        }
        if (arr[l]==0) {
            return Integer.MAX_VALUE;
        }
        if (cache[l] != -1) {
            return cache[l];
        }
        int min = Integer.MAX_VALUE;

        for (int i = l+1; i <= h && i <= l + arr[l]; i++) {
            int jumps = minJumpsMemo(arr, i, h, cache);
            if (jumps != Integer.MAX_VALUE && jumps+1 < min) {
                min = jumps+1;
            }
        }
        cache[l] = min;
        return cache [l];

    }

    public static void main(String[] args) {
        int[] arr ={1,3,5,8,9,2,6,7,6,8,9};
        //Valorr esperado 3

        int[] arr2 ={1,3,6,3,2,3,6,8,9,5};
        //Valor esperado 4

        int[] cache = new int[arr.length+1];
        for (int i = 0; i < cache.length; i++) {
            cache[i]=-1;
        } 
        int res = jumps.minJumpsMemo(arr,0,arr.length,cache);
        System.out.println("La cantidad de saltos son:" + res);
    }
}

public class jumps {
    
    public int minJumpsMemo(int arr [],int l, int h, int[] cache){
        
        if (h==l) {
            return 0;
        }
        if (arr[l]==0) {
            return Integer.MAX_VALUE;
        }
        if (cache[h] != 0) {
            return cache[h];
        }
        int min = Integer.MAX_VALUE;

        for (int i = l+1; i <= h && i <= l + arr[l]; i++) {
            int jumps = minJumpsMemo(arr, i, h, cache);
            if (jumps != Integer.MAX_VALUE && jumps+1 < min) {
                min = jumps+1;
            }
        }
        cache[h] = min;
        return cache [h];

    }
}

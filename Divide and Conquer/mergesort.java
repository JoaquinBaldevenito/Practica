public class mergesort {
    public int[] mergesort1(int[] arr, int start, int end){
        if (begin>=end) {
            return new int[0];
        }
        int mid = (start+end)/2;
        int[] a = mergesort1(arr, mid+1, end);
        int[] b = mergesort1(arr, start, mid);
        merge(a,b);
        }
    
    private int[] merge(int[] a,int[] b);
    
}

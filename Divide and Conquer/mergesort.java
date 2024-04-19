 
public class mergesort {
    public static void MergeSort(int[] arr, int start, int end){
        if (start<end) {
        
        int mid = (start+end)/2;
        MergeSort(arr, mid+1, end);
        MergeSort(arr, start, mid);
        merge(arr,start,mid,end);
        }
    }

    private static void merge(int[] arr, int l, int m, int r){

        int n1 = m - l + 1;
        int n2 = r - m ;
        
        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; i++) 
            L[i] = arr[l+i];

        for (int j = 0; j < n2; j++) 
            R[j] = arr[m+1+j];
        
        int i = 0, j = 0;

        int k = l;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }

    }
    
    public static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[])
    {
        int arr[]  = { 12, 11, 13, 5, 6, 7 };

        System.out.println("Given Array");
        printArray(arr);

        // Calling of Merge Sort
        MergeSort(arr,0,arr.length-1);

        System.out.println("\nSorted array");
        printArray(arr);
    }
}

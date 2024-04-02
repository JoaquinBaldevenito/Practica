import java.util.Arrays;

public class inversiones<T> {
    
    private  T[] array;

    public inversiones(T[] x){
        array = x;
    }


    public static <T extends Comparable<? super T>> void mergeSort(T[] array, int begin, int end,int[] cant) {
      if (array == null) throw new IllegalArgumentException("El arreglo es null, no se puede ordenar");
      if (begin < end){
         int mid = (begin + end)/2;
         mergeSort(array, begin, mid,cant);//ordena la primera mitad
         mergeSort(array, mid+1, end,cant);//ordena la segunda mitad
         merge(array, begin, mid, end,cant);//mezcla las mitades ordenadas
      }
   }
   public static  <T extends Comparable<? super T>> void merge(T[] array, int begin,int mid, int end,int[] cant) {
      int n1 = mid - begin + 1;
      int n2 = end - mid;
 
      T[] izquierda = Arrays.copyOfRange(array, begin, mid + 1);
      T[] derecha = Arrays.copyOfRange(array, mid + 1, end + 1);
 
      for (int i = 0; i < n1; i++) {
             izquierda[i] = array[begin + i];
      }
 
      for (int j = 0; j < n2; j++) {
         derecha[j] = array[mid + 1 + j];
      }
 
      int i = 0, j = 0, k = begin;
 
      while (i < n1 && j < n2) {
            if (izquierda[i].compareTo(derecha[j])<=0) {
               array[k] = izquierda[i];
               i++;
               
            } else {
               array[k] = derecha[j];
               j++;
               cant[0]= cant[0] + izquierda.length;
            }
            k++;
      }
 
      while (i < n1) {
            array[k] = izquierda[i];
            i++;
            k++;
      }
 
      while (j < n2) {
            array[k] = derecha[j];
            j++;
            k++;
      }
   }

   public static void main(String[] args) {
    Integer[] arr = {4,2,1};
    int[] k = new int[1];
    k[0]= 0;
    inversiones x = new inversiones(arr);
    x.mergeSort(arr, 0, arr.length-1,k);
    System.out.print("[");
    for (int i = 0; i < arr.length; i++) {
        System.out.print(arr[i]);
        if (i != arr.length - 1) {
            System.out.print(", ");
        }
    }
    System.out.println("]");
    System.out.println(k[0]);
   }
}

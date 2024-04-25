import java.util.ArrayList;

public class gradoDesordenado {
    
    public static int gradoDesorden(int[] arr,int n){
        int intercambios = 0;
        for (int i = n-1; i >= 1; i--) {
            int largest = indexOfLargest(arr, i+1);
            
            int temp = arr[i];
         
            arr[i]=arr[largest];
            arr[largest]= temp;

            if (i!=largest) {
                intercambios++; 
            }
            
            
           

        }
        return intercambios;
    }

    private static int indexOfLargest(int[] arr, int n){
        int x = arr[0];
        
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (x<arr[i]) {
                x=arr[i];
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,5,4,4,6,7};
    
        int a = gradoDesorden(arr1, arr1.length);

        System.out.println("Hola"+a+"Chau");
       }
}

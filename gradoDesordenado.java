import java.util.ArrayList;

public class gradoDesordenado<T> {
    
    private T[] array; 
    public gradoDesordenado(T[] arr){
        array= arr;
    }

    public int gradoDesorden(ArrayList<Integer> arr,int n){
        int intercambios = 0;
        for (int i = n-1; i >= 1; i--) {
            int largest = indexOfLargest(arr, i+1);
            
            int temp = arr.get(i);
            arr.set(i, arr.get(largest));
            arr.set(largest, temp); 

            if (i!=largest) {
                intercambios++; 
            }
            
            
           

        }
        return intercambios;
    }

    private int indexOfLargest(ArrayList<Integer> arr, int n){
        int x = arr.get(0);
        
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (x<arr.get(i)) {
                x=arr.get(i);
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Integer[] arr = {1,2,5,4,4,6,7};
        
        ArrayList<Integer> arr1 =new ArrayList<>();
        arr1.add(7);
        arr1.add(2);
        arr1.add(5);
        arr1.add(4);
        arr1.add(4);
        arr1.add(6);
        arr1.add(1);

        gradoDesordenado x = new gradoDesordenado<Integer>(arr);
        int a = x.gradoDesorden(arr1, arr1.size());

        System.out.println("Hola"+a+"Chau");
       }
}

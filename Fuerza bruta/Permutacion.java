import java.util.ArrayList;

public class Permutacion {
    
 
    public static void perm (int[] arr,int index,ArrayList<int[]> p){

        if (index == arr.length-1) {
             p.add(arr);

             for (int i = 0; i < arr.length; i++) {
                System.out.println(arr[i]+",");
            }
            System.out.println("]");
        }else{

            for (int j = index; j < arr.length; j++) {
                swap(arr,index,j);
                perm(arr, index+1, p);
                swap(arr,index,j);
            }
        }
    }

    private static void swap(int[] arr,int index, int j){
        int temp = arr[index];
        arr[index]= arr[j];
        arr[j] = temp;
        
    }


    public static void main(String[] args) {
        int[] arr ={1,2,3,4};

        ArrayList<int[]> p = new ArrayList<int[]>();
        perm(arr, 0,p);

        
    }
}

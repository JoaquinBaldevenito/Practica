public class valorMasCercano {
    

    public static int masCercano(int[] arr,int s,int l,int x){
        

        if (s<=l) {
            int mid = s+((l-s) / 2);
            
            if (x== arr[mid]) {
                return x;
            }else if (x < arr[mid]) {
                return  masCercano(arr, s, mid-1, x);
            }else{
                return  masCercano(arr, mid+1, l, x);
                }
        }else{        
            if (Math.abs(arr[s])<Math.abs(arr[l]-1)) {
                return arr[s];
            }else{
                return arr[l];
            }
        }
    }

    public static void main(String[] args) {
        int[] s = {1, 3, 5, 7, 9};
        int z = 11;
        int valorMasCercano = masCercano(s, 0, s.length, z);
        System.out.println("El valor más cercano a " + z + " en la secuencia es " + valorMasCercano);
      }
}

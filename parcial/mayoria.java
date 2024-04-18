public class mayoria {
    
    public static int mayonesa(int[] arr){
        int candidato = 0;
        int count = 0;
        
        for(int elem : arr){
            if (count==0) {
                candidato = elem;
                count = 1;
            }
            if (candidato == elem) {
                count++;
            }else{
                count--;
            }
        }

        if (count > 0) {
            int aux = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i]==candidato) {
                    aux = aux +1;
                }
            }
            
            if (aux > arr.length/2) {
                return candidato;
            }else{
                return -1;
            }
            
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2,2,10,4,2,4,4,2,2};
    
        System.out.println(mayonesa(arr));
    }
}

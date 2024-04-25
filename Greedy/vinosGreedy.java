public class vinosGreedy {
    
    public static int ganancia(int[] precios,int begin,int end,int year){
        if (begin<=end) {
            
            if (precios[begin] < precios[end]) {
                return (precios[begin]*year) + ganancia(precios, begin +1, end, year+1);
            }else{
                return (precios[end]*year) + ganancia(precios, begin , end-1, year+1);
            }
        }
        return 0;
    }
    public static void main(String[] args) {

        int[] arr = {2,4,6,2,5};
        //Valor esperado 64, [2,4,6,2,5]
        int res = ganancia(arr, 0, arr.length-1,1);
        System.out.println("La Ganancia Maxima va a ser:"+res);
    }
}

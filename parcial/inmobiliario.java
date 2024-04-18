import Tuple;

public class inmobiliario {
    
    public static Tuple<Integer,Integer> ganancia(Integer[] arr){
        int max = Integer.MIN_VALUE;
        Tuple<Integer,Integer> minmax = new Tuple<Integer,Integer>(0, 0);
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (max < arr[j] - arr[i] ) {
                    max = arr[j] - arr[i];
                    minmax.setX(i);
                    minmax.setY(j);
                }
            }
        }
        return minmax;
    }

    public static void main(String[] args) {
        Integer arr[] = {1,4,2,6,1};

        Tuple<Integer, Integer> res = ganancia(arr);
        Integer i = res.getX();
        Integer j = res.getY();
        Integer x = arr[j] - arr[i];
        System.out.println("La mejor ganancia es de:" + x + " C: "+i +"V:"+j );
    }
}

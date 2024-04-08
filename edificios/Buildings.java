package edificios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Buildings {
    private List<Skyline> buildings;


    public static List<Points> silueta(List<Skyline> arr){
        if (arr.size() <=1) {
            return getSkylinePoints(arr.get(0));
        }

        int mid = arr.size() / 2;

        List<Skyline> left = arr.subList(0, mid);
        List<Skyline> right = arr.subList(mid, arr.size());

        List<Points> leftPoints = silueta(left);
        List<Points> rightPoints = silueta(right);

        return merge(leftPoints,rightPoints);
    }

    private static List<Points> getSkylinePoints(Skyline building) {
        List<Points> points = new ArrayList<>();
        points.add(new Points(building.getIzq()));
        points.add(new Points(building.getDer()));
        return points;
    }



    private static List<Points> merge(List<Points> left,List<Points> right){

        List<Points> aux = new ArrayList<>();

        int i = 0;
        int hi = 0;
        int hd = 0;
        int d = 0;


        while (i < left.size() && d< right.size() ) {
            
            Points izq = left.get(i);
            Points der = right.get(d);

            int ejeX = Math.min(izq.getX(),der.getX());
            int maxH = Math.max(hi,hd);
            
            if (maxH > 0) {
                aux.add(new Points(ejeX,maxH));
            }
            
            if (izq.getX() < der.getX()) {
                hi = izq.getY();
                i++;
            } else if (izq.getX() > der.getX()) {
                hd = der.getY();
                d++;
            } else {
                hi = izq.getY();
                hd = der.getY();
                i++;
                d++;
            }
        }

            while (i<left.size()) {
                aux.add(left.get(i++));
            }

            while (d<right.size()) {
                aux.add(right.get(d++));
            }

            return aux;
        }

        public static void main(String[] args) {
            List<Skyline> buil = Arrays.asList(
                new Skyline(new Points(1, 11),new Points(5, 11)),
                new Skyline(new Points(2, 6),new Points(7, 6) ),
                new Skyline(new Points(3, 13), new Points(9, 13)),
                new Skyline(new Points(12, 7), new Points(16, 7)),
                new Skyline(new Points(14, 3), new Points(25, 3))
            );
    
            List<Points> skyline = silueta(buil);
            for (Points point : skyline) {
                System.out.println(point);
            }
        }
}




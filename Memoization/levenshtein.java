import java.util.HashMap;



public class levenshtein {
    
    public static int dist(String a, String b,HashMap<Tuple<String,String>,Integer> cache){
        Tuple<String,String> aux = new  Tuple<String,String>(a,b);
        if (!cache.containsKey(aux)) {
        
            if (a.length()==0) {
                return b.length();
            }else{
                if (b.length()==0) {
                    return a.length();
                }else{
                    if (a.charAt(0) == b.charAt(0)) {
                        cache.put(aux,  Math.min(dist(a.substring(1), b.substring(1), cache),
                                        Math.min(dist(a, b.substring(1), cache)+1,dist(a.substring(1), b, cache)+1)));
                    }else{
                        cache.put(aux,  Math.min(dist(a.substring(1), b.substring(1), cache)+1,
                                        Math.min(dist(a, b.substring(1), cache)+1,dist(a.substring(1), b, cache)+1)));
                    }
                }
            }
            }
            return cache.get(aux);
    }
    public static void main(String[] args) {
        String a = "hola";
        String b = "hola";

        HashMap<Tuple<String,String>,Integer> cache = new HashMap<>();
        int res = levenshtein.dist(a, b, cache);

        System.out.println("La distancia de levenshtein es de:"+res);
    }
}

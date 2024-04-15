package edificios;

public class Tuple<T,P> {

    private T a;
    private P b;
    
    public Tuple(T x, P y) {
        a = x;
        b = y;
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Tuple other = (Tuple) obj;
        return a == other.a && b == other.b;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}


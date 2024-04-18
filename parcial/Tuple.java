
public class Tuple<T,P> {

    private T a;
    private P b;
    
    public Tuple(T x, P y) {
        a = x;
        b = y;
    }

    public T getX(){
        return a;
    }
    public P getY(){
        return b;
    }
    
    public void setX(T x){
        a = x;
    }

    public void setY(P y){
        b = y;
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


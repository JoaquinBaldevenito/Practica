package edificios;

public class Points {

    private int x;
    private int y;
    
    public Points(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Points(Points xy){
        x=xy.getX();
        y=xy.getY();
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    } 
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}


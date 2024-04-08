package edificios;

public class Skyline {

    private Points izq;
    private Points der;
   

    Skyline(Points izq1, Points der1){
        izq = izq1;
        der = der1;
    }

    public Points getIzq(){
        return izq;
    }

    public Points getDer(){
        return der;
    }

    public void setIzq(Points a){
        izq= a;
    }
    
    public void setDer(Points b){
        der = b;
    }
}


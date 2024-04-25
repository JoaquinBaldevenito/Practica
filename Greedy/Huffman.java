import java.util.Comparator;
import java.util.PriorityQueue;

class Node {

    char ch;
    int frequency;

    Node izq = null ;
    Node der = null ;

    public Node(char c, int f){
        this.ch = c;
        this.frequency = f; 
    }

    public char getCh(){
        return ch;
    }

    public int getF(){
        return frequency;
    }

    public Node getLeft(){
        return izq;
    }

    public Node getRight(){
        return der;
    }

    public Node(Character ch, Integer freq, Node left, Node right){  
        this.ch = ch;  
        this.frequency = freq;  
        this.izq = left;  
        this.der = right;  
    }  
}


public class Huffman {

    public static void encodeHuffman(char[] letras, int[] freq){

    
        PriorityQueue<Node> q = new PriorityQueue<Node>(Comparator.comparingInt(l -> l.frequency));
        
        for (int i = 0; i < letras.length; i++) { 
            Node hn = new Node(letras[i], freq[i],null, null); 
            q.add(hn); 
        } 

        Node root = null;
        while (q.size() > 1) {
            
            Node a = q.peek();
            q.poll();

            Node b =q.peek();
            q.poll();

            Node f = new Node('-',a.getF()+b.getF(),a,b );
            
            root = f;

            q.add(f);
        }
        printHuffman(root, "");
    }

    private static void printHuffman(Node root,String s){

        if (root.getLeft() == null && root.getRight()==null && Character.isLetter(root.getCh())) {
            
            System.out.println(root.getCh() + ":" + s); 

            return;
        }

        printHuffman(root.getLeft(), s+"0");
        printHuffman(root.getRight(), s+"1");
    }

    public static void main(String[] args) {
        char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' }; 
        int[] charfreq = { 5, 9, 12, 13, 16, 45 }; 

        encodeHuffman(charArray, charfreq);
    }
}

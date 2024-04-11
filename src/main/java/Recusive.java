package main.java;


public class Recusive {

    public static void main(String[] args) {
        
        Recusive recusive = new Recusive();
        int sum = recusive.sum(10);
        System.out.println("\n1 +...+ 10 = " + sum);
    }

    public int sum(int n) {
        if (n == 1) 
            return 1;
        else 
            return n + sum(n-1);
    }
}

package main.java;

public class RecusiveExample {

    public static void main(String[] args) {
        
        RecusiveExample example = new RecusiveExample();
        int sum = example.sum(10);
        System.out.println("\n1 +...+ 10 = " + sum);
    }

    public int sum(int n) {
        if (n == 1) 
            return 1;
        else 
            return n + sum(n-1);
    }
}

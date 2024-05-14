package main.java;

public class IterationExample {

    public static void main(String[] args) {
        
        IterationExample example = new IterationExample();
        int sum = example.sum(10);
        System.out.println("\n1 +...+ 10 = " + sum);
    }

    public int sum(int n) {
        int sum = 0;
        for (int i=1; i<=n; i++) {
            sum += i;
        }
        return sum;
    }
}

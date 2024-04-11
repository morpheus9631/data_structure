
public class Iteration {

    public static void main(String[] args) {
        
        Iteration iteration = new Iteration();
        int sum = iteration.sum(10);
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

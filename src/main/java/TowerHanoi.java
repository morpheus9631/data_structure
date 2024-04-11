package main.java;

public class TowerHanoi {

    public static void main(String[] args) { 
        
        TowerHanoi tower = new TowerHanoi();
        int n = 3;
        tower.move(n, 'A', 'C', 'B');
    }
    
    public void move(int n, char src, char dest, char aux) {
        if (n > 0) {
            move(n-1, src, aux, dest);
            String formatted = "將第 %d 個盤子由 %c 移至 %c";
            System.out.println(String.format(formatted, n, src, dest));
            move(n-1, aux, dest, src);
        }
    }    
}

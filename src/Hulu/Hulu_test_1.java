package Hulu;

import java.util.Scanner;

public class Hulu_test_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(new Hulu_test_1().solve(n, m));
        sc.close();
    }

    public String solve(int n, int m) {
        double res = 0.0;
        for (int i = 0; i < m; i++) {
            double base = Math.pow(2, i);
            double pow = 1 / base;
            res += Math.pow(n, pow);
        }
        return String.format("%.2f", res);
    }
}

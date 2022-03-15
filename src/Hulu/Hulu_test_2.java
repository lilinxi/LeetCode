package Hulu;

import java.util.Scanner;

public class Hulu_test_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        System.out.println(new Hulu_test_2().solve(m, n));

        sc.close();
    }

    public String solve(int m, int n) {
        StringBuilder buf = new StringBuilder();
        for (int i = m; i <= n; i++) {
            if (is(i)) {
                buf.append(i);
                buf.append(' ');
            }
        }
        return buf.length() > 0 ? buf.toString() : "no";
    }

    public boolean is(int num) {
        int a = num / 100;
        int b = num % 100 / 10;
        int c = num % 10;
        if (Math.pow(a, 3) + Math.pow(b, 3) + Math.pow(c, 3) == num) {
            return true;
        }
        return false;
    }
}

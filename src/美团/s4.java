package 美团;

import java.util.Scanner;

/**
 4
 4 2 2 2
 */
public class s4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        int ans = 0;

        for (int j = 1; j < n - 1; j++) {
            for (int i = 0; i < j; i++) {
                for (int k = j + 1; k < n; k++) {
                    if ((a[i] - a[j]) == (2 * a[j] - a[k])) {
                        ans++;
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
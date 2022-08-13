package Tencent;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        System.out.println(new Main2().kMin(
                new int[][]{
                        new int[]{1, 5, 9},
                        new int[]{10, 11, 13},
                        new int[]{12, 13, 15},
                },
                3,
                8
        ));
    }

    public int getMinIndex(int[][] matrix, int[] index, int n) {
        int minIndex = -1;
        int minValue = -1;
        for (int i = 0; i < n; i++) {
            if (index[i] < n) {
                minIndex = i;
                minValue = matrix[0][index[minIndex]];
                break;
            }
        }

        for (int i = 1; i < index.length; i++) {
            if (matrix[i][index[i]] < minValue) {
                minIndex = i;
                minValue = matrix[i][index[i]];
            }
        }
        return minIndex;
    }

    public int kMin(int[][] matrix, int n, int k) {
        int[] index = new int[n];
        for (int i = 0; i < k; i++) {
            int minIndex = getMinIndex(matrix, index, n);
            index[minIndex]++;
        }
        int minIndex = getMinIndex(matrix, index, n);
        return matrix[minIndex][index[minIndex]];
    }
}

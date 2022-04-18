package FreeWheel;

import java.util.*;


public class Solution2 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param matrix int整型二维数组
     * @return int整型一维数组
     */
    public List<Integer> ret = new ArrayList<>();

    public int[] antiSpiralOrder(int[][] matrix) {
        // write code here
        int cols = matrix.length;
        int rows = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            ret.add(matrix[cols - 1][i]);
        }
        if (cols > 1 && rows > 0) {
            int[][] newM = new int[rows][cols - 1];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols - 1; j++) {
                    newM[i][j] = matrix[cols - j - 2][i];
                }
            }
            return antiSpiralOrder(newM);
        }
        int[] retList = new int[ret.size()];
        for (int i = 0; i < ret.size(); i++) {
            retList[i] = ret.get(i);
        }
        return retList;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().antiSpiralOrder(new int[][]{
                {1, 2, 3},
        }));
    }
}
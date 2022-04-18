package FreeWheel;

import java.util.*;


class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}


public class Solution1 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param preSlice int整型一维数组 先序遍历结果数组
     * @return TreeNode类
     */
    public TreeNode reConstructBST(int[] preSlice) {
        // write code here
        if (preSlice.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preSlice[0]);
        if (preSlice.length == 1) {
            return root;
        }
        int rightBegin = 1;
        while (rightBegin < preSlice.length && preSlice[rightBegin] < preSlice[0]) {
            rightBegin++;
        }
        TreeNode left = null;
        if (rightBegin > 1) {
            left = reConstructBST(Arrays.copyOfRange(preSlice, 1, rightBegin));
        }
        TreeNode right = null;
        if (rightBegin < preSlice.length) {
            right = reConstructBST(Arrays.copyOfRange(preSlice, rightBegin, preSlice.length));
        }
        root.left = left;
        root.right = right;
        return root;
    }

    public static void main(String[] args) {
        TreeNode a = new Solution1().reConstructBST(new int[]{2, 1});
        System.out.println();
    }
}
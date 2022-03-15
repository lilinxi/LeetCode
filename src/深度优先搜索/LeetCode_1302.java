package 深度优先搜索;

/**
 * 给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和 。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 * 输出：15
 * 示例 2：
 *
 * 输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 * 输出：19
 *  
 *
 * 提示：
 *
 * 树中节点数目在范围 [1, 104] 之间。
 * 1 <= Node.val <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/deepest-leaves-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class LeetCode_1302 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private int maxDepth = 0;

    private int curTotal = 0;

    public void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (depth > this.maxDepth) {
            this.maxDepth = depth;
            this.curTotal = root.val;
        } else if (depth == this.maxDepth) {
            this.curTotal += root.val;
        }
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }

    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 0);
        return curTotal;
    }

    public static void main(String[] args) {

    }
}

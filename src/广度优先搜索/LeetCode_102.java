package 广度优先搜索;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
 * 示例 2：
 * <p>
 * 输入：root = [1]
 * 输出：[[1]]
 * 示例 3：
 * <p>
 * 输入：root = []
 * 输出：[]
 *  
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [0, 2000] 内
 * -1000 <= Node.val <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


class TreeNode {
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


public class LeetCode_102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        List<List<TreeNode>> listNode = new ArrayList<>();

        if (root == null) {
            return list;
        }

        list.add(Arrays.asList(root.val));
        listNode.add(Arrays.asList(root));

        int j = 0;
        List<TreeNode> beforeLayerNode = new ArrayList<>(listNode.get(j));
        while (!beforeLayerNode.isEmpty()) {
            List<Integer> newLayer = new ArrayList<>();
            List<TreeNode> newLayerNode = new ArrayList<>();
            for (int i = 0; i < beforeLayerNode.size(); i++) {
                if (beforeLayerNode.get(i).left != null) {
                    newLayer.add(beforeLayerNode.get(i).left.val);
                    newLayerNode.add(beforeLayerNode.get(i).left);
                }
                if (beforeLayerNode.get(i).right != null) {
                    newLayer.add(beforeLayerNode.get(i).right.val);
                    newLayerNode.add(beforeLayerNode.get(i).right);
                }
            }
            if (newLayer.size() > 0) {
                list.add(newLayer);
                listNode.add(newLayerNode);
                j++;
                beforeLayerNode = new ArrayList<>(listNode.get(j));
            }else{
                break;
            }
        }

        return list;
    }
}

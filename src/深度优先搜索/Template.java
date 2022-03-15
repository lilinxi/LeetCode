//package 深度优先搜索;
//
//public class Template {
//    public void dfs(TreeNode node, int depth) {           // Key：递归遍历各个子树
//        if (node == null) {                               // Key：在遍历前判断子树是否为空
//            return;
//        }
//        visit(node);                                      // Key：执行你的操作
//                                                          // Key：使用函数调用的函数栈，代替dfs的栈操作，调用函数即为入栈，函数返回即为出栈
//        dfs(node.left, depth + 1);                  // Key：优先遍历左子树，层数加一
//        dfs(node.right, depth + 1);                 // Key：遍历右子树，层数加一
//    }
//
//    public static void main(String[] args) {
//        dfs(root, 0);                               // Key：从树的根节点，层数为0开始遍历
//    }
//}

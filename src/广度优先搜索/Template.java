//package 广度优先搜索;
//
//import java.util.LinkedList;
//import java.util.Queue;
//
//public class Template {
//    public static void main(String[] args) {
//        Queue<String> queue = new LinkedList<>();           // Key：广度优先遍历当前层的队列
//        queue.add(root);                                    // Key：第一层只有根节点
//        boolean[] marked = new boolean[tree.size()];                        // 当前节点是否已经遍历过
//        int layer = 1;                                                      // 当前层的深度
//        while (!queue.isEmpty()) {                          // Key：当前层存在
//            layer++;                                                        // 层深度加一
//            int size = queue.size();                        // Key：当前层的大小
//            while (size-- > 0) {                            // Key：遍历当前层
//                String cur = queue.poll();                                  // 从当前层取出一个元素
//                for (String next : tree) {                                  // 遍历所有元素
//                    if (!marked[next]) {                                    // 并且当前元素未被访问
//                        if (connect(cur)) {                                 // 并且是当前层的下一层元素
//                            if (find(cur)) {                                // 已找到目标元素
//                                return;
//                            }
//                            queue.add(next);                // Key：添加到下一层，下一层和当前层在同一队列中，当前层在队首，下一层在队尾
//                            marked[next] = true;                            // 已访问
//                        }
//                    }
//                }
//            }                                               // Key：遍历完毕当前层，此时队列全为下一层元素
//        }
//    }
//}

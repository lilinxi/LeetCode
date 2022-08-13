//package 回溯;
//
//import java.util.*;
//
//public class Template {
//    List<Stack> ans = new ArrayList<>();                                        // 存储所有满足条件的结果
//    Stack<String> path = new Stack<>();                                         // 存储当前遍历的路径
//    List<String> choiceList = new ArrayList<>();                                // 存储所有选择
//
//    public List<Stack> main() {
//        backtrack(path, choiceList);
//        return ans;
//    }
//
//    public void backtrack(Stack<String> path, List<String> choiceList) {
//        if (success(path)) {                                                    // 当前路径成功
//            ans.add(path);
//            return;
//        }
//        for (String choice : choiceList) {
//            if (fail(path, choice)) {                                           // 当前路径已被剪枝
//                continue;
//            }
//            path.push(choice);                                                  // 作出选择
//            backtrack(path, choiceList);                                        // 进入下一层决策树
//            path.pop();                                                         // 取消选择
//        }
//    }
//}

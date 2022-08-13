//package 滑动窗口;
//
//import java.util.HashMap;
//
//public class Template {
//    public String minWindow(String s, String t) {
//        HashMap<Character, Integer> window = new HashMap<>();                       // 当前窗口
//        HashMap<Character, Integer> need = new HashMap<>();                         // 目标字符串
//        for (char c : t.toCharArray()) {
//            need.put(c, need.getOrDefault(c, 0) + 1);
//        }
//        int left = 0, right = 0;                                                    // 左右指针
//        int minLen = Integer.MAX_VALUE, ansLeft = -1, ansRight = -1;                // 最小长度和对应的左右指针
//        for (; right < s.length(); right++) {                                       // 移动右指针，扩大窗口
//            char c = s.charAt(right);
//            window.put(c, window.getOrDefault(c, 0) + 1);                // 扩大当前窗口
//            while (窗口满足条件，可以收缩){                                             // 判断窗口满足条件
//                if (right - left + 1 < minLen) {                                    // 重写最优解
//                    minLen = right - left + 1;
//                    ansLeft = left;
//                    ansRight = right + 1;
//                }
//                left++;                                                             // 移动左指针，缩小窗口
//                char cc = s.charAt(left);
//                window.put(cc, window.getOrDefault(cc, 0) - 1);          // 缩小当前窗口
//            }
//        }
//        return ansLeft == -1 ? "" : s.substring(ansLeft, ansRight);                 // 返回子串
//    }
//}

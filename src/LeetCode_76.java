import java.util.HashMap;

/**
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 *  
 *
 * 注意：
 *
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *  
 *
 * 示例 1：
 *
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 示例 2：
 *
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 示例 3:
 *
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 *  
 *
 * 提示：
 *
 * 1 <= s.length, t.length <= 105
 * s 和 t 由英文字母组成
 *  
 *
 * 进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_76 {
    boolean subSContainT(HashMap<Character, Integer> subSMap, HashMap<Character, Integer> tMap) {
        for (Character k : tMap.keySet()) {
            if (subSMap.getOrDefault(k, 0) < tMap.get(k)) {
                return false;
            }
        }
        return true;
    }

    public String minWindow(String s, String t) {
        HashMap<Character, Integer> subSMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        // 初始化 tMap
        // TODO: string, https://blog.csdn.net/qq_38749759/article/details/78945552
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        // 左右指针。最小长度和对应的左右指针
        int l = 0, r = 0;
        int minLen = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        // 移动右指针，扩大窗口
        for (; r < s.length(); r++) {
            char c = s.charAt(r);
            if (tMap.containsKey(c)) {
                subSMap.put(c, subSMap.getOrDefault(c, 0) + 1);
            }
            // 判断窗口满足条件
            if (subSContainT(subSMap, tMap)) {
                // 移动左指针，缩小窗口
                for (; l <= r && subSContainT(subSMap, tMap); l++) {
                    if (r - l + 1 < minLen) { // 重写最优解
                        minLen = r - l + 1;
                        ansL = l;
                        ansR = r + 1;
                    }
                    char cc = s.charAt(l);
                    if (tMap.containsKey(cc)) {
                        subSMap.put(cc, subSMap.getOrDefault(cc, 0) - 1);
                    }
                }
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(new LeetCode_76().minWindow(s, t));
    }
}

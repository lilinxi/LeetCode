package 滑动窗口;

import java.util.*;

public class LeetCode_1763 {
    private Map<Character, Integer> allCharMap = new HashMap<>(); // 存储所有 char
    private Set<Character> unmatchCharSet = new HashSet<>(); // 存储未配对的 char

    public String minWindow(String s) {
        // 左右指针。最小长度和对应的左右指针
        int l = 0, r = 0;
        int minLen = Integer.MAX_VALUE, ansL = -1, ansR = -1;

        // 移动右指针，扩大窗口
        for (; r < s.length(); r++) {
            char c = s.charAt(r);
            allCharMap.put(c, allCharMap.getOrDefault(c, 0) + 1);
            // 判断新加字符是否匹配
            if (Character.isUpperCase(c) && unmatchCharSet.contains(Character.toLowerCase(c))) {
                unmatchCharSet.remove(Character.toLowerCase(c));
            } else if (Character.isLowerCase(c) && unmatchCharSet.contains(Character.toUpperCase(c))) {
                unmatchCharSet.remove(Character.toUpperCase(c));
            } else {
                unmatchCharSet.add(c);
            }
            // 判断窗口满足条件
            if (unmatchCharSet.isEmpty()) {
                // 移动左指针，缩小窗口
                for (; l <= r && unmatchCharSet.isEmpty(); l++) {
                    if (r - l + 1 < minLen) { // 重写最优解
                        minLen = r - l + 1;
                        ansL = l;
                        ansR = r + 1;
                    }
                    char cc = s.charAt(l);
                    allCharMap.put(cc, allCharMap.getOrDefault(cc, 0) - 1);
                    if (allCharMap.get(cc) == 0) {
                        if (Character.isUpperCase(cc)) {
                            unmatchCharSet.add(Character.toLowerCase(cc));
                        } else if (Character.isLowerCase(cc)) {
                            unmatchCharSet.add(Character.toUpperCase(cc));
                        }
                    }
                }
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    public static void main(String[] args) {
        String s = "YazaAay";
        System.out.println(new LeetCode_1763().minWindow(s));
    }
}

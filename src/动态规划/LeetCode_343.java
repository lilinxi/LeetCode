package 动态规划;

import java.util.HashMap;

public class LeetCode_343 {
    private final HashMap<Integer, Integer> map = new HashMap<>();

    public int integerBreak(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        }else if (map.containsKey(n)) {
            return map.get(n);
        } else {
            int maxValue = 0;
            for (int i = 1; i < n; i++) {
                int value = Math.max(i * (n - i), i * integerBreak(n - i));
                maxValue = Math.max(value, maxValue);
            }
            map.put(n, maxValue);
            return maxValue;
        }
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode_343().integerBreak(10));
    }
}

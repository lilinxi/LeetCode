package FreeWheel;

import java.util.*;

public class Solution3 {
    public int longestGeometricSeqLength(ArrayList<Integer> nums) {
        int ret = longestGeometricSeqLengthFunc(nums);
        Collections.reverse(nums);
        int retR = longestGeometricSeqLengthFunc(nums);
        return Math.max(ret, retR);
    }

    public int longestGeometricSeqLengthFunc(ArrayList<Integer> nums) {
        int n = nums.size();
        Set<Integer> divValueSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int ret = nums.get(j) / nums.get(i);
                if (ret != 0) {
                    divValueSet.add(ret);
                }
            }
        }
        int res = 2;
        for (int divValue : divValueSet) {
            res = Math.max(res, DPFunc(nums, divValue));
        }
        return res;
    }

    public int DPFunc(ArrayList<Integer> arr, int divValue) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 1;
        for (Integer integer : arr) {
            int val = map.getOrDefault(integer / divValue, 0);
            map.put(integer, val + 1);
            res = Math.max(res, val + 1);
        }
        return res;
    }

    public static void main(String[] args) {
    }
}

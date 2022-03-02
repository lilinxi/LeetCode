import javafx.util.Pair;

import java.util.*;

public class LeetCode_315 {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ret = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            ret.add(0);
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    ret.set(i, ret.get(i) + 1);
                }
            }
        }
        return ret;
    }

    public List<Integer> countSmaller_Less(int[] nums) {
        List<Integer> ret = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            ret.add(0);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = nums.length - 1; i > -1; i--) {
            int v = nums[i];
            if (map.containsKey(v)) {
                int beforeIndex = map.get(v);
                int beforeValue = ret.get(beforeIndex);
                for (int j = i + 1; j < beforeIndex; j++) {
                    if (nums[j] < nums[i]) {
                        ret.set(i, ret.get(i) + 1);
                    }
                }
                ret.set(i, ret.get(i) + beforeValue);
                map.put(v, i);
            } else {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] < nums[i]) {
                        ret.set(i, ret.get(i) + 1);
                    }
                }
                map.put(v, i);
            }
        }
        return ret;
    }

    public List<Integer> countSmaller_Sort(int[] nums) {
        List<Integer> ret = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            ret.add(0);
        }
        List<Integer> rightQueue = new LinkedList<>();
        for (int i = nums.length - 1; i > -1; i--) {
            int v = nums[i];
            ListIterator<Integer> it = rightQueue.listIterator();
            int j = 0;
            while (it.hasNext()) {
                if (it.next() >= v) {
                    break;
                }
                j++;
            }
            rightQueue.add(j, v);
            int a = rightQueue.indexOf(v);
            ret.set(i, a);
        }
        return ret;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 6, 1};
        System.out.println(new LeetCode_315().countSmaller(nums));
        System.out.println(new LeetCode_315().countSmaller_Less(nums));
        System.out.println(new LeetCode_315().countSmaller_Sort(nums));
    }
}

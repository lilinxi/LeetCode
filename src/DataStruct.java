import java.util.*;

public class DataStruct {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new LinkedList<>();

        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new PriorityQueue<>();

        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new TreeMap<>();

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new TreeSet<>();

        Stack<Integer> stack1 = new Stack<>();

        System.out.printf("%010.6f\n", 1.31);
        System.out.println(String.format("%1.1f", 1.31));
    }
}

package 阿里;//评测题目: 无

/*
 问题：写代码：从单向链表中随机选择一个节点，要求仅能遍历一次，O(1)空间复杂度
*/


//评测题目: 无

/*
 问题：写代码：从单向链表中随机选择一个节点，要求仅能遍历一次，O(1)空间复杂度
*/


import java.util.Random;

public class random {
    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        for (int i = 0; i < 30; i++) {
            System.out.println(random(n1));
        }
    }

    public static int count = 1;
    public static int length = -1;

    public static int random(Node node) {
        int time = new Random().nextInt();
        if (length != -1) {
            count = length;
        }
        int n = time % count;
        Node root = node;
        for (int i = 0; i < n; i++) {
            if (node.next == null) {
                length = i;
                return node.value;
            } else {
                root = node.next;
                node = root;
            }
        }
        count++;

        return root.value;
    }
}


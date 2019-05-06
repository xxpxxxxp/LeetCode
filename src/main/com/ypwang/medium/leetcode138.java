package com.ypwang.medium;

class leetcode138 {
    static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    public static void main(String[] args) {
        Node head = new Node();
        Node next = new Node();
        next.val = 2;
        next.random = next;
        head.val = 1;
        head.next = next;
        head.random = next;

        System.out.println(new leetcode138().copyRandomList(head));
    }

    public Node copyRandomList(Node head) {
        Node h = head;

        while (h != null) {
            Node t = new Node();
            t.val = h.val;
            t.next = h.random;
            h.random = t;
            h = h.next;
        }

        h = head;
        while (h != null) {
            if (h.random.next != null) {
                h.random.random = h.random.next.random;
            }
            h = h.next;
        }

        h = head;
        Node rst = null;

        if (h != null)
            rst = h.random;
        while (h != null) {
            Node t = h.random.next;
            if (h.next != null) {
                h.random.next = h.next.random;
            } else {
                h.random.next = null;
            }
            h.random = t;
            h = h.next;
        }

        return rst;
    }
}
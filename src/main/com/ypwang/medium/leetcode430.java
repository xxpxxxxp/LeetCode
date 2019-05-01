package com.ypwang.medium;

class Solution430 {
    public static void main(String[] args) {
        Node head = new Node(1, null, null, null);
        Node h = head;
        h.next = new Node(2, h, null, null);        // h is 1
        h = h.next;
        h.next = new Node(3, h, null, null);        // h is 2
        h = h.next;

        Node branch1 = new Node(7, null, null, null);
        h.child = branch1;
        Node b1 = branch1;
        b1.next = new Node(8, b1, null, null);
        b1 = b1.next;

        Node branch2 = new Node(11, null, null, null);
        b1.child = branch2;
        branch2.next = new Node(12, branch2, null, null);

        b1.next = new Node(9, b1, null, null);
        b1 = b1.next;
        b1.next = new Node(10, b1, null, null);

        h.next = new Node(4, h, null, null);        // h is 3
        h = h.next;
        h.next = new Node(5, h, null, null);        // h is 4
        h = h.next;
        h.next = new Node(6, h, null, null);        // h is 5

        Node hh = new Solution430().flatten(head);
        System.out.println(hh);
    }

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {}

        public Node(int _val, Node _prev, Node _next,Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }

    private Node[] helper(Node head) {
        Node h = head;
        Node cur = head;

        while (true) {
            if (cur.child != null) {
                Node[] child = helper(cur.child);
                cur.child = null;
                child[1].next = cur.next;
                if (cur.next != null)
                    cur.next.prev = child[1];
                cur.next = child[0];
                child[0].prev = cur;

                if (child[1].next == null)
                    return new Node[]{h, child[1]};

                cur = child[1].next;
            } else {
                if (cur.next == null)
                    return new Node[]{h, cur};
                cur = cur.next;
            }
        }
    }

    public Node flatten(Node head) {
        if (head == null) return null;
        return helper(head)[0];
    }
}
package com.ypwang.medium;

public class leetcode142 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode faster = head;
        ListNode slower = head;
        do {
            if (faster == null || faster.next == null) {
                return null;
            }
            faster = faster.next.next;
            slower = slower.next;
        } while (faster != slower);
        slower = head;
        while (slower != faster) {
            slower = slower.next;
            faster = faster.next;
        }
        return slower;
    }
}

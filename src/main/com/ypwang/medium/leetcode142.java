package com.ypwang.medium;

import com.ypwang.ListNode;

public class leetcode142 {
    public ListNode detectCycle(ListNode head) {
        ListNode faster = head;
        ListNode slower = head;
        do {
            if (faster == null || faster.getNext() == null) {
                return null;
            }
            faster = faster.getNext().getNext();
            slower = slower.getNext();
        } while (faster != slower);
        slower = head;
        while (slower != faster) {
            slower = slower.getNext();
            faster = faster.getNext();
        }
        return slower;
    }
}

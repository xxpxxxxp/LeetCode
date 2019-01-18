package com.ypwang.easy

import com.ypwang.ListNode

class Solution202 {
    val s = mutableSetOf<Int>()
    fun isHappy(n: Int): Boolean {
        if (s.contains(n)) {
            return false
        }
        s.add(n)
        var sum = 0
        var nn = n
        while (nn > 0) {
            val l = nn % 10
            sum += l*l
            nn /= 10
        }
        return if (sum == 1) true else isHappy(sum)
    }
}

class Solution21 {
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        val head = ListNode()
        var cur = head

        var l1t = l1
        var l2t = l2

        while (l1t != null && l2t != null) {
            if (l1t.`val` < l2t.`val`) {
                cur.next = l1t
                l1t = l1t.next
            } else {
                cur.next = l2t
                l2t = l2t.next
            }
            cur = cur.next!!
        }

        if (l1t != null) {
            cur.next = l1t
        }
        if (l2t != null) {
            cur.next = l2t
        }
        return head.next
    }
}
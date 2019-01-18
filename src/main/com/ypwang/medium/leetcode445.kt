package com.ypwang.medium

import com.ypwang.ListNode

class Solution445 {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val l1s = mutableListOf<Int>()
        val l2s = mutableListOf<Int>()

        var l1r = l1
        while (l1r != null) {
            l1s.add(l1r.`val`)
            l1r = l1r.next
        }

        var l2r = l2
        while (l2r != null) {
            l2s.add(l2r.`val`)
            l2r = l2r.next
        }

        var p = l1s.lastIndex
        var q = l2s.lastIndex
        var inc = 0

        var rst: ListNode? = null
        while (p >= 0 || q >= 0) {
            val pside = if (p >= 0) l1s[p] else 0
            val qside = if (q >= 0) l2s[q] else 0
            val sum = pside + qside + inc
            val pre = ListNode(sum % 10)
            pre.next = rst
            rst = pre
            inc = sum / 10
            p--
            q--
        }

        if (inc > 0) {
            val pre = ListNode(inc)
            pre.next = rst
            rst = pre
        }

        return rst
    }
}
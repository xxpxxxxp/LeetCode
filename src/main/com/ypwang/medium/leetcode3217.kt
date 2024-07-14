package com.ypwang.medium

import com.ypwang.ListNode

class Solution3217 {
    fun modifiedList(nums: IntArray, head: ListNode?): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head

        val s = nums.toSet()
        var cur = dummy
        while (cur.next != null) {
            if (cur.next!!.`val` in s)
                cur.next = cur.next!!.next
            else
                cur = cur.next!!
        }

        return dummy.next
    }
}

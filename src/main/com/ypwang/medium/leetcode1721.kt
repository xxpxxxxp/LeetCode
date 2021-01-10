package com.ypwang.medium

import com.ypwang.ListNode

class Solution1721 {
    fun swapNodes(head: ListNode?, k: Int): ListNode? {
        var p = head
        repeat(k-1) {
            p = p!!.next!!
        }

        val hold = p
        var q = head
        while (p?.next != null) {
            p = p!!.next
            q = q!!.next
        }

        val t = hold!!.`val`
        hold.`val` = q!!.`val`
        q!!.`val` = t

        return head
    }
}
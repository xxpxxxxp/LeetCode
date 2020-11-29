package com.ypwang.easy

import com.ypwang.ListNode

class Solution234 {
    fun isPalindrome(head: ListNode?): Boolean {
        var odd = false
        var fast = head
        var pre: ListNode? = null
        var slow = head
        while (fast != null) {
            fast = fast.next
            if (fast != null) {
                fast = fast.next
            } else {
                odd = true
            }

            val next = slow!!.next
            slow.next = pre
            pre = slow
            slow = next
        }

        if (odd) {
            pre = pre!!.next
        }

        while (pre != null) {
            if (pre.`val` != slow!!.`val`) {
                return false
            }
            pre = pre.next
            slow = slow.next
        }

        return true
    }
}

fun main() {
    val head = ListNode(1)
    head.next = ListNode(2)
    head.next!!.next = ListNode(2)
    head.next!!.next!!.next = ListNode(1)
    println(Solution234().isPalindrome(head))
}
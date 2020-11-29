package com.ypwang.medium

import com.ypwang.ListNode

class Solution1669 {
    fun mergeInBetween(list1: ListNode?, a: Int, b: Int, list2: ListNode?): ListNode? {
        var c = 1
        var head = list1
        while (c < a) {
            head = head!!.next
            c++
        }

        var l1 = head!!.next
        head.next = list2

        while (head!!.next != null) {
            head = head.next
        }

        while (c <= b) {
            l1 = l1!!.next
            c++
        }
        head.next = l1

        return list1
    }
}
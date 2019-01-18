package com.ypwang.easy

import com.ypwang.ListNode

class Solution876 {
    fun middleNode(head: ListNode?): ListNode? {
        var f = head
        var s = head?.next
        while (s != null) {
            f = f?.next
            s = s.next?.next
        }
        return f
    }
}

fun main(args: Array<String>) {
    println(Solution876().middleNode(null))
}
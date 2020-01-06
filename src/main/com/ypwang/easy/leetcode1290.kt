package com.ypwang.easy

import com.ypwang.ListNode

class Solution1290 {
    fun getDecimalValue(head: ListNode?): Int {
        var rst = 0
        var p = head
        while (p != null) {
            rst = rst * 2 + p.`val`
            p = p.next
        }

        return rst
    }
}
package com.ypwang.medium

import com.ypwang.ListNode
import com.ypwang.TreeNode

class Solution109 {
    fun sortedListToBST(head: ListNode?): TreeNode? {
        if (head == null)
            return null

        if (head.next == null)
            return TreeNode(head.`val`)

        val dummy = ListNode(0)
        dummy.next = head

        var fast: ListNode? = head.next
        var slow: ListNode = dummy

        while (fast != null) {
            slow = slow.next!!
            fast = fast.next?.next
        }

        val next = slow.next!!
        slow.next = null
        val treeNode = TreeNode(next.`val`)
        treeNode.left = sortedListToBST(head)
        treeNode.right = sortedListToBST(next.next)
        return treeNode
    }
}

fun main(args: Array<String>) {
    val root= ListNode(-10)
    root.next = ListNode(-3)
    root.next!!.next = ListNode(0)
    root.next!!.next!!.next = ListNode(5)
    root.next!!.next!!.next!!.next = ListNode(9)
    println(Solution109().sortedListToBST(root))
}
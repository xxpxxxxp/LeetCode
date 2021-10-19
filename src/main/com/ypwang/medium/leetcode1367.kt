package com.ypwang.medium

import com.ypwang.ListNode
import com.ypwang.TreeNode

class Solution1367 {
    private fun helper(heads: List<ListNode?>, head: ListNode?, root: TreeNode?): Boolean {
        if (heads.any { it == null } || head == null) return true
        if (root == null) return false
        val next = heads.filter { it!!.`val` == root.`val` }.map { it!!.next }.toMutableList()
        if (head.`val` == root.`val`) next.add(head.next)
        if (helper(next, head, root.left)) return true
        if (helper(next, head, root.right)) return true
        return false
    }

    fun isSubPath(head: ListNode?, root: TreeNode?): Boolean = helper(listOf(head), head, root)
}
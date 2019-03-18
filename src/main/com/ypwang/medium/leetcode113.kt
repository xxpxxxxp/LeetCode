package com.ypwang.medium

import com.ypwang.TreeNode
import java.util.*

class Solution113 {
    fun pathSum(root: TreeNode?, sum: Int): List<List<Int>> {
        if (root == null)
            return listOf()

        val rst = mutableListOf<List<Int>>()
        val stack = Stack<TreeNode>()
        var ssum = 0

        fun findSum(r: TreeNode) {
            ssum += r.`val`
            stack.add(r)
            if (r.left == null && r.right == null && ssum == sum) {
                rst.add(stack.map { it.`val` })
            }

            r.left?.let { findSum(it) }
            r.right?.let { findSum(it) }

            stack.pop()
            ssum -= r.`val`
        }

        findSum(root)

        return rst
    }
}
package com.ypwang.hard

import com.ypwang.TreeNode
import java.util.*

class Solution145 {
    data class Entry(val node: TreeNode, var state: Boolean)

    fun postorderTraversal(root: TreeNode?): List<Int> {
        if (root == null) return listOf()

        val stack = Stack<Entry>()
        stack.push(Entry(root, false))

        val rst = mutableListOf<Int>()
        while (stack.isNotEmpty()) {
            val cur = stack.pop()
            if (!cur.state) {
                cur.state = true
                stack.add(cur)
                cur.node.right?.let { stack.add(Entry(it, false)) }
                cur.node.left?.let { stack.add(Entry(it, false)) }
            } else {
                rst.add(cur.node.`val`)
            }
        }

        return rst
    }
}
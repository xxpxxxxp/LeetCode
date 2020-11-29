package com.ypwang.medium

import com.ypwang.TreeNode
import java.util.*

class Solution114 {
    fun flatten(root: TreeNode?): Unit {
        if (root == null) {
            return
        }

        val stack = Stack<TreeNode>()
        stack.add(root)

        while (stack.isNotEmpty()) {
            val cur = stack.pop()
            cur.right?.let { stack.add(it) }
            cur.left?.let { stack.add(it) }
            cur.left = null
            cur.right = if (stack.isNotEmpty()) stack.peek() else null
        }
    }
}

fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.left!!.left = TreeNode(3)
    root.left!!.right = TreeNode(4)
    root.right = TreeNode(5)
    root.right!!.right = TreeNode(6)

    println(Solution114().flatten(root))
}
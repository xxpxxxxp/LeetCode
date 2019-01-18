package com.ypwang.medium

import com.ypwang.TreeNode
import java.util.*

class Solution144 {
    fun preorderTraversal(root: TreeNode?): List<Int> {
        if (root == null) {
            return listOf()
        }
        val stack = Stack<TreeNode>()
        stack.push(root)

        val rst = mutableListOf<Int>()

        while (!stack.empty()) {
            val node = stack.pop()
            rst.add(node.`val`)
            node.right?.let { stack.push(it) }
            node.left?.let { stack.push(it) }
        }

        return rst
    }
}
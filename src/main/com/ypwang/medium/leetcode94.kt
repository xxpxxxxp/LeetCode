package com.ypwang.medium

import com.ypwang.TreeNode
import java.util.*

class Solution94 {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        if (root == null) {
            return listOf()
        }

        val rst = mutableListOf<Int>()
        val stack = Stack<Any>()
        stack.push(root)

        while (!stack.empty()) {
            val t = stack.pop()
            when (t) {
                is Int -> rst.add(t)
                is TreeNode -> {
                    if (t.right != null) {
                        stack.push(t.right)
                    }
                    stack.push(t.`val`)
                    if (t.left != null) {
                        stack.push(t.left)
                    }
                }
            }
        }

        return rst
    }
}

fun main() {
    val root = TreeNode(1)
    root.right = TreeNode(2)
    root.right!!.left = TreeNode(3)

    println(Solution94().inorderTraversal(root))
}
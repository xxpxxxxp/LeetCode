package com.ypwang.easy

import com.ypwang.TreeNode

class Solution606 {
    fun tree2str(t: TreeNode?): String {
        fun StringBuilder.helper(t: TreeNode?) {
            append("(")

            if (t != null) {
                append(t.`val`)
                if (t.left != null || t.right != null) {
                    helper(t.left)
                }
                if (t.right != null) {
                    helper(t.right)
                }
            }

            append(")")
        }

        if (t == null) {
            return ""
        }

        val result = StringBuilder().apply { helper(t) }.toString()
        return result.substring(1, result.lastIndex)
    }
}

fun main(args: Array<String>) {
    val t = TreeNode(1)
    t.left = TreeNode(2)
    t.left!!.left = TreeNode(4)
    t.right = TreeNode(3)


    println(Solution606().tree2str(t))
}
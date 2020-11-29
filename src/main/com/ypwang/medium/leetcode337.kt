package com.ypwang.medium

import com.ypwang.TreeNode

class Solution337 {
    fun rob(root: TreeNode?): Int {
        fun helper(r: TreeNode?): Pair<Int, Int> {
            if (r == null) {
                return Pair(0, 0)
            }
            val left = helper(r.left)
            val right = helper(r.right)

            return Pair(Math.max(left.first + right.first, left.second + right.second + r.`val`), left.first + right.first)
        }

        return helper(root).let { Math.max(it.first, it.second) }
    }
}

fun main() {
    val root = TreeNode(4)
    root.left = TreeNode(1)
    root.left!!.left = TreeNode(2)
    root.left!!.left!!.left = TreeNode(3)

    println(Solution337().rob(root))
}
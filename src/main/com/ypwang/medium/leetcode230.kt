package com.ypwang.medium

import com.ypwang.TreeNode

class Solution230 {
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        fun helper(myroot: TreeNode?, index: Int): Pair<Int?, Int> {
            if (myroot == null) {
                return Pair(null, 0)
            }

            val left = helper(myroot.left, index)
            if (left.first != null) {
                return Pair(left.first, 0)
            }

            val leftlen = left.second
            if (leftlen + 1 == index) {
                return Pair(myroot.`val`, 0)
            }

            val right = helper(myroot.right, index - leftlen - 1)
            if (right.first != null) {
                return Pair(right.first, 0)
            }
            return Pair(null, leftlen + 1 + right.second)
        }

        return helper(root, k).first!!
    }
}

fun main() {
    val root = TreeNode(1)
    root.right = TreeNode(2)
    println(Solution230().kthSmallest(root, 2))
}
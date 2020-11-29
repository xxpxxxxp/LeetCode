package com.ypwang.easy

import com.ypwang.TreeNode

class Solution687 {
    // int array
    // [0] root.val
    // [1] max ever
    // [2] longest semi path for root
    fun helper(root: TreeNode): IntArray {
        val lr = mutableListOf<Int>()    // left right longest route
        val lrmax = mutableListOf<Int>() // left right each max
        if (root.left != null) {
            val rst = helper(root.left!!)
            if (rst[0] == root.`val`) {
                lr.add(rst[2] + 1)
            }
            lrmax.add(rst[1])
        }
        if (root.right != null) {
            val rst = helper(root.right!!)
            if (rst[0] == root.`val`) {
                lr.add(rst[2] + 1)
            }
            lrmax.add(rst[1])
        }
        var maxme = lr.sum()
        if (!lrmax.isEmpty()) {
            maxme = Math.max(maxme, lrmax.max()!!)
        }

        return intArrayOf(root.`val`, maxme, if (lr.isEmpty()) 0 else lr.max()!!)
    }

    fun longestUnivaluePath(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        return helper(root)[1]
    }
}

fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(4)
    root.left!!.left = TreeNode(4)
    root.left!!.right = TreeNode(4)
    root.right = TreeNode(5)
    root.right!!.left = TreeNode(5)
    println(Solution687().longestUnivaluePath(root))
}
package com.ypwang.easy

import com.ypwang.TreeNode

class Solution112 {
    fun helper(root: TreeNode, sum: Int, curSum: Int): Boolean {
        if (root.left == null && root.right == null) {
            return curSum + root.`val` == sum
        }
        val cur = root.`val` + curSum
        return root.left?.let { helper(it, sum, cur) } ?: false ||
                root.right?.let { helper(it, sum, cur) } ?: false
    }

    fun hasPathSum(root: TreeNode?, sum: Int): Boolean {
        if (root == null) {
            return false
        }
        return helper(root, sum, 0)
    }
}

fun main() {
    val root = TreeNode(5)
    root.left = TreeNode(4)
    root.left!!.left = TreeNode(11)
    root.left!!.left!!.left = TreeNode(7)
    root.left!!.left!!.right = TreeNode(2)
    root.right = TreeNode(8)
    root.right!!.left = TreeNode(13)
    root.right!!.right = TreeNode(4)
    root.right!!.left!!.right = TreeNode(1)
    println(Solution112().hasPathSum(root, 22))
}
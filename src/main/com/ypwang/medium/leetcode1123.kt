package com.ypwang.medium

import com.ypwang.TreeNode

class Solution1123 {
    fun helper(root: TreeNode, depth: Int): Pair<TreeNode, Int> {
        if (root.left == null && root.right == null) return root to depth      // I'm a leaf

        val left = root.left?.let { helper(it, depth+1) }
        val right = root.right?.let { helper(it, depth+1) }

        if (left == null) return right!!
        if (right == null) return left!!

        return when {
            left.second == right.second -> root to left.second
            left.second < right.second -> right
            else -> left
        }
    }

    fun lcaDeepestLeaves(root: TreeNode?): TreeNode? {
        return if (root == null) null else helper(root, 0).first
    }
}

fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left!!.left = TreeNode(4)

    println(Solution1123().lcaDeepestLeaves(root)!!.`val`)
}
package com.ypwang.medium

class Solution1302 {
    fun deepestLeavesSum(root: TreeNode?): Int {
        if (root == null) return 0
        return sum(root, 0).second
    }

    fun sum(root: TreeNode, level: Int): Pair<Int, Int> {
        if (root.left == null && root.right == null) return level to root.`val`
        val left = root.left?.let { sum(it, level+1) } ?: -1 to 0
        val right = root.right?.let { sum(it, level+1) } ?: -1 to 0

        return when {
            left.first == right.first -> left.first to left.second + right.second
            left.first < right.first -> right
            else -> left
        }
    }
}
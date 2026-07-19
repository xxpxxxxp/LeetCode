package com.ypwang.medium

import com.ypwang.TreeNode

class Solution3997 {
    fun countDominantNodes(root: TreeNode?): Int {
        fun helper(root: TreeNode?): Pair<Int, Int> {
            if (root == null)
                return Int.MIN_VALUE to 0

            val leftMax = helper(root.left)
            val rightMax = helper(root.right)

            val max = maxOf(root.`val`, leftMax.first, rightMax.first)

            val rst = leftMax.second + rightMax.second
            return max to if (max == root.`val`) rst + 1 else rst
        }

        return helper(root).second
    }
}

package com.ypwang.hard

import com.ypwang.TreeNode

class Solution124 {
    fun maxPathSum(root: TreeNode?): Int {
        var max = Int.MIN_VALUE
        fun helper(r: TreeNode?): Int {
            if (r == null) return 0

            val left = helper(r.left)
            val right = helper(r.right)

            var m = r.`val`
            if (left > 0) m += left
            if (right > 0) m += right
            max = maxOf(max, m)

            return maxOf(0, left, right) + r.`val`
        }

        helper(root)
        return max
    }
}
package com.ypwang.medium

import com.ypwang.TreeNode

class Solution979 {
    fun distributeCoins(root: TreeNode?): Int {
        // return Pair(step, money give back)
        fun helper(t: TreeNode?): Pair<Int, Int> {
            if (t == null) {
                return Pair(0, 0)
            }

            val l = helper(t.left)
            val r = helper(t.right)

            return Pair(l.first + r.first + Math.abs(l.second) + Math.abs(r.second), l.second + r.second + t.`val` - 1)
        }

        return helper(root).first
    }
}
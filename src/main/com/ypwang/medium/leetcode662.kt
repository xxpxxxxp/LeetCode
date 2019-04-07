package com.ypwang.medium

import com.ypwang.TreeNode

class Solution662 {
    fun widthOfBinaryTree(root: TreeNode?): Int {
        val left = mutableMapOf<Int, Int>()

        if (root == null)
            return 0

        var max = 1
        fun helper(r: TreeNode?, level: Int, id: Int) {
            if (r == null)
                return

            if (level !in left) {
                left[level] = id
            } else {
                if (id - left[level]!! + 1 > max) {
                    max = id - left[level]!! + 1
                }
            }

            helper(r.left, level + 1, 2 * id)
            helper(r.right, level + 1, 2 * id + 1)
        }

        helper(root, 0, 1)

        return max
    }
}
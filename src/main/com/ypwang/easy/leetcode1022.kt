package com.ypwang.easy

import com.ypwang.TreeNode

class Solution1022 {
    fun sumRootToLeaf(root: TreeNode?): Int {
        if (root == null) return 0
        var sum = 0

        fun helper(pre: Int, r: TreeNode) {
            val cur = pre * 2 + r.`val`

            if (r.left == null && r.right == null) sum += cur

            r.left?.let { helper(cur, it) }
            r.right?.let { helper(cur, it) }
        }

        helper(0, root)
        return sum
    }
}
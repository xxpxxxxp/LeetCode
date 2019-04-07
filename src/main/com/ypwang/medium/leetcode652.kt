package com.ypwang.medium

import com.ypwang.TreeNode

class Solution652 {
    fun findDuplicateSubtrees(root: TreeNode?): List<TreeNode?> {
        val rst = mutableMapOf<String, TreeNode?>()
        val id = mutableSetOf<String>()

        fun helper(root: TreeNode?): Int {
            if (root == null) return 0

            val left = helper(root.left)
            val right = helper(root.right)
            val hash = "${root.`val`},$left,$right"

            if (hash in id && hash !in rst) {
                rst.put(hash, root)
            }
            id.add(hash)
            return hash.hashCode()
        }

        helper(root)
        return rst.map { it.value }
    }
}
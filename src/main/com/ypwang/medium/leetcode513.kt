package com.ypwang.medium

import com.ypwang.TreeNode

class Solution513 {
    fun helper(root: TreeNode, depth: Int): Pair<Int, Int> {
        if (root.left == null && root.right == null) {
            return Pair(root.`val`, depth)
        }

        val rst = mutableListOf<Pair<Int, Int>>()
        if (root.left != null) {
            rst.add(helper(root.left!!, depth+1))
        }
        if (root.right != null) {
            rst.add(helper(root.right!!, depth+1))
        }
        return rst.maxBy { it.second }!!
    }

    fun findBottomLeftValue(root: TreeNode?): Int {
        return helper(root!!, 0).first
    }
}
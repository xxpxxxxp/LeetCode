package com.ypwang.medium

import com.ypwang.TreeNode

class Solution222 {
    fun countNodes(root: TreeNode?): Int {
        return if (root == null) 0 else 1 + countNodes(root.left) + countNodes(root.right)
    }
}
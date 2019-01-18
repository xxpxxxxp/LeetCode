package com.ypwang.easy

import com.ypwang.TreeNode

class Solution965 {
    fun helper(r: TreeNode?, v: Int): Boolean {
        if (r == null)
            return true

        if (r.`val` != v)
            return false

        return helper(r.left, v) && helper(r.right, v)
    }

    fun isUnivalTree(root: TreeNode?): Boolean {
        if (root == null) {
            return true
        }
        return helper(root.left, root.`val`) && helper(root.right, root.`val`)
    }
}
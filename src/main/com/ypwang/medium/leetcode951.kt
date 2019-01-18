package com.ypwang.medium

import com.ypwang.TreeNode

class Solution951 {
    fun flipEquiv(root1: TreeNode?, root2: TreeNode?): Boolean {
        val r1null = root1 == null
        val r2null = root2 == null
        if (r1null && r2null) {
            return true
        }
        if (r1null || r2null) {
            return false
        }
        if (root1!!.`val` != root2!!.`val`) {
            return false
        }
        return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) ||
                (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left))
    }
}
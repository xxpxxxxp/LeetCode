package com.ypwang.easy

import com.ypwang.TreeNode

class Solution617 {
    fun mergeTrees(t1: TreeNode?, t2: TreeNode?): TreeNode? {
        if (t1 == null && t2 == null)
            return null

        val r = TreeNode((t1?.`val` ?: 0) + (t2?.`val` ?: 0))
        r.left = if (t1?.left != null || t2?.left != null) mergeTrees(t1?.left, t2?.left) else null
        r.right  = if (t1?.right != null || t2?.right != null) mergeTrees(t1?.right, t2?.right) else null
        return r
    }
}
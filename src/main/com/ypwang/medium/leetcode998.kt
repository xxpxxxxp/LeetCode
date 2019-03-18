package com.ypwang.medium

import com.ypwang.TreeNode

class Solution998 {
    fun insertIntoMaxTree(root: TreeNode?, `val`: Int): TreeNode? {
        if (root == null || root.`val` < `val`) {
            val t = TreeNode(`val`)
            t.left = root
            return t
        }

        if (root.right == null || root.right!!.`val` < `val`) {
            val t = root.right
            root.right = TreeNode(`val`)
            root.right!!.left = t
            return root
        }

        insertIntoMaxTree(root.right, `val`)
        return root
    }
}
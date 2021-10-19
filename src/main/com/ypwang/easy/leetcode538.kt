package com.ypwang.easy

import com.ypwang.TreeNode

class Solution538 {
    fun helper(root: TreeNode?, sum: Int): Int {
        if (root == null) {
            return sum
        }

        val s = helper(root.right, sum)
        root.`val` += s
        return helper(root.left, root.`val`)
    }

    fun convertBST(root: TreeNode?): TreeNode? {
        helper(root, 0)
        return root
    }
}
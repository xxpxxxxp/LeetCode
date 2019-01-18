package com.ypwang.easy

class TreeNode1(var `val`: Int = 0) {
    var left: TreeNode1? = null
    var right: TreeNode1? = null
}

class Solution538 {
    fun helper(root: TreeNode1?, sum: Int): Int {
        if (root == null) {
            return sum
        }

        val s = helper(root.right, sum)
        root.`val` += s
        return helper(root.left, root.`val`)
    }

    fun convertBST(root: TreeNode1?): TreeNode1? {
        helper(root, 0)
        return root
    }
}
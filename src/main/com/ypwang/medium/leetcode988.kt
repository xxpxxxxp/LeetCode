package com.ypwang.medium

import com.ypwang.TreeNode

class Solution988 {
    fun smallestFromLeaf(root: TreeNode?): String {
        if (root == null) {
            return ""
        }

        val l = smallestFromLeaf(root.left)
        val r = smallestFromLeaf(root.right)
        return minOf(l, r) + (root.`val` + 'a'.toInt()).toChar()
    }
}
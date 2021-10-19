package com.ypwang.medium

import com.ypwang.TreeNode

class Solution1325 {
    fun removeLeafNodes(root: TreeNode?, target: Int): TreeNode? {
        fun inner(r: TreeNode?): Boolean {
            if (r == null) return true
            if (inner(r.left)) r.left = null
            if (inner(r.right)) r.right = null
            return r.left == null && r.right == null && r.`val` == target
        }

        return if (inner(root)) null else root
    }
}
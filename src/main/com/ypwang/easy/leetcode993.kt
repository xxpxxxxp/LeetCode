package com.ypwang.easy

import com.ypwang.TreeNode

class Solution993 {
    fun isCousins(root: TreeNode?, x: Int, y: Int): Boolean {
        fun helper(pre: TreeNode?, cur: TreeNode, target: Int, depth: Int): Pair<TreeNode?, Int>? {
            if (cur.`val` == target) return Pair(pre, depth)
            return cur.left?.let { helper(cur, it, target, depth+1) } ?: cur.right?.let { helper(cur, it, target, depth+1) }
        }

        val tx = helper(null, root!!, x, 0)!!
        val ty = helper(null, root!!, y, 0)!!

        return tx.second == ty.second && tx.first != ty.first
    }
}
package com.ypwang.medium

import com.ypwang.TreeNode

class Solution623 {
    fun addOneRow(root: TreeNode?, v: Int, d: Int): TreeNode? {
        if (d == 1) {
            val r = TreeNode(v)
            r.left = root
            return r
        }

        fun helper(r: TreeNode, curdep: Int) {
            if (curdep + 1 == d) {
                val left = r.left
                val right = r.right
                r.left = TreeNode(v)
                r.right = TreeNode(v)
                r.left!!.left = left
                r.right!!.right = right
            } else {
                r.left?.let { helper(it, curdep + 1) }
                r.right?.let { helper(it, curdep + 1) }
            }
        }

        helper(root!!, 1)
        return root
    }
}
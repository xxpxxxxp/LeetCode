package com.ypwang.easy

import com.ypwang.TreeNode

class Solution897 {
    fun increasingBST(root: TreeNode?): TreeNode? {
        fun helper(r: TreeNode?, tail: TreeNode?): TreeNode? {
            if (r == null) return tail
            val res = helper(r.left, r)
            r.left = null
            r.right = helper(r.right, tail)
            return res
        }

        return helper(root, null)
    }
}

fun main(args: Array<String>) {
    val root = TreeNode(5)
    root.left = TreeNode(3)
    root.left!!.left = TreeNode(2)
    root.left!!.left!!.left = TreeNode(1)
    root.left!!.right = TreeNode(4)

    println(Solution897().increasingBST(root))
}
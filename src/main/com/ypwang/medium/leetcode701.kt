package com.ypwang.medium

import com.ypwang.TreeNode

class Solution701 {
    fun helper(root: TreeNode?, `val`: Int): Boolean {
        if (root == null) {
            return false
        }

        if (root.`val` > `val`) {
            val inserted = helper(root.left, `val`)
            if (inserted) {
                return true
            } else {
                val tmp = TreeNode(`val`)
                tmp.left = root.left
                root.left = tmp
            }
        } else {
            val inserted = helper(root.right, `val`)
            if (inserted) {
                return true
            } else {
                val tmp = TreeNode(`val`)
                tmp.right = root.right
                root.right = tmp
            }
        }
        return true
    }

    fun insertIntoBST(root: TreeNode?, `val`: Int): TreeNode? {
        if (root == null) {
            return TreeNode(`val`)
        }
        helper(root, `val`)
        return root
    }
}

fun main() {
    val root = TreeNode(4)
    root.left = TreeNode(2)
    root.left!!.left = TreeNode(1)
    root.left!!.right = TreeNode(3)
    root.right = TreeNode(7)

    println(Solution701().insertIntoBST(root, 5))
}
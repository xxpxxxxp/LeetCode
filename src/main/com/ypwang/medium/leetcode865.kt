package com.ypwang.medium

import com.ypwang.TreeNode

class Solution865 {
    fun helper(root: TreeNode?, depth: Int): Pair<Int, TreeNode?> {
        if (root == null) {
            return Pair(depth, root)
        }

        val l = helper(root.left, depth + 1)
        val r = helper(root.right, depth + 1)

        if (l.first > r.first) {
            return Pair(l.first, l.second)
        } else if (l.first < r.first) {
            return Pair(r.first, r.second)
        } else {
            return Pair(l.first, root)
        }
    }

    fun subtreeWithAllDeepest(root: TreeNode?): TreeNode? {
        return helper(root, 0).second
    }
}

fun main() {
    val root = TreeNode(3)
    root.left = TreeNode(5)
    root.left!!.left = TreeNode(6)
    root.left!!.right = TreeNode(2)
    root.left!!.right!!.left = TreeNode(7)
    root.left!!.right!!.right = TreeNode(4)
    root.right = TreeNode(1)
    root.right!!.left = TreeNode(0)
    root.right!!.right = TreeNode(8)

    println(Solution865().subtreeWithAllDeepest(root)!!.`val`)
}
package com.ypwang.medium

import com.ypwang.TreeNode

class Solution938 {
    fun rangeSumBST(root: TreeNode?, L: Int, R: Int): Int {
        var sum = 0
        if (root == null) {
            return sum
        }

        if (root.`val` in L..R) {
            sum += root.`val`
        }

        if (root.`val` > L) {
            sum += rangeSumBST(root.left, L, R)
        }
        if (root.`val` < R) {
            sum += rangeSumBST(root.right, L, R)
        }

        return sum
    }
}

fun main() {
    val root = TreeNode(10)
    root.left = TreeNode(5)
    root.left!!.left = TreeNode(3)
    root.left!!.right = TreeNode(7)
    root.left!!.left!!.left = TreeNode(1)
    root.left!!.right!!.left = TreeNode(6)
    root.right = TreeNode(15)
    root.right!!.left = TreeNode(13)
    root.right!!.right = TreeNode(18)

    println(Solution938().rangeSumBST(root, 6, 10))
}
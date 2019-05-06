package com.ypwang.medium

class TreeNode(var `val`: Int, var left: TreeNode? = null, var right: TreeNode? = null)

class Solution1038 {
    private fun sum(root: TreeNode?, pre: Int): Int {
        if (root == null) return pre
        root.`val` = root.`val` + sum(root.right, pre)
        return sum(root.left, root.`val`)
    }

    internal fun bstToGst(root: TreeNode?): TreeNode? {
        sum(root, 0)
        return root
    }
}

fun main() {
    val root = TreeNode(4)
    root.left = TreeNode(1)
    root.left!!.left = TreeNode(0)
    root.left!!.right = TreeNode(2)
    root.left!!.right!!.right = TreeNode(3)
    root.right = TreeNode(6)
    root.right!!.left = TreeNode(5)
    root.right!!.right = TreeNode(7)
    root.right!!.right!!.right = TreeNode(8)

    val r = Solution1038().bstToGst(root)
    println(r)
}
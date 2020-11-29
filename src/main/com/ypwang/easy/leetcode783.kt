package com.ypwang.easy

import com.ypwang.TreeNode

class Solution783 {
    fun inorder(root: TreeNode?, output: MutableList<TreeNode>) {
        if (root == null) {
            return
        }

        inorder(root.left, output)
        output.add(root)
        inorder(root.right, output)
    }
    fun minDiffInBST(root: TreeNode?): Int {
        val output = mutableListOf<TreeNode>()
        inorder(root!!, output)
        return (0 until output.lastIndex).map{ output[it+1].`val` - output[it].`val` }.min()!!
    }
}

fun main() {
    val root = TreeNode(90)
    root.left = TreeNode(69)
    root.left!!.right = TreeNode(89)
    root.left!!.left = TreeNode(49)
    root.left!!.left!!.right = TreeNode(52)
    println(Solution783().minDiffInBST(root))
}
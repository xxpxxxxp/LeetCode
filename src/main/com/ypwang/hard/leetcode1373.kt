package com.ypwang.hard

import com.ypwang.TreeNode

class Solution1373 {
    // return:
    //   Boolean: if node itself is a BST
    //   Int: maxSumBst under node
    //   Int: node sum under node
    fun helper(node: TreeNode?): Triple<Boolean, Int, Int> {
        if (node == null) return Triple(true, 0, 0)
        val (il, vl, sl) = helper(node.left)
        val (ir, vr, sr) = helper(node.right)

        var isBST = (il && ir)
        if (node.left != null) isBST = isBST && node.left!!.`val` < node.`val`
        if (node.right != null) isBST = isBST && node.`val` < node.right!!.`val`

        val sum = sl + sr + node.`val`
        var vc = maxOf(vl, vr)
        if (isBST) vc = maxOf(vc, sum)
        return Triple(isBST, vc, sum)
    }

    fun maxSumBST(root: TreeNode?): Int = maxOf(0, helper(root).second)
}

fun main() {
    val root = TreeNode(4)
    root.left = TreeNode(8)
    root.left!!.left = TreeNode(6)
    root.left!!.right = TreeNode(1)
    root.left!!.left!!.left = TreeNode(9)
    root.left!!.right!!.left = TreeNode(-5)
    root.left!!.right!!.right = TreeNode(4)
    root.left!!.right!!.left!!.right = TreeNode(-3)
    root.left!!.right!!.right!!.right = TreeNode(10)

    println(Solution1373().helper(root))
}
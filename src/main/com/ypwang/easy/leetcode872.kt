package com.ypwang.easy

import com.ypwang.TreeNode

fun getLeaf(root: TreeNode?, leaf: MutableList<TreeNode>) {
    if (root == null) {
        return
    }
    if (root.left == null && root.right == null) {
        leaf.add(root)
    }
    getLeaf(root.left, leaf)
    getLeaf(root.right, leaf)
}

class Solution872 {
    fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
        val leaf1 = mutableListOf<TreeNode>()
        val leaf2 = mutableListOf<TreeNode>()
        getLeaf(root1, leaf1)
        getLeaf(root2, leaf2)
        return leaf1.size == leaf2.size &&
                leaf1.zip(leaf2).all { ab -> ab.first.`val` == ab.second.`val` }
    }
}

fun main() {
    println(Solution872().leafSimilar(null, null))
}
package com.ypwang.medium

import com.ypwang.TreeNode

class Solution863 {
    fun distanceK(root: TreeNode?, target: TreeNode?, K: Int): List<Int> {
        if (root == null || target == null) return listOf()
        if (K == 0) return listOf(target.`val`)

        val mapping = mutableMapOf<Int, MutableSet<Int>>()

        mapping[root.`val`] = mutableSetOf()

        // build relations
        fun build(father: TreeNode, child: TreeNode?) {
            if (child != null) {
                mapping[father.`val`]!!.add(child.`val`)
                mapping[child.`val`] = mutableSetOf(father.`val`)
                build(child, child.left)
                build(child, child.right)
            }
        }

        build(root, root.left)
        build(root, root.right)

        var exclude = mutableSetOf(target.`val`)
        var rst = mapping[target.`val`]!!   // distance 1

        for (i in 1 until K) {
            val tmp = rst
            rst = tmp.flatMap {
                mapping[it]!!
            }.toSet().subtract(exclude).toMutableSet()
            exclude = tmp
        }

        return rst.toList()
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

    println(Solution863().distanceK(root, root.left, 2))
}
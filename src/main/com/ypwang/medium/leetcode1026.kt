package com.ypwang.medium

import com.ypwang.TreeNode

class Solution1026 {
    fun maxAncestorDiff(root: TreeNode?): Int {
        if (root == null) return 0

        var rst = 0
        var level = listOf(root to (root.`val` to root.`val`))

        while (level.isNotEmpty()) {
            val next = mutableListOf<Pair<TreeNode, Pair<Int, Int>>>()

            for (ps in level) {
                val node = ps.first
                val minmax = ps.second

                rst = maxOf(rst, Math.abs(node.`val` - minmax.first), Math.abs(node.`val` - minmax.second))
                val range = minOf(minmax.first, node.`val`) to maxOf(minmax.second, node.`val`)
                node.left?.let { next.add(it to range) }
                node.right?.let { next.add(it to range) }
            }

            level = next
        }

        return rst
    }
}

fun main() {
    //[8,3,10,1,6,null,14,null,null,4,7,13]

    val root = TreeNode(8)
    root.left = TreeNode(3)
    root.left!!.left = TreeNode(1)
    root.left!!.right = TreeNode(6)
    root.left!!.right!!.left = TreeNode(4)
    root.left!!.right!!.right = TreeNode(7)
    root.right = TreeNode(10)
    root.right!!.right = TreeNode(14)
    root.right!!.right!!.left = TreeNode(13)

    println(Solution1026().maxAncestorDiff(root))
}
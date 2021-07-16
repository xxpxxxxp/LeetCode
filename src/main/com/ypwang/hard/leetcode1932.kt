package com.ypwang.hard

import com.ypwang.TreeNode

class Solution1932 {
    fun canMerge(trees: List<TreeNode?>): TreeNode? {
        val valueMap = mutableMapOf<Int, TreeNode>()
        val count = mutableMapOf<Int, Int>()

        for (tree in trees.filterNotNull()) {
            valueMap[tree.`val`] = tree
            count[tree.`val`] = count.getOrDefault(tree.`val`, 0) + 1
            (tree.left?.`val`?:0).let { count[it] = count.getOrDefault(it, 0) + 1 }
            (tree.right?.`val`?:0).let { count[it] = count.getOrDefault(it, 0) + 1 }
        }

        fun traverse(tree: TreeNode?, min: Int = Int.MIN_VALUE, max: Int = Int.MAX_VALUE): Boolean {
            if (tree == null)
                return true

            if (tree.`val` <= min || tree.`val` >= max)
                return false

            valueMap.remove(tree.`val`)
            if (tree.left != null && tree.left!!.`val` in valueMap) {
                tree.left = valueMap[tree.left!!.`val`]
            }
            if (tree.right != null && tree.right!!.`val` in valueMap) {
                tree.right = valueMap[tree.right!!.`val`]
            }

            return traverse(tree.left, min, tree.`val`) && traverse(tree.right, tree.`val`, max)
        }

        return trees.firstOrNull { it != null && count[it.`val`] == 1 }?.let {
            if (traverse(it) && valueMap.isEmpty()) it else null
        }
    }
}

fun main() {
    val left = TreeNode(2)
    left.left = TreeNode(1)

    val mid = TreeNode(3)
    mid.left = TreeNode(2)
    mid.right = TreeNode(5)

    val right = TreeNode(5)
    right.left = TreeNode(4)

    println(Solution1932().canMerge(listOf(left, mid, right)))
}
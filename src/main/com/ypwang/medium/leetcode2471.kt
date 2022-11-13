package com.ypwang.medium

import com.ypwang.TreeNode

class Solution2471 {
    private fun helper(arr: IntArray): Int {
        val sorted = arr.sorted().toIntArray()
        val reverseMap = arr.withIndex().map { it.value to it.index }.toMap().toMutableMap()
        var count = 0
        for ((i, v) in arr.withIndex()) {
            // if current value not in right position
            if (v != sorted[i]) {
                // get the idx of the correct value
                val j = reverseMap[sorted[i]]!!
                // swap value for idx i and j
                arr[i] = arr[j]
                arr[j] = v
                count++
                reverseMap[v] = j
            }
        }
        return count
    }

    fun minimumOperations(root: TreeNode?): Int {
        var level: List<TreeNode> = mutableListOf(root!!)
        var count = 0
        while (level.isNotEmpty()) {
            count += helper(level.map { it.`val` }.toIntArray())
            val next = mutableListOf<TreeNode>()
            for (n in level) {
                n.left?.let { next.add(it) }
                n.right?.let { next.add(it) }
            }
            level = next
        }
        return count
    }
}

fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(4)
    root.right = TreeNode(3)
    root.left!!.left = TreeNode(7)
    root.left!!.right = TreeNode(6)
    root.right!!.left = TreeNode(8)
    root.right!!.right = TreeNode(5)
    root.right!!.left!!.left = TreeNode(9)
    root.right!!.right!!.left = TreeNode(10)
    println(Solution2471().minimumOperations(root))
}
package com.ypwang.medium

import com.ypwang.TreeNode

class Solution508 {
    fun findFrequentTreeSum(root: TreeNode?): IntArray {
        val rst = mutableListOf<Int>()
        fun helper(root: TreeNode?): Int {
            if (root == null) {
                return 0
            }

            val sum = helper(root.left) + root.`val` + helper(root.right)
            rst.add(sum)
            return sum
        }

        if (root == null) {
            return intArrayOf()
        }

        helper(root)
        val r = rst.groupBy { it }.map { it.value }
        val m = r.maxBy { it.size }!!.size
        return r.filter { it.size == m }.map { it.first() }.toIntArray()
    }
}

fun main(args: Array<String>) {
    val root = TreeNode(5)
    root.left = TreeNode(2)
    root.right = TreeNode(-5)
    println(Solution508().findFrequentTreeSum(root))
}
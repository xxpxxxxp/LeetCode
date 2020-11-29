package com.ypwang.medium

import com.ypwang.TreeNode

class Solution95 {
    fun generateTrees(n: Int): List<TreeNode?> {
        if (n == 0)
            return listOf()

        val cache = mutableMapOf<Pair<Int, Int>, List<TreeNode?>>()

        fun generate(startEnd: Pair<Int, Int>): List<TreeNode?> {
            if (startEnd.first > startEnd.second)
                return listOf<TreeNode?>(null)

            if (startEnd.first == startEnd.second)
                return listOf(TreeNode(startEnd.first))

            if (startEnd in cache)
                return cache[startEnd]!!

            val rst = mutableListOf<TreeNode?>()
            for (i in startEnd.first .. startEnd.second) {
                val left = generate(Pair(startEnd.first, i-1))
                val right = generate(Pair(i+1, startEnd.second))
                for (l in left) {
                    for (r in right) {
                        val t = TreeNode(i)
                        t.left = l
                        t.right = r
                        rst.add(t)
                    }
                }
            }
            cache[startEnd] = rst
            return rst
        }

        return generate(Pair(1, n))
    }
}

fun main() {
    println(Solution95().generateTrees(3).size)
}
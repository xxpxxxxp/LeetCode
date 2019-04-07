package com.ypwang.medium

import com.ypwang.TreeNode

class Solution655 {
    fun printTree(root: TreeNode?): List<List<String>> {
        if (root == null) {
            return listOf()
        }

        val bfs = mutableListOf<List<TreeNode?>>()
        var first: List<TreeNode?> = listOf(root)
        while (true) {
            var exit = true
            val next = mutableListOf<TreeNode?>()

            for (t in first) {
                if (t != null) {
                    exit = false
                }

                next.add(t?.left)
                next.add(t?.right)
            }

            if (exit)
                break

            bfs.add(first)
            first = next
        }

        val rst = mutableListOf<List<String>>()
        val idx = bfs.lastIndex
        for ((i, level) in bfs.withIndex()) {
            val lr = mutableListOf<String>()
            val gap = Math.pow(2.0, (idx - i).toDouble()).toInt() - 1

            for (nt in level) {
                lr.addAll(List(gap){""})
                if (nt == null) lr.add("")
                else lr.add(nt.`val`.toString())
                lr.addAll(List(gap+1){""})
            }
            rst.add(lr.dropLast(1))
        }
        return rst
    }
}

fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.right!!.left = TreeNode(4)
    println(Solution655().printTree(root))
}
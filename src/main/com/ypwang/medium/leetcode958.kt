package com.ypwang.medium

import com.ypwang.TreeNode

class Solution958 {
    class Check {
        private val l = mutableListOf<TreeNode?>()

        var nullFlag = false
        fun insert(t: TreeNode?): Boolean {
            if (t == null) {
                nullFlag = true
            } else if (nullFlag)
                return false
            l.add(t)
            return true
        }

        fun get() = l
    }

    fun isCompleteTree(root: TreeNode?): Boolean {
        var level: List<TreeNode?> = listOf(root)

        while (level.first() != null) {
            val check = Check()
            for (t in level) {
                if (!check.insert(t!!.left) || !check.insert(t.right))
                    return false
            }

            level = check.get()
            if (level.last() == null) return level.all { it?.left == null && it?.right == null }
        }

        return true
    }
}

fun main(args: Array<String>) {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.left!!.left = TreeNode(4)
    root.left!!.right = TreeNode(5)
    root.right = TreeNode(3)
    root.right!!.left = TreeNode(6)

    println(Solution958().isCompleteTree(root))
}
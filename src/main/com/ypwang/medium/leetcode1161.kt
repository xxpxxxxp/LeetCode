package com.ypwang.medium

import com.ypwang.TreeNode

import java.util.*

class Solution1161 {
    fun maxLevelSum(root: TreeNode?): Int {
        if (root == null) return 0
        var max = Int.MIN_VALUE
        var mLevel = 1

        val queue: Queue<Pair<Int, TreeNode>> = LinkedList()
        var level = 1
        var sum = 0
        queue.offer(1 to root)

        while (queue.isNotEmpty()) {
            val cur = queue.poll()
            if (cur.first != level) {
                if (sum > max) {
                    max = sum
                    mLevel = level
                }
                sum = 0
                level += 1
            }
            sum += cur.second.`val`
            cur.second.left?.let { queue.offer(level+1 to it) }
            cur.second.right?.let { queue.offer(level+1 to it) }
        }

        return if (sum > max) level else mLevel
    }
}

fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(7)
    root.right = TreeNode(0)
    root.left!!.left = TreeNode(7)
    root.left!!.right = TreeNode(-8)
    println(Solution1161().maxLevelSum(root))
}
package com.ypwang.medium

import com.ypwang.TreeNode
import java.util.*

class Solution987 {
    fun verticalTraversal(root: TreeNode?): List<List<Int>> {
        if (root == null) return listOf()

        val processing: Queue<Pair<TreeNode, Pair<Int, Int>>> = LinkedList()
        processing.add(root to (0 to 0))
        val rst = mutableListOf<Pair<Int, Pair<Int, Int>>>()

        while (processing.isNotEmpty()) {
            val cur = processing.poll()
            rst.add(cur.first.`val` to cur.second)

            cur.first.left?.let { processing.offer(it to (cur.second.first-1 to cur.second.second+1)) }
            cur.first.right?.let { processing.offer(it to (cur.second.first+1 to cur.second.second+1)) }
        }

        return rst.asSequence()
                .groupBy { it.second }.map { it.key to it.value.map { i -> i.first }.sorted() }  // same position sorted
                .groupBy { it.first.first }.toList().sortedBy { it.first }  // same vertical sorted
                .map { it.second.flatMap { l -> l.second } }
    }
}

fun main() {
    val root = TreeNode(0)
    root.left = TreeNode(5)
    root.right = TreeNode(1)
    root.left!!.left = TreeNode(9)
    root.left!!.right = TreeNode(2)
    root.left!!.right!!.right = TreeNode(3)
    root.left!!.right!!.right!!.left = TreeNode(4)
    root.left!!.right!!.right!!.right = TreeNode(8)
    root.left!!.right!!.right!!.left!!.left = TreeNode(6)
    root.left!!.right!!.right!!.left!!.left!!.left = TreeNode(7)

    println(Solution987().verticalTraversal(root))
}
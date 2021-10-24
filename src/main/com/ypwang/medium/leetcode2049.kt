package com.ypwang.medium

class Solution2049 {
    private class TreeNode(x: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun countHighestScoreNodes(parents: IntArray): Int {
        val nodes = Array(parents.size) { TreeNode(it) }
        for ((i, j) in parents.withIndex()) {
            if (j >= 0) {
                if (nodes[j].left == null)
                    nodes[j].left = nodes[i]
                else
                    nodes[j].right = nodes[i]
            }
        }

        fun postOrder(node: TreeNode?): Triple<Int, Int, Int> {
            if (node == null)
                return Triple(0, 0, 0)

            val left = postOrder(node.left)
            val right = postOrder(node.right)

            val lc = if (left.first == 0) 1 else left.first
            val rc = if (right.first == 0) 1 else right.first
            val leave = if (parents.size-1-left.first-right.first == 0) 1 else (parents.size-1-left.first-right.first)

            val score = lc * rc * leave
            val max = maxOf(left.third, right.third, score)
            var rst = 0
            if (score == max)
                rst++
            if (left.third == max)
                rst += left.second
            if (right.third == max)
                rst += right.second

            return Triple(left.first + right.first + 1, rst, max)
        }

        return postOrder(nodes[0]).second
    }
}

fun main() {
    println(Solution2049().countHighestScoreNodes(intArrayOf(-1,2,0,2,0)))
    println(Solution2049().countHighestScoreNodes(intArrayOf(-1,2,0)))
}
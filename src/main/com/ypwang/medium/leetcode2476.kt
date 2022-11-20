package com.ypwang.medium

import com.ypwang.TreeNode

class Solution2476 {
    fun closestNodes(root: TreeNode?, queries: List<Int>): List<List<Int>> {
        val sorted = mutableListOf<Int>()
        fun helper(n: TreeNode?) {
            if (n == null)
                return

            helper(n.left)
            sorted.add(n.`val`)
            helper(n.right)
        }
        helper(root)

        val arr = sorted.toIntArray()
        fun lowerBound(n: Int): Int {
            var l = 0
            var r = arr.lastIndex
            while (l < r) {
                val mid = (l + r + 1) / 2
                if (arr[mid] <= n)
                    l = mid
                else
                    r = mid - 1
            }
            return arr[l]
        }

        fun upperBound(n: Int): Int {
            var l = 0
            var r = arr.lastIndex
            while (l < r) {
                val mid = (l + r) / 2
                if (arr[mid] < n)
                    l = mid + 1
                else
                    r = mid
            }
            return arr[l]
        }

        return queries.map {
            val l = lowerBound(it)
            val r = upperBound(it)
            listOf(if (l > it) -1 else l, if (r < it) -1 else r)
        }
    }
}

fun main() {
    val root = TreeNode(6)
    root.left = TreeNode(2)
    root.right = TreeNode(13)
    root.left!!.left = TreeNode(1)
    root.left!!.right = TreeNode(4)
    root.right!!.left = TreeNode(9)
    root.right!!.right = TreeNode(15)
    root.right!!.right!!.left = TreeNode(14)
    println(Solution2476().closestNodes(root, listOf(2,5,16)))
}
package com.ypwang.medium

import com.ypwang.TreeNode

class Solution971 {
    fun flipMatchVoyage(root: TreeNode?, voyage: IntArray): List<Int> {
        val idx = voyage.withIndex().map { it.value to it.index }.toMap()
        if (root == null) return if (voyage.isEmpty()) listOf() else listOf(-1)

        fun helper(r: TreeNode, start: Int, end: Int): Set<Int> {
            if (start >= end || start >= voyage.size || r.`val` != voyage[start]) return setOf(-1)
            if (r.left == null && r.right == null) return if (start + 1 == end) setOf() else setOf(-1)
            if (r.left == null) return helper(r.right!!, start + 1, end)
            if (r.right == null) return helper(r.left!!, start + 1, end)

            var leftIdx: Int? = idx[r.left!!.`val`]
            var rightIdx: Int? = idx[r.right!!.`val`]

            if (leftIdx == null || rightIdx == null) return setOf(-1)
            if (leftIdx < rightIdx) {
                val ls = helper(r.left!!, start + 1, rightIdx)
                val rs = helper(r.right!!, rightIdx, end)
                if (-1 in ls || -1 in rs) return setOf(-1)
                return ls + rs
            } else {
                val ls = helper(r.right!!, start + 1, leftIdx)
                val rs = helper(r.left!!, leftIdx, end)
                if (-1 in ls || -1 in rs) return setOf(-1)
                return setOf(r.`val`) + ls + rs
            }
        }

        return helper(root, 0, voyage.size).toList()
    }
}

fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)

    println(Solution971().flipMatchVoyage(root, intArrayOf(1,2,3)))
}
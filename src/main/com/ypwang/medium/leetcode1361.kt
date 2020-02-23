package com.ypwang.medium

class Solution1361 {
    fun validateBinaryTreeNodes(n: Int, leftChild: IntArray, rightChild: IntArray): Boolean {
        val dsu = IntArray(n){ it }
        val parent = IntArray(n)

        fun root(idx: Int): Int {
            if (dsu[idx] != idx) dsu[idx] = root(dsu[idx])
            return dsu[idx]
        }

        fun merge(a: Int, b: Int) {
            dsu[root(a)] = root(b)
        }

        for (i in 0 until n) {
            for (j in listOf(leftChild[i], rightChild[i])) {
                if (j != -1) {
                    // check if more than 1 parent
                    parent[j]++
                    if (parent[j] > 1)
                        return false

                    // check if circle
                    if (root(i) == root(j))
                        return false
                    merge(i, j)
                }
            }
        }

        return parent.count { it == 0 } == 1
    }
}

fun main() {
    println(Solution1361().validateBinaryTreeNodes(4, intArrayOf(1,-1,3,-1), intArrayOf(2,-1,-1,-1)))
    println(Solution1361().validateBinaryTreeNodes(4, intArrayOf(1,-1,3,-1), intArrayOf(2,3,-1,-1)))
    println(Solution1361().validateBinaryTreeNodes(2, intArrayOf(1,0), intArrayOf(-1,-1)))
    println(Solution1361().validateBinaryTreeNodes(6, intArrayOf(1,-1,-1,4,-1,-1), intArrayOf(2,-1,-1,5,-1,-1)))
}
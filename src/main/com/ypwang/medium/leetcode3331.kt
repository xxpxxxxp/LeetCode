package com.ypwang.medium

class Solution3331 {
    fun findSubtreeSizes(parent: IntArray, s: String): IntArray {
        val n = parent.size
        val newPar = IntArray(n) { -1 }
        val subTree = IntArray(n)
        val child = Array(n){ mutableListOf<Int>() }

        fun findNewPar(node: Int) {
            var temp = parent[node]
            while (temp != -1 && s[temp] != s[node]) {
                temp = parent[temp]
            }
            newPar[node] = if (temp != -1) temp else parent[node]
        }

        for (i in 0 until n)
            findNewPar(i)

        for (ch in 0 until n) {
            val par = newPar[ch]
            if (par != -1) {
                child[par].add(ch)
            }
        }

        fun subTreeSize(node: Int): Int {
            var size = 1
            for (ch in child[node]) {
                size += subTreeSize(ch)
            }
            subTree[node] = size
            return size
        }

        subTreeSize(0)
        return subTree
    }
}

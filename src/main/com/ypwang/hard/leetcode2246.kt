package com.ypwang.hard

class Solution2246 {
    fun longestPath(parent: IntArray, s: String): Int {
        // build tree
        val map = mutableMapOf<Int, MutableList<Int>>()
        for ((i, v) in parent.withIndex()) {
            map.getOrPut(v, { mutableListOf() }).add(i)
        }

        // return:
        // first: longest such path that ended with root
        // second: longest such path in subtree of root
        fun helper(root: Int): Pair<Int, Int> {
            var s1 = 1
            var s2 = 1

            for (node in map.getOrDefault(root, mutableListOf())) {
                val (r1, r2) = helper(node)
                s2 = maxOf(s2, r2)
                if (s[root] != s[node]) {
                    s2 = maxOf(s2, s1 + r1)
                    s1 = maxOf(s1, r1 + 1)
                }
            }

            return s1 to s2
        }

        return helper(0).second
    }
}

fun main() {
    println(Solution2246().longestPath(intArrayOf(-1, 0, 0, 0), "aabc"))
}
package com.ypwang.hard

class Solution1857 {
    fun largestPathValue(colors: String, edges: Array<IntArray>): Int {
        val map = mutableMapOf<Int, MutableList<Int>>()
        for ((a, b) in edges)
            map.getOrPut(a) { mutableListOf() }.add(b)

        val cache = mutableMapOf<Int, IntArray>()

        fun dfs(idx: Int, visited: BooleanArray): Pair<Boolean, IntArray> {
            if (visited[idx]) {
                return true to intArrayOf()
            }

            if (cache[idx] == null) {
                visited[idx] = true

                val path = IntArray(26)

                if (idx in map && map[idx]!!.isNotEmpty()) {
                    for (i in map[idx]!!) {
                        val (circle, arr) = dfs(i, visited)
                        if (circle)
                            return true to intArrayOf()

                        for ((j, c) in arr.withIndex()) {
                            path[j] = maxOf(path[j], c)
                        }
                    }
                }

                visited[idx] = false
                path[colors[idx] - 'a']++
                cache[idx] = path
            }

            return false to cache[idx]!!
        }

        var max = -1
        for (i in colors.indices) {
            val (circle, arr) = dfs(i, BooleanArray(colors.length))
            if (circle)
                return -1

            max = maxOf(max, arr.max()!!)
        }
        return max
    }
}
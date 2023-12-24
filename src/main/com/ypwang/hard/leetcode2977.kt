package com.ypwang.hard

class Solution2977 {
    fun minimumCost(source: String, target: String, original: Array<String>, changed: Array<String>, cost: IntArray): Long {
        val index = mutableMapOf<String, Int>()
        for (o in original)
            if (o !in index)
                index[o] = index.size
        for (c in changed)
            if (c !in index)
                index[c] = index.size

        val dis = Array(index.size) { LongArray(index.size) { Long.MAX_VALUE } }
        for (i in dis.indices) {
            dis[i][i] = 0
        }
        for (i in cost.indices)
            dis[index[original[i]]!!][index[changed[i]]!!] = minOf(dis[index[original[i]]!!][index[changed[i]]!!], cost[i].toLong())
        for (k in dis.indices)
            for (i in dis.indices)
                if (dis[i][k] < Long.MAX_VALUE)
                    for (j in dis.indices)
                        if (dis[k][j] < Long.MAX_VALUE)
                            dis[i][j] = minOf(dis[i][j], dis[i][k] + dis[k][j])

        val set = mutableSetOf<Int>()
        for (o in original)
            set.add(o.length)
        val dp = LongArray(target.length + 1) { Long.MAX_VALUE }
        dp[0] = 0
        for (i in target.indices) {
            if (dp[i] == Long.MAX_VALUE)
                continue
            if (target[i] == source[i])
                dp[i + 1] = minOf(dp[i + 1], dp[i])

            for (t in set) {
                if (i + t >= dp.size)
                    continue

                val c1 = index.getOrDefault(source.substring(i, i + t), -1)
                val c2 = index.getOrDefault(target.substring(i, i + t), -1)
                if (c1 >= 0 && c2 >= 0 && dis[c1][c2] < Long.MAX_VALUE)
                    dp[i + t] = minOf(dp[i + t], dp[i] + dis[c1][c2])
            }
        }
        return if (dp[dp.size - 1] == Long.MAX_VALUE) -1L else dp[dp.size - 1]
    }
}

fun main() {
    println(Solution2977().minimumCost("abcd", "acbe", arrayOf("a","b","c","c","e","d"), arrayOf("b","c","b","e","b","e"), intArrayOf(2,5,5,1,2,20)))
}
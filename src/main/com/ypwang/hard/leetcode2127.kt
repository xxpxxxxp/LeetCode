package com.ypwang.hard

class Solution2127 {
    fun maximumInvitations(favorite: IntArray): Int {
        var answer = 0
        val graph = Array(favorite.size){ mutableListOf<Int>() }
        val pairs = mutableListOf<Pair<Int, Int>>()
        for ((i, v) in favorite.withIndex()) {
            if (i == favorite[v]) {
                if (i < v)
                    pairs.add(i to v)
            } else {
                graph[v].add(i)
            }
        }

        val visited = BooleanArray(favorite.size)

        fun dfs(node: Int): Int {
            visited[node] = true
            var max = 0
            for (neighbor in graph[node]) {
                max = maxOf(max, dfs(neighbor))
            }
            return max + 1
        }

        for (pair in pairs)
            answer += dfs(pair.first) + dfs(pair.second)

        val counter = IntArray(favorite.size)
        val round = IntArray(favorite.size)
        var rnd = 1
        var circleMax = 0
        for (i in favorite.indices) {
            if (visited[i] || round[i] != 0)
                continue

            var cnt = 1
            var j = i
            while (counter[j] == 0) {
                counter[j] = cnt
                round[j] = rnd
                j = favorite[j]
                cnt++
            }
            if (round[j] == rnd)
                circleMax = maxOf(circleMax, cnt - counter[j])

            rnd++
        }
        return maxOf(circleMax, answer)
    }
}

fun main() {
    println(Solution2127().maximumInvitations(intArrayOf(1,2,3,0)))
}
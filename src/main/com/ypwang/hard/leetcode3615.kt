package com.ypwang.hard

class Solution3615 {
    var res = 0
    val dp = BooleanArray(16384)

    fun dfs(i: Int, j: Int, al: Array<MutableSet<Int>>, label: String, mask: Int, visited: BooleanArray) {

        if (mask != 0 && dp[mask])
            return

        visited[i] = true
        visited[j] = true

        val newMask = mask or (1 shl i) or (1 shl j)
        res = maxOf(res, newMask.countOneBits())

        for (x in al[i])
            if (!visited[x])
                for (y in al[j])
                    if (!visited[y] && x != y && label[x] == label[y])
                        dfs(x, y, al, label, newMask, visited)

        if (newMask != 0)
            dp[newMask] = true
        visited[i] = false
        visited[j] = false
    }

    fun maxLen(n: Int, edges: Array<IntArray>, label: String): Int {
        val al = Array(n) { mutableSetOf<Int>() }
        for ((a, b) in edges) {
            al[a].add(b)
            al[b].add(a)
        }

        for (i in 0 until n) {
            dfs(i, i, al, label, 0, BooleanArray(n))

            for (j in al[i])
                if (i < j && label[i] == label[j])
                    dfs(i, j, al, label, 0, BooleanArray(n))
        }

        return res
    }
}

fun main() {
    println(Solution3615().maxLen(9, arrayOf(intArrayOf(5,6),intArrayOf(2,0),intArrayOf(0,7),intArrayOf(0,4),intArrayOf(0,8),intArrayOf(5,3),intArrayOf(1,7),intArrayOf(0,3),intArrayOf(8,2),intArrayOf(7,2),intArrayOf(0,5),intArrayOf(7,8),intArrayOf(7,4),intArrayOf(8,3),intArrayOf(2,1),intArrayOf(4,5),intArrayOf(5,8),intArrayOf(6,4),intArrayOf(1,6),intArrayOf(5,2),intArrayOf(3,2),intArrayOf(3,7),intArrayOf(1,3),intArrayOf(4,1)), "dabebbbae"))
}
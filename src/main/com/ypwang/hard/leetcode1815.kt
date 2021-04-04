package com.ypwang.hard

class Solution1815 {
    fun maxHappyGroups(batchSize: Int, groups: IntArray): Int {
        val pos = IntArray(batchSize)
        for (g in groups)
            pos[g % batchSize]++

        var divisible = pos[0]
        pos[0] = 0
        for (i in 1 until batchSize) {
            val t =
                if (2 * i == batchSize) pos[i] / 2
                else minOf(pos[i], pos[batchSize-i])

            divisible += t
            pos[i] -= t
            pos[batchSize-i] -= t
        }

        fun dfs(position: IntArray, last: Int): Int {
            if (position.sum() == 0)
                return 0

            var ans = Int.MIN_VALUE
            for (i in 1 until batchSize) {
                if (position[i] > 0) {
                    position[i]--
                    ans = maxOf(ans, dfs(position, (last - i + batchSize) % batchSize))
                    position[i]++
                }
            }

            if (last == 0)
                ans++
            return ans
        }

        return divisible + dfs(pos, 0)
    }
}

fun main() {
    println(Solution1815().maxHappyGroups(9, intArrayOf(3,1,3,3,5,6,1,1,9,10,3,3,3,1,1,3,3,3,19,20,1,3,3,3,3,1,1,3,3,30)))
}
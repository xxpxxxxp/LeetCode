package com.ypwang.hard

class Solution4041 {
    fun minOperations(nums: IntArray, sum: Int): Int {
        val inf = 1000000
        var dp = IntArray(sum + 1) { inf }
        dp[0] = 0

        for (x in nums) {
            val limit = maxOf(x, sum)
            val dist = IntArray(limit + 1) { -1 }
            val queue = IntArray(limit + 1)
            var head = 0
            var tail = 0

            dist[x] = 0
            queue[tail++] = x

            while (head < tail) {
                val curr = queue[head++]
                val cost = dist[curr] + 1

                if (curr <= sum / 2) {
                    val next = curr * 2

                    if (dist[next] == -1) {
                        dist[next] = cost
                        queue[tail++] = next
                    }
                }

                val next = curr / 2

                if (next >= 1 && dist[next] == -1) {
                    dist[next] = cost
                    queue[tail++] = next
                }
            }

            val nextDp = dp.clone()

            for (value in 1..sum) {
                if (dist[value] == -1)
                    continue

                val cost = dist[value]

                for (s in value..sum)
                    if (dp[s - value] != inf)
                        nextDp[s] = minOf(nextDp[s], dp[s - value] + cost)
            }

            dp = nextDp
        }

        return if (dp[sum] == inf) -1 else dp[sum]
    }
}

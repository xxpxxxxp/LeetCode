package com.ypwang.medium

class Solution4040 {
    fun minOperations(nums: IntArray, sum: Int): Int {
        val INF = Int.MAX_VALUE.toLong()

        var dp = LongArray(sum + 1) { INF }
        dp[0] = 0

        for (num in nums) {
            val options = mutableSetOf<Int>()
            val toMake = LongArray(sum + 1) { INF }

            var curr = num
            var steps = 0L

            // num, num*2, num*4, ...
            while (curr <= sum) {
                toMake[curr] = minOf(toMake[curr], steps)
                options.add(curr)

                steps++
                curr *= 2
            }

            // num, num/2, num/4, ...
            curr = num
            steps = 0

            while (curr > 0) {
                if (curr <= sum) {
                    toMake[curr] = minOf(toMake[curr], steps)
                    options.add(curr)
                }

                steps++
                curr /= 2
            }

            val tempDp = dp.copyOf()

            for (i in 0..sum) {
                if (dp[i] == INF)
                    continue

                for (j in options) {
                    if (i + j > sum)
                        continue

                    if (toMake[j] == INF)
                        continue

                    tempDp[i + j] = minOf(
                        tempDp[i + j],
                        dp[i] + toMake[j]
                    )
                }
            }

            dp = tempDp
        }

        return if (dp[sum] == INF) -1 else dp[sum].toInt()
    }
}

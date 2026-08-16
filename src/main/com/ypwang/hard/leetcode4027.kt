package com.ypwang.hard

class Solution4027 {
    fun elevatorRequests(n: Int, start: Int, requests: Array<IntArray>): Long {
        val m = requests.size
        val totalMasks = 1 shl m
        val dp = Array(totalMasks) { LongArray(m) { Long.MAX_VALUE / 4 } }

        for (i in 0 until m)
            dp[1 shl i][i] = maxOf(Math.abs(start.toLong() - requests[i][1]), requests[i][0].toLong())

        for (mask in 1 until totalMasks) {
            for (last in 0 until m) {
                if ((mask and (1 shl last)) == 0)
                    continue

                val currentTime = dp[mask][last]
                val currentFloor = requests[last][1]

                for (next in 0 until m) {
                    if ((mask and (1 shl next)) != 0)
                        continue

                    val newMask = mask or (1 shl next)
                    dp[newMask][next] = minOf(dp[newMask][next], maxOf(currentTime + Math.abs(currentFloor.toLong() - requests[next][1]), requests[next][0].toLong()))
                }
            }
        }

        val fullMask = totalMasks - 1
        return dp[fullMask].min()
    }
}

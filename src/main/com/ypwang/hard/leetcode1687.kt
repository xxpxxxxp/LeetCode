package com.ypwang.hard

class Solution1687 {
    fun boxDelivering(boxes: Array<IntArray>, portsCount: Int, maxBoxes: Int, maxWeight: Int): Int {
        val dp = IntArray(boxes.size + 1)

        var start = 0
        var weight = 0
        var diffPort = 0

        for (i in boxes.indices) {
            if (i - start == maxBoxes) {
                weight -= boxes[start][1]
                if (boxes[start][0] != boxes[start+1][0])
                    diffPort--

                start++
            }

            weight += boxes[i][1]
            if (i > 0 && boxes[i][0] != boxes[i-1][0])
                diffPort++

            while (weight > maxWeight || (start < i && dp[start] == dp[start+1])) {
                weight -= boxes[start][1]
                if (boxes[start][0] != boxes[start+1][0])
                    diffPort--

                start++
            }

            dp[i+1] = diffPort + 2 + dp[start]
        }

        return dp.last()
    }
}

fun main() {
    println(Solution1687().boxDelivering(
        arrayOf(intArrayOf(1,1), intArrayOf(2,1), intArrayOf(1,1)), 2, 3, 3
    ))
}
package com.ypwang.medium

class Solution1105 {
    fun minHeightShelves(books: Array<IntArray>, shelf_width: Int): Int {
        // triple(pre height, last height, last thickness)
        val dp = IntArray(books.size+1)
        dp[1] = books[0][1]

        for (i in 2 until books.size+1) {
            val idx = i-1
            // put on another level
            var thickness = books[idx][0]
            var height= books[idx][1]
            dp[i] = dp[idx] + height

            for (j in i-1 downTo 1) {
                thickness += books[j-1][0]
                if (thickness > shelf_width) break

                height = maxOf(height, books[j-1][1])
                if (dp[i] > dp[j-1] + height) {
                    dp[i] = dp[j-1] + height
                }
            }
        }

        return dp.last()
    }
}

fun main() {
    println(Solution1105().minHeightShelves(arrayOf(intArrayOf(1,1),intArrayOf(2,3),intArrayOf(2,3),intArrayOf(1,1),intArrayOf(1,1),intArrayOf(1,1),intArrayOf(1,2)), 4))
}
package com.ypwang.hard

import java.util.*

class Solution3013 {
    fun minimumCost(nums: IntArray, k: Int, dist: Int): Long {
        var windowSum = 0L
        val n = nums.size
        val using = TreeSet(compareBy<Int> { nums[it] }.thenBy { it })
        val waiting = TreeSet(compareBy<Int> { nums[it] }.thenBy { it })

        for (i in 1..dist + 1) {
            using.add(i)
            windowSum += nums[i]
        }
        while (using.size > k - 1) {
            val i = using.pollLast()
            windowSum -= nums[i]
            waiting.add(i)
        }

        var result = windowSum
        var i = 1
        while (i + dist + 1 < n) {
            waiting.add(i + dist + 1)

            if (i in using) {
                windowSum -= nums[i]
                using.remove(i)
                val j = waiting.pollFirst()
                windowSum += nums[j]
                using.add(j)
            } else {
                waiting.remove(i)
                val j1 = waiting.first()
                val j2 = using.last()
                if (nums[j1] < nums[j2]) {
                    windowSum -= nums[j2]
                    using.remove(j2)
                    waiting.add(j2)

                    windowSum += nums[j1]
                    using.add(j1)
                    waiting.remove(j1)
                }
            }

            result = minOf(result, windowSum)
            i++
        }
        return result + nums[0]
    }
}

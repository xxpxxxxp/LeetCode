package com.ypwang.hard

import java.util.*

class Solution3049 {
    fun earliestSecondToMarkIndices(nums: IntArray, changeIndices: IntArray): Int {
        val m = changeIndices.size
        val n = nums.size
        if (m < n) {
            return -1
        }

        val set = mutableSetOf<Int>()
        val first = BooleanArray(m)
        for ((i, c) in changeIndices.withIndex())
            if (nums[c - 1] > 1 && set.add(c))
                first[i] = true

        var sum = nums.fold(0L) { a, b -> a + b }
        sum += n.toLong()

        fun check(idx: Int): Boolean {
            val pq = PriorityQueue<Int>()
            var need = sum
            var count = 0
            for (i in idx-1 downTo 0) {
                if (!first[i]) {
                    count++
                    continue
                }
                pq.add(nums[changeIndices[i] - 1])
                need -= nums[changeIndices[i] - 1] - 1
                if (pq.size > count) {
                    need += pq.poll() - 1
                    count++
                }

                if (need <= idx)
                    break
            }
            return need <= idx
        }

        var l = n
        var r = minOf(sum, m.toLong()).toInt() + 1
        while (l < r) {
            val mid = (l + r) / 2
            if (check(mid))
                r = mid
            else
                l = mid + 1
        }
        return if (l > minOf(sum, m.toLong())) -1 else l
    }
}

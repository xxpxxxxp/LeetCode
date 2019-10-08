package com.ypwang.hard

class Solution327 {
    fun countRangeSum(nums: IntArray, lower: Int, upper: Int): Int {
        val sums = LongArray(nums.size+1)
        var sum = 0L
        for ((i, num) in nums.withIndex()) {
            sum += num
            sums[i+1] = sum
        }

        fun mergeSort(start: Int, end: Int): Int {
            if (end - start < 2) return 0

            val mid = (start + end) / 2
            var count = mergeSort(start, mid) + mergeSort(mid, end)

            var k = mid
            var j = mid

            var r = mid
            var t = 0
            val cp = LongArray(end - start)

            for (l in start until mid) {
                while (k < end && sums[k] - sums[l] < lower) k++
                while (j < end && sums[j] - sums[l] <= upper) j++
                while (r < end && sums[r] < sums[l]) cp[t++] = sums[r++]
                cp[t++] = sums[l]

                count += j - k
            }

            System.arraycopy(cp, 0, sums, start, t)
            return count
        }

        return mergeSort(0, sums.size)
    }
}

fun main() {
    println(Solution327().countRangeSum(intArrayOf(-2, 5, -1), -2, 2))
}
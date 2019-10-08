package com.ypwang.hard

class Solution493 {
    fun reversePairs(nums: IntArray): Int {
        fun mergeSort(start: Int, end: Int): Int {
            if (end - start < 2) return 0

            val mid = (start + end) / 2
            var count = mergeSort(start, mid) + mergeSort(mid, end)

            var k = start

            var l = start
            var t = 0
            val cp = IntArray(end - start)

            for (r in mid until end) {
                while (k < mid && nums[k] <= 2L * nums[r]) k++
                while (l < mid && nums[l] < nums[r]) cp[t++] = nums[l++]
                cp[t++] = nums[r]

                count += mid - k
            }

            // fill in left remaining
            for (i in l until mid) {
                cp[t++] = nums[i]
            }

            System.arraycopy(cp, 0, nums, start, cp.size)
            return count
        }

        return mergeSort(0, nums.size)
    }
}

fun main() {
    println(Solution493().reversePairs(intArrayOf(2147483647,2147483647,2147483647,2147483647,2147483647,2147483647)))
    println(Solution493().reversePairs(intArrayOf(1,3,2,3,1)))
    println(Solution493().reversePairs(intArrayOf(2,4,3,5,1)))
}
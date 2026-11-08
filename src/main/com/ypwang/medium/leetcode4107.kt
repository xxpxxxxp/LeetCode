package com.ypwang.medium

class Solution4107 {
    fun countSuffix(nums: IntArray, target: IntArray): Int {
        val n = nums.size
        val freq = IntArray(100001)

        var nonZero = 0

        for (i in 0 until n) {
            val x = nums[i]
            val y = target[i]

            if (x == y) {
                continue
            }

            if (freq[x] == 0) {
                nonZero++
            }

            freq[x]++

            if (freq[x] == 0) {
                nonZero--
            }

            if (freq[y] == 0) {
                nonZero++
            }

            freq[y]--

            if (freq[y] == 0) {
                nonZero--
            }
        }

        var bad = 0

        for (i in 1 until n) {
            if (target[i - 1] < target[i]) {
                bad++
            }
        }

        var res = 0
        var prefixEqual = true

        for (i in 0 until n) {
            if (prefixEqual && bad == 0 && nonZero == 0) {
                res++
            }

            val x = nums[i]

            if (freq[x] == 0) {
                nonZero++
            }

            freq[x]--

            if (freq[x] == 0) {
                nonZero--
            }

            val y = target[i]

            if (freq[y] == 0) {
                nonZero++
            }

            freq[y]++

            if (freq[y] == 0) {
                nonZero--
            }

            if (nums[i] != target[i]) {
                prefixEqual = false
            }

            if (i + 1 < n && target[i] < target[i + 1]) {
                bad--
            }
        }

        return res
    }
}

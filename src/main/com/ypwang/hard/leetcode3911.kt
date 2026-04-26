package com.ypwang.hard

class Solution3911 {
    fun kthRemainingInteger(nums: IntArray, queries: Array<IntArray>): IntArray {
        val n = nums.size
        val q = queries.size

        val ans = IntArray(q)
        val pref = IntArray(n)
        for (i in 0 until n)
            if (nums[i] % 2 == 0)
                pref[i] = 1

        for (i in 1 until n)
            pref[i] += pref[i - 1]

        val tmp = IntArray(n)
        var ev = -1
        for (i in n - 1 downTo 0) {
            if (nums[i] % 2 == 0)
                ev = nums[i]
            tmp[i] = ev
        }

        var idx = 0

        for (x in queries) {
            val l = x[0]
            val r = x[1]
            val k = x[2]

            // count of evens in [l..r]
            var cnt = pref[r]
            if (l > 0)
                cnt -= pref[l - 1]

            // no removal or all removed evens are > 2*k
            if (cnt == 0 || tmp[l] > 2 * k) {
                ans[idx++] = 2 * k
                continue
            }

            var lo = k
            var hi = k + cnt + 1

            while (lo < hi) {
                val mid = (lo + hi) / 2

                // upper_bound: first index > 2*mid in [l..r]
                val pos = upperBound(nums, l, r, 2 * mid)

                var removed = 0
                if (pos > l) {
                    val right = minOf(pos - 1, r)
                    removed = pref[right]
                    if (l > 0)
                        removed -= pref[l - 1]
                }

                // remaining = mid - removed
                if (mid - removed >= k) {
                    hi = mid
                } else {
                    lo = mid + 1
                }
            }

            ans[idx++] = 2 * lo
        }

        return ans
    }

    // Kotlin equivalent of std::upper_bound on subarray [l..r]
    private fun upperBound(nums: IntArray, l: Int, r: Int, target: Int): Int {
        var left = l
        var right = r + 1
        while (left < right) {
            val mid = (left + right) / 2
            if (nums[mid] <= target) {
                left = mid + 1
            } else {
                right = mid
            }
        }
        return left
    }
}

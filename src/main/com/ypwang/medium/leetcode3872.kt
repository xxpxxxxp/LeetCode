package com.ypwang.medium

class Solution3872 {
    fun longestArithmetic(nums: IntArray): Int {
        val n = nums.size
        var res = 2
        val l = IntArray(n) { 2 }
        val r = IntArray(n) { 2 }

        for (i in 2 until n)
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2])
                l[i] = l[i - 1] + 1

        for (i in n - 3 downTo 0)
            if (nums[i + 1] - nums[i] == nums[i + 2] - nums[i + 1])
                r[i] = r[i + 1] + 1

        for (i in 1 until n - 1) {
            res = maxOf(res, l[i] + 1, r[i] + 1)

            if ((nums[i + 1] - nums[i - 1]) % 2 == 0) {
                val d = (nums[i + 1] - nums[i - 1]) / 2
                var le = 1
                var ri = 1

                if (i >= 2 && nums[i - 1] - nums[i - 2] == d)
                    le = l[i - 1]

                if (i + 2 < n && nums[i + 2] - nums[i + 1] == d)
                    ri = r[i + 1]

                res = maxOf(res, le + ri + 1)
            }
        }

        return res
    }
}

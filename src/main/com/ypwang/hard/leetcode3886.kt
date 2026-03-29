package com.ypwang.hard

class Solution3886 {
    fun check(nums: IntArray, len: Int): Boolean {
        val n = nums.size
        var minn = 0

        var i = 0
        while (i < n) {
            if (nums[i] < minn)
                return false

            var maxx = nums[i]
            var point = false

            for (j in i + 1..<i + len) {
                if (nums[j] < minn)
                    return false

                if (nums[j - 1] > nums[j]) {
                    if (point)
                        return false
                    point = true
                }

                maxx = maxOf(maxx, nums[j])
            }

            if (point)
                if (nums[i] < nums[i + len - 1]) return false

            minn = maxx
            i += len
        }

        return true
    }

    fun sortableIntegers(nums: IntArray): Int =
        (1..nums.size).filter {
            nums.size % it == 0 && check(nums, it)
        }.sum()
}

package com.ypwang.medium

class Solution4099 {
    fun minOperations(nums: IntArray, locked: IntArray, k: Int): Int {
        var ans = 0
        var remaining = k

        for (i in nums.indices) {
            for (j in 0 until nums.size - 1) {
                if (nums[j] > nums[j + 1]) {
                    if (locked[j] == 1) {
                        if (remaining == 0)
                            return -1

                        ans++
                        locked[j] = 0
                        remaining--
                    }

                    if (locked[j + 1] == 1) {
                        if (remaining == 0)
                            return -1

                        ans++
                        locked[j + 1] = 0
                        remaining--
                    }

                    val temp = nums[j]
                    nums[j] = nums[j + 1]
                    nums[j + 1] = temp

                    ans++
                }
            }
        }

        return ans
    }
}

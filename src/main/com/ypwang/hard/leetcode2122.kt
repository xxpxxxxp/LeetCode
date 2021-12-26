package com.ypwang.hard

class Solution2122 {
    fun recoverArray(nums: IntArray): IntArray {
        nums.sort()
        val group = nums.groupBy { it }.mapValues { it.value.size }

        fun check(k: Int): IntArray? {
            val rst = mutableListOf<Int>()
            val cp = group.toMutableMap()
            val keys = cp.keys.sorted()
            for (key in keys) {
                while (cp[key]!! > 0) {
                    rst.add(key + k)
                    cp[key] = cp[key]!! - 1
                    if (key + 2 * k !in cp || cp[key + 2 * k] == 0) {
                        return null
                    }
                    cp[key + 2 * k] = cp[key + 2 * k]!! - 1
                }
            }

            return rst.toIntArray()
        }

        for (i in 1 until nums.size) {
            val k = nums[i] - nums[0]
            if (k > 0 && k % 2 == 0) {
                val arr = check(k / 2)
                if (arr != null)
                    return arr
            }
        }

        throw Exception("invalid question!")
    }
}

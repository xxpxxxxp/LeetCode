package com.ypwang.hard

class Solution4059 {
    fun largestPower(nums: IntArray): IntArray {
        var groups = mutableListOf(nums)

        val power = IntArray(15)
        var idx = 0

        for (bit in 14 downTo 0) {
            val newGroups = mutableListOf<IntArray>()
            var active = true
            var ans = 0

            for (group in groups) {
                if (!active) {
                    newGroups.add(group)
                    continue
                }

                val ones = mutableListOf<Int>()
                val zeros = mutableListOf<Int>()

                for (x in group) {
                    if ((x and (1 shl bit)) != 0)
                        ones.add(x)
                    else
                        zeros.add(x)
                }

                ans += ones.size

                if (ones.isNotEmpty())
                    newGroups.add(ones.toIntArray())

                if (zeros.isNotEmpty()) {
                    newGroups.add(zeros.toIntArray())
                    active = false
                }
            }

            power[idx] = ans
            groups = newGroups
            idx++
        }

        return power
    }
}

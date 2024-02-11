package com.ypwang.hard

class Solution3036 {
    fun countMatchingSubarrays(nums: IntArray, pattern: IntArray): Int =
        KMP(
            IntArray(nums.size - 1) {
                if (nums[it + 1] == nums[it])
                    0
                else if (nums[it + 1] < nums[it])
                    -1
                else
                    1
            },
            pattern
        )

    private fun KMP(s: IntArray, t: IntArray): Int {
        val table = buildNextTable(t)
        var res = 0
        var i = 0
        var j = 0
        while (i < s.size) {
            if (s[i] == t[j]) {
                i++
                j++
                if (j == t.size) {
                    res++
                    j = table[j - 1]
                }
            } else {
                if (j > 0) j = table[j - 1]
                else i++
            }
        }
        return res
    }

    private fun buildNextTable(t: IntArray): IntArray {
        val table = IntArray(t.size) { 0 }
        var i = 1
        var j = 0
        while (i < t.size) {
            if (t[i] == t[j]) {
                table[i] = j + 1
                i++
                j++
            } else {
                if (j > 0) {
                    j = table[j - 1]
                } else {
                    table[i] = 0
                    i++
                }
            }
        }
        return table
    }
}

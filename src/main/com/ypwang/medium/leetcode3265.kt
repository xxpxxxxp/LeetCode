package com.ypwang.medium

class Solution3265 {
    private fun isEqual(num1: Int, num2: Int): Boolean {
        var str1 = num1.toString()
        var str2 = num2.toString()

        // EDGE
        while (str1.length < str2.length) {
            str1 = "0$str1"
        }
        while (str2.length < str1.length) {
            str2 = "0$str2"
        }

        // SOLVE
        var cnt = 0 // stores the character diff
        val list: MutableList<Int> = ArrayList()
        for (i in str1.indices) {
            if (str1[i] != str2[i]) {
                cnt++
                list.add(i)
                if (cnt > 2) {
                    return false
                }
            }
        }

        if (cnt == 0) {
            return true
        }

        // if character have atmost two diff
        if (cnt == 2) {
            val ch = str1.toCharArray()
            val idx1 = list[0]
            val idx2 = list[1]

            // SWAP IT
            val temp = ch[idx1]
            ch[idx1] = ch[idx2]
            ch[idx2] = temp

            return String(ch) == str2
        }
        return false
    }

    fun countPairs(nums: IntArray): Int {
        var res = 0
        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                if (isEqual(nums[i], nums[j])) {
                    res++
                }
            }
        }
        return res
    }
}

package com.ypwang.medium

class Solution {
    fun longestBalanced(s: String): Int {
        val mpp = mutableMapOf<Int, MutableList<Int>>()
        mpp[0] = mutableListOf(-1)

        var count0 = 0
        var count1 = 0

        for (c in s) {
            if (c == '1') count1++
            else if (c == '0') count0++
        }

        var sum = 0
        var ans = 0

        for (i in s.indices) {
            if (s[i] == '1') sum++
            if (s[i] == '0') sum--

            // Case 1: same sum
            if (sum in mpp)
                ans = maxOf(ans, i - mpp[sum]!![0])

            // Case 2: sum - 2
            if (sum - 2 in mpp) {
                for (j in mpp[sum - 2]!!) {
                    val len = i - j
                    val usedZeros = (len - 2) / 2
                    if (count0 > usedZeros) {
                        ans = maxOf(ans, len)
                        break
                    }
                }
            }

            // Case 3: sum + 2
            if (sum + 2 in mpp) {
                for (j in mpp[sum + 2]!!) {
                    val len = i - j
                    val usedOnes = (len - 2) / 2
                    if (count1 > usedOnes) {
                        ans = maxOf(ans, len)
                        break
                    }
                }
            }

            // Add current index
            mpp.getOrPut(sum) { mutableListOf() }.add(i)
        }

        return ans
    }
}

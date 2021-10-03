package com.ypwang.medium

class Solution2024 {
    fun maxConsecutiveAnswers(answerKey: String, k: Int): Int {
        var l1 = 0
        var l2 = 0

        var cnt1 = 0
        var cnt2 = 0

        var rst = 0

        for ((i, c) in answerKey.withIndex()) {
            when (c) {
                'T' -> cnt1++
                'F' -> cnt2++
            }

            while (cnt1 > k) {
                if (answerKey[l1++] == 'T')
                    cnt1--
            }

            while (cnt2 > k) {
                if (answerKey[l2++] == 'F')
                    cnt2--
            }

            rst = maxOf(rst, i+1-l1, i+1-l2)
        }

        return rst
    }
}
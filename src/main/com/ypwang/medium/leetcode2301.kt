package com.ypwang.medium

class Solution2301 {
    fun minimumNumbers(num: Int, k: Int): Int {
        if (num == 0)
            return 0
        if (k == 0)
            return if (num % 10 == 0) 1 else -1

        for (i in 1..10) {
            if (i * k > num)
                break
            if ((num - i * k) % 10 == 0)
                return i
        }

        return -1
    }
}
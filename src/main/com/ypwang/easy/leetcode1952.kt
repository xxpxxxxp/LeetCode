package com.ypwang.easy

class Solution1952 {
    fun isThree(n: Int): Boolean {
        var count = 0
        for (i in 1 until n) {
            if (i * i > n)
                break

            if (n % i == 0) {
                count++
                if (n / i != i)
                    count++
            }

            if (count > 3)
                return false
        }

        return count == 3
    }
}
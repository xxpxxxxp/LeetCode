package com.ypwang.easy

class Solution3954 {
    fun sumOfGoodIntegers(n: Int, k: Int): Int {
        var res = 0

        for (i in maxOf(1, n - k)..n + k)
            if ((n and i) == 0) res += i

        return res
    }
}

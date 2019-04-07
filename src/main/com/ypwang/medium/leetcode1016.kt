package com.ypwang.medium

class Solution1016 {
    fun queryString(S: String, N: Int): Boolean {
        val rst = BooleanArray(N){false}
        var count = N

        for (i in 0 until S.length) {
            if (S[i] == '0')
                continue

            var k = 1
            if (!rst[0]) {
                count--
                if (count == 0)
                    return true
                rst[0] = true
            }
            for (j in i+1 until S.length) {
                k = (k shl 1) + (S[j] - '0')
                if (k > N)
                    break

                if (!rst[k-1]) {
                    count--
                    if (count == 0)
                        return true
                    rst[k-1] = true
                }
            }
        }

        return false
    }
}

fun main() {
    println(Solution1016().queryString("0110", 3))
}
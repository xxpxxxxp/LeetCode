package com.ypwang.hard

class Solution3337 {
    val MOD = 1000000007

    fun lengthAfterTransformations(s: String, t: Int, nums: List<Int>): Int {
        if (t == 0)
            return s.length % MOD

        val freq = LongArray(26)
        for (c in s)
            freq[c - 'a']++

        val mat = Array(26) { LongArray(26) }
        for (c in 0 until 26) {
            val num = nums[c]
            for (i in 1..num)
                mat[c][(c + i) % 26] = 1
        }

        val Mt = matrixPow(mat, t)

        val rowSums = LongArray(26)
        for (c in 0 until 26)
            for (j in 0 until 26)
                rowSums[c] = (rowSums[c] + Mt[c][j]) % MOD


        return freq.zip(rowSums).fold(0L) { r, (a, b) ->
            (r + (a * b)) % MOD
        }.toInt()
    }

    private fun matrixPow(M: Array<LongArray>, power: Int): Array<LongArray> {
        var res = Array(26) { LongArray(26) }
        for (i in 0 until 26)
            res[i][i] = 1

        var base = Array(26) { M[it].clone() }
        var p = power
        while (p > 0) {
            if (p and 1 == 1)
                res = multiply(res, base)

            base = multiply(base, base)
            p /= 2
        }
        return res
    }

    private fun multiply(A: Array<LongArray>, B: Array<LongArray>): Array<LongArray> {
        val C = Array(26) { LongArray(26) }

        for (i in 0 until 26) {
            for (k in 0 until 26) {
                if (A[i][k] == 0L) continue
                for (j in 0 until 26) {
                    C[i][j] = (C[i][j] + A[i][k] * B[k][j]) % MOD
                }
            }
        }
        return C
    }
}

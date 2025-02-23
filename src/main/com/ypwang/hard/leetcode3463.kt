package com.ypwang.hard

class Solution3463 {
    fun hasSameDigits(s: String): Boolean {
        // Step 1: Initialize Variables
        val size = s.length
        val X = size - 2
        var x = 0
        var y = 0

        // Step 2: Compute Alternating Sum Using Binomial Coefficients
        for (j in 0..X) {
            val coeff = binomialMod10(X, j)
            x = (x + coeff * (s[j] - '0')) % 10
            y = (y + coeff * (s[j + 1] - '0')) % 10
        }

        // Step 3: Compare Alternating Sums
        return x == y
    }

    // Step 4: Compute Binomial Coefficient Modulo 10
    private fun binomialMod10(n: Int, k: Int): Int {
        val i = binomialMod2(n, k)
        val j = binomialMod5(n, k)

        for (x in 0 until 10)
            if (x % 2 == i && x % 5 == j)
                return x
        return 0
    }

    // Step 5: Compute Binomial Coefficient Modulo 2
    private fun binomialMod2(n: Int, k: Int): Int {
        return if ((n and k) == k) 1 else 0
    }

    // Step 6: Compute Binomial Coefficient Modulo 5 Using Lookup Table
    private fun binomialMod5(n: Int, k: Int): Int {
        val tuples = arrayOf(
            intArrayOf(1),
            intArrayOf(1, 1),
            intArrayOf(1, 2, 1),
            intArrayOf(1, 3, 3, 1),
            intArrayOf(1, 4, 1, 4, 1)
        )
        var result = 1

        var nTemp = n
        var kTemp = k
        while (nTemp > 0 || kTemp > 0) {
            val nthd = nTemp % 5
            val kthd = kTemp % 5

            if (kthd > nthd) return 0

            result = (result * tuples[nthd][kthd]) % 5
            nTemp /= 5
            kTemp /= 5
        }
        return result
    }
}

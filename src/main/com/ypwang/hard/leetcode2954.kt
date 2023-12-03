package com.ypwang.hard

class Solution2954 {
    private val MOD = 1000000007

    fun numberOfSequence(n: Int, sick: IntArray): Int {
        val segments: MutableList<Int> = ArrayList()
        val startSegmentLen = sick[0]
        val endSegmentLen = n - sick[sick.size - 1] - 1
        // System.out.println("start, end, segments: " + startSegmentLen + "," + endSegmentLen + ",");
        for (i in 1 until sick.size) {
            if (sick[i] - sick[i - 1] - 1 > 0) {
                segments.add(sick[i] - sick[i - 1] - 1)
            }
            // System.out.println(segments.get(segments.size() - 1));
        }
        val fac = prepareFactorial(n)
        val pow2 = preparePow2(n)
        val totalNotSick = n - sick.size
        var ans = fac[totalNotSick]

        // order within segment does not matter outside of segment;
        // opening and closing segments may be unbounded so possible sequence is 1
        ans = multiply(ans, inverse(fac[startSegmentLen]))
        ans = multiply(ans, inverse(fac[endSegmentLen]))
        for (segment in segments) {
            ans = multiply(ans, pow2[segment - 1]) // ordering within segment to get sick
            ans = multiply(ans, inverse(fac[segment])) // order within segment does not matter outside of segment
        }
        return ans
    }

    private fun inverse(n: Int): Int {
        return exp(n, MOD - 2)
    }

    private fun exp(base: Int, exp: Int): Int {
        var base = base
        var exp = exp
        var res = 1
        while (exp > 0) {
            if (exp % 2 == 1) {
                res = multiply(res, base)
            }
            base = multiply(base, base)
            exp /= 2
        }
        return res
    }

    private fun multiply(a: Int, b: Int): Int {
        return (1L * a * b % MOD).toInt()
    }

    private fun preparePow2(n: Int): IntArray {
        val pow2 = IntArray(n + 1)
        pow2[0] = 1
        for (i in 1..n) {
            pow2[i] = multiply(pow2[i - 1], 2)
        }
        return pow2
    }

    private fun prepareFactorial(n: Int): IntArray {
        val fac = IntArray(n + 1)
        fac[0] = 1
        for (i in 1..n) {
            fac[i] = multiply(fac[i - 1], i)
        }
        return fac
    }
}
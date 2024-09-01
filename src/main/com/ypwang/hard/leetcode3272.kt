package com.ypwang.hard

class Solution3272 {
    fun countGoodIntegers(n: Int, k: Int): Long {
        fun multinom(vals: Iterable<Int>): Long {
            var ans = 1L
            var k = 1
            for (x in vals) {
                for (i in 1..x) {
                    ans *= k
                    ans /= i
                    k += 1
                }
            }
            return ans
        }

        val n2 = (n + 1) / 2
        var rst = 0L
        val seen = mutableSetOf<String>()

        for (v in Math.pow(10.0, n2-1.0).toInt() until Math.pow(10.0, n2.toDouble()).toInt()) {
            val vv = "$v${v.toString().reversed().substring(n % 2)}"
            val key = vv.toCharArray().sorted().joinToString("")

            if (vv.toLong() % k == 0L && key !in seen) {
                seen.add(key)
                val count = vv.toCharArray().groupBy { it }.map { it.key to it.value.size }.toMap().toMutableMap()
                rst += multinom(count.values)
                if ('0' in count) {
                    count['0'] = count['0']!! - 1
                    rst -= multinom(count.values)
                }
            }
        }

        return rst
    }
}

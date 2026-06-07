package com.ypwang.hard

class Solution3953 {
    fun maxScore(nums: IntArray, maxVal: Int): Int {
        val LIM = 100000
        val freq = IntArray(LIM + 1)

        for (v in nums)
            freq[v]++

        val spf = IntArray(LIM + 1)
        for (i in 2..LIM) {
            if (spf[i] == 0) {
                spf[i] = i

                if (i.toLong() * i <= LIM) {
                    var j = i * i
                    while (j <= LIM) {
                        if (spf[j] == 0)
                            spf[j] = i

                        j += i
                    }
                }
            }
        }

        val cntDiv = IntArray(LIM + 1)
        for (d in 1..LIM) {
            var m = d
            while (m <= LIM) {
                cntDiv[d] += freq[m]
                m += d
            }
        }

        var res = Int.MIN_VALUE
        val candidate = BooleanArray(LIM + 1)

        for (x in 1..maxVal)
            candidate[x] = true

        for (v in nums)
            candidate[v] = true

        for (x in 1..LIM) {
            if (!candidate[x])
                continue

            var bad = 0

            if (x > 1) {
                val primes = IntArray(6)
                var k = 0
                var t = x

                while (t > 1) {
                    val p = spf[t]
                    primes[k++] = p

                    while (t % p == 0)
                        t /= p
                }

                val maskLimit = 1 shl k
                for (mask in 1 until maskLimit) {
                    var prod = 1
                    var bits = 0

                    for (i in 0 until k) {
                        if ((mask and (1 shl i)) != 0) {
                            prod *= primes[i]
                            bits++
                        }
                    }

                    if ((bits and 1) == 1)
                        bad += cntDiv[prod]
                    else
                        bad -= cntDiv[prod]
                }
            }

            val cost = if (x == 1) {
                if (freq[1] > 0) 0 else 1
            } else {
                if (freq[x] > 0) {
                    bad - 1
                } else {
                    if (bad > 0) bad else 1
                }
            }

            res = maxOf(res, x - cost)
        }

        return res
    }
}

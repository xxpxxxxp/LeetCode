package com.ypwang.hard

class Solution3348 {
    val bases = listOf(
        listOf(), listOf(), listOf(2), listOf(3), listOf(2, 2),
        listOf(5), listOf(2, 3), listOf(7), listOf(2, 2, 2), listOf(3, 3)
    )
    val primes = listOf(2, 3, 5, 7)

    fun smallestNumber(num: String, t: Long): String {
        val count = MutableList(10) { 0 }
        var tempT = t

        for (p in primes) {
            while (tempT % p == 0L) {
                count[p]++
                tempT /= p
            }
        }

        if (tempT != 1L)
            return "-1"

        val res = num.map { it.digitToInt() }.toMutableList()

        fun inc(v: Int, added: Int) {
            for (p in bases[v]) {
                count[p] += added
            }
        }

        fun getn(): Int {
            var n2 = count[2].coerceAtLeast(0)
            var n3 = count[3].coerceAtLeast(0)
            val n5 = count[5].coerceAtLeast(0)
            val n7 = count[7].coerceAtLeast(0)
            var n = n3 / 2 + n5 + n7

            if (n3 % 2 == 1) {
                n++
                n2--
            }
            return n + (n2 + 2) / 3
        }

        var last = res.size
        for ((i, v) in res.withIndex()) {
            if (v == 0) {
                last = i
                break
            }
            inc(v, -1)
        }

        fun fill(start: Int): String {
            for (i in start until res.size) {
                for (j in 1..9) {
                    inc(j, -1)
                    if (getn() <= res.size - 1 - i) {
                        res[i] = j
                        break
                    }
                    inc(j, 1)
                }
            }
            return res.joinToString("") { it.toString() }
        }

        if (getn() <= res.size - last)
            return fill(last)

        for (i in last - 1 downTo 0) {
            inc(res[i], 1)
            for (j in res[i] + 1..9) {
                inc(j, -1)
                if (getn() <= res.size - 1 - i) {
                    res[i] = j
                    return fill(i + 1)
                }
                inc(j, 1)
            }
        }

        res.add(0)
        val nx = getn()
        while (res.size < nx) res.add(0)
        return fill(0)
    }
}

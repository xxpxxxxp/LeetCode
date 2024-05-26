package com.ypwang.hard

class Solution3161 {
    class BIT(private val n: Int) {
        private val l = IntArray(n + 1)

        fun add(i: Int, x: Int) {
            var index = i + 1
            while (index <= n) {
                l[index] = maxOf(x, l[index])
                index += index and -index
            }
        }

        fun query(i: Int): Int {
            var index = i + 1
            var ans = 0
            while (index > 0) {
                ans = maxOf(ans, l[index])
                index -= index and -index
            }
            return ans
        }
    }

    fun getResults(queries: Array<IntArray>): List<Boolean> {
        val sl = sortedSetOf<Int>()
        val n = minOf(50000, queries.size * 3) + 1
        sl.add(0)
        sl.add(n)

        sl.addAll(queries.filter { it[0] == 1 }.map { it[1] })

        val bit = BIT(n + 1)
        sl.zipWithNext { x, y ->
            bit.add(y, y - x)
        }

        val rst = mutableListOf<Boolean>()
        for (q in queries.reversed()) {
            if (q[0] == 1) {
                val x = q[1]
                val index = sl.indexOf(x)
                val after = sl.elementAtOrNull(index + 1) ?: continue
                val before = sl.elementAtOrNull(index - 1) ?: continue
                sl.remove(x)
                bit.add(after, after - before)
            } else {
                val (_, x, sz) = q
                val index = sl.indexOfFirst { it > x }
                val before = sl.elementAtOrNull(index - 1) ?: continue
                rst.add(bit.query(before) >= sz || (x - before) >= sz)
            }
        }

        return rst.reversed()
    }
}

fun main() {
    println(Solution3161().getResults(arrayOf(
        intArrayOf(2,3,1)
    )))
    println(Solution3161().getResults(arrayOf(
        intArrayOf(1,2), intArrayOf(2,3,3), intArrayOf(2,3,1), intArrayOf(2,2,2)
    )))
}

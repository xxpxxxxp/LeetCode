package com.ypwang.medium

class Solution3998 {
    fun transformStr(s: String, strs: Array<String>): BooleanArray {
        val n = s.length
        val p = s.withIndex().filter { it.value == '0' }.map { it.index }
        val zeros = p.size
        val ans = BooleanArray(strs.size)

        for ((x, t) in strs.withIndex()) {
            val c = t.toCharArray()
            var q = 0
            var cz = 0
            for (x in c) {
                if (x == '?') q++
                else if (x == '0') cz++
            }
            if (cz > zeros || cz + q < zeros)
                continue

            var need = zeros - cz
            for (i in 0 until n)
                if (c[i] == '?') {
                    if (need > 0) {
                        c[i] = '0'
                        need--
                    } else
                        c[i] = '1'
                }
            val v = mutableListOf<Int>()
            for (i in 0 until n)
                if (c[i] == '0')
                    v.add(i)
            var ok = true
            for (i in 0 until zeros)
                if (p[i] < v[i])
                    ok = false
            ans[x] = ok
        }
        return ans
    }
}

fun main() {
    println(Solution3998().transformStr("1100", arrayOf("0011","11?1","1?1?")).toList())
}
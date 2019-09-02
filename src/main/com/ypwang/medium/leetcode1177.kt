package com.ypwang.medium

class Solution1177 {
    private fun canBuild(A: IntArray, B: IntArray, len: Int, k: Int): Boolean =
            2 * k >= (0 until 26).sumBy { Math.abs(A[it] - B[it]) % 2 } - (len % 2)

    fun canMakePaliQueries(s: String, queries: Array<IntArray>): BooleanArray {
        val step = Math.sqrt(s.length.toDouble()).toInt()
        val a = IntArray(26)
        val cache = ArrayList<Pair<Int, IntArray>>()
        for (i in s.indices) {
            if (i % step == 0) cache.add(i to a.clone())
            a[s[i] - 'a']++
        }

        val rst = BooleanArray(queries.size)
        for ((i, query) in queries.withIndex()) {
            val (start, end, k) = query
            val sidx = cache.binarySearch { it.first - start }.let { if (it < 0) -it - 2 else it }
            val eidx = cache.binarySearch { it.first - end }.let { if (it < 0) -it - 2 else it }

            rst[i] =
                if (sidx == eidx) {
                    val t = IntArray(26)
                    for (j in start..end) t[s[j] - 'a']++
                    canBuild(IntArray(26), t, eidx-sidx+1, k)
                } else {
                    val si = cache[sidx].first
                    val sa = cache[sidx].second.clone()
                    for (j in si until start) sa[s[j] - 'a']++

                    val ei = cache[eidx].first
                    val ea = cache[eidx].second.clone()
                    for (j in ei..end) ea[s[j] - 'a']++
                    canBuild(sa, ea, end-start+1, k)
                }
        }

        return rst
    }
}

fun main() {
    println(Solution1177().canMakePaliQueries("ofcvmry", arrayOf(
            intArrayOf(0,1,0)
    )).toList())
}
package com.ypwang.hard

class Solution3725 {
    fun countCoprime(mat: Array<IntArray>): Int {
        val MOD = 1000000007
        var cnt = mutableMapOf<Int, Int>()
        for (x in mat[0])
            cnt[x] = cnt.getOrDefault(x, 0) + 1
        for (i in 1 until mat.size) {
            val nxt = mutableMapOf<Int, Int>()
            for (a in mat[i]) {
                for (e in cnt.entries) {
                    val g = gcd(a, e.key)
                    nxt[g] = (nxt.getOrDefault(g, 0) + e.value) % MOD
                }
            }
            cnt = nxt
        }
        return cnt.getOrDefault(1, 0) % MOD
    }

    fun gcd(a: Int, b: Int): Int =
        if (a == 0) b else gcd(b % a, a)
}

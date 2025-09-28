package com.ypwang.hard

class Solution3700 {
    companion object {
        val mod = 1_000_000_007
    }

    // Matrix class with multiplication and exponentiation
    class Matrix(val sz: Int, ident: Boolean = false) {
        val m: Array<IntArray> = Array(sz) { IntArray(sz) }

        init {
            if (ident) {
                for (i in 0 until sz) {
                    m[i][i] = 1
                }
            }
        }

        operator fun times(o: Matrix): Matrix {
            val res = Matrix(sz)
            for (i in 0 until sz) {
                for (k in 0 until sz) {
                    if (m[i][k] == 0) continue
                    val value = m[i][k].toLong()
                    for (j in 0 until sz) {
                        res.m[i][j] = ((res.m[i][j] + value * o.m[k][j]) % mod).toInt()
                    }
                }
            }
            return res
        }
    }

    fun mpow(base: Matrix, exp: Long): Matrix {
        var e = exp
        var b = base
        var res = Matrix(base.sz, true)
        while (e > 0) {
            if ((e and 1L) != 0L) res = res * b
            b = b * b
            e = e shr 1
        }
        return res
    }

    fun zigZagArrays(n: Int, l: Int, r: Int): Int {
        val m = r - l + 1 // number of distinct values
        val S = 2 * m     // total states (value, direction)

        fun id(value: Int, dir: Int): Int =
            (value - l) * 2 + dir

        // Build adjacency matrix
        val A = Matrix(S)
        for (value in l..r) {
            for (dir in 0..1) {
                val u = id(value, dir)
                if (dir == 0) {
                    // last was decreasing => next must be greater
                    for (nxt in (value + 1)..r) {
                        val v = id(nxt, 1)
                        A.m[u][v] = 1
                    }
                } else {
                    // last was increasing => next must be smaller
                    for (nxt in l until value) {
                        val v = id(nxt, 0)
                        A.m[u][v] = 1
                    }
                }
            }
        }

        val V0 = IntArray(S) { 1 }
        if (n == 1) {
            var ans = 0L
            for (x in V0) ans = (ans + x) % mod
            return ans.toInt()
        }

        val An = mpow(A, n - 1L)

        val V = LongArray(S)
        for (j in 0 until S) {
            var sum = 0L
            for (i in 0 until S) {
                sum += 1L * V0[i] * An.m[i][j]
                if (sum >= 8L * mod) sum %= mod
            }
            V[j] = sum % mod
        }

        var ans = 0L
        for (x in V) ans = (ans + x) % mod
        return ans.toInt()
    }
}

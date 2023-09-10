package com.ypwang.hard

class Solution2851 {
    val mod: Long = 1000000007
    fun numberOfWays(s: String, t: String, k: Long): Int {
        var hash = 0L
        var mul = 1L

        for (c in t) {
            mul *= 26
            mul %= mod
            hash *= 26
            hash += c - 'a'
            hash %= mod
        }
        var sHash = 0L
        for (c in s) {
            sHash *= 26
            sHash += c - 'a'
            sHash %= mod
        }
        val index = mutableListOf<Int>()
        var other = 0L
        var other2 = 0L
        val n = s.length
        for ((i, c) in s.withIndex()) {
            if (sHash == hash)
                index.add((n - i) % n)
            sHash *= 26
            sHash += mod
            other = (c - 'a').toLong()
            other2 = other * mul
            other2 %= mod
            sHash -= other2
            sHash += other
        }
        var result = 0L
        val root = arrayOf(longArrayOf(0L, (n - 1).toLong()), longArrayOf(1L, (n - 2).toLong()))
        val pow = powerExp(root, k)
        val a = pow[0][0] * 1
        val b = pow[1][0] * 1
        for (num in index) {
            result += if (num == 0) a else b
            result %= mod
        }
        return result.toInt()
    }

    private fun powerExp(mat: Array<LongArray>, pow: Long): Array<LongArray> {
        var pow = pow
        val map = mutableMapOf<Long, Array<LongArray>>()
        var current = 1L
        var `val` = mat
        var result = Array(mat.size) { LongArray(mat.size) }
        for (i in mat.indices) {
            result[i][i] = 1
        }
        while (current <= pow) {
            map[current] = `val`
            `val` = multiplyMat(`val`, `val`)
            current *= 2
        }
        while (current > 1) {
            current /= 2
            if (pow >= current) {
                pow -= current
                result = multiplyMat(result, map[current]!!)
            }
        }
        return result
    }

    private fun multiplyMat(mat1: Array<LongArray>, mat2: Array<LongArray>): Array<LongArray> {
        val result = Array(mat1.size) { LongArray(mat2[0].size) }
        for (i in mat1.indices) {
            for (j in mat2[0].indices) {
                var sum = 0L
                for (k in mat1.indices) {
                    sum += mat1[i][k] * mat2[k][j]
                    sum %= mod
                }
                sum %= mod
                result[i][j] = sum
            }
        }
        return result
    }
}
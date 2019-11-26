package com.ypwang.hard

class Solution552 {
    fun checkRecord(n: Int): Int {
        val mod = 1000000007
        val p = IntArray(n)
        val l = IntArray(n)
        val a = IntArray(n)
        p[0] = 1
        l[0] = 1
        a[0] = 1

        if (n > 1) {
            l[1] = 3
            a[1] = 2
            if (n > 2) a[2] = 4
        }

        for (i in 1 until n) {
            p[i] = ((a[i-1] + p[i-1]) % mod + l[i-1]) % mod
            if (i > 1) l[i] = (((a[i-1] + p[i-1]) % mod + a[i-2]) % mod + p[i-2]) % mod
            if (i > 2) a[i] = ((a[i-1] + a[i-2]) % mod + a[i-3]) % mod
        }

        return ((p.last() + l.last()) % mod + a.last()) % mod
    }
}
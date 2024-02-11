package com.ypwang.medium

class Solution10036 {
    fun minMovesToCaptureTheQueen(a: Int, b: Int, c: Int, d: Int, e: Int, f: Int): Int {
        if (a == e && !(a == c && d > minOf(b, f) && d < maxOf(b, f))) return 1
        if (b == f && !(b == d && c > minOf(a, e) && c < maxOf(a, e))) return 1
        if (c + d == e + f && !(c + d == a + b && a > minOf(c, e) && a < maxOf(c, e))) return 1
        if (c - d == e - f && !(c - d == a - b && a > minOf(c, e) && a < maxOf(c, e))) return 1
        return 2
    }
}
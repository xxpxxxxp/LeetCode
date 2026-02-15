package com.ypwang.medium

class Solution3844 {
    fun almostPalindromic(s: String): Int {
        val n = s.length
        var res = 0

        for (i in 0 until n) {
            var l = i
            var r = i
            while (l >= 0 && r < n && s[l] == s[r]) {
                res = maxOf(res, r - l + 2)
                l--
                r++
            }
            var sl = l - 1
            var sr = r
            while (sl >= 0 && sr < n && s[sl] == s[sr]) {
                res = maxOf(res, sr - sl + 1)
                sl--
                sr++
            }
            sl = l
            sr = r + 1
            while (sl >= 0 && sr < n && s[sl] == s[sr]) {
                res = maxOf(res, sr - sl + 1)
                sl--
                sr++
            }
        }

        for (i in 0 until n) {
            var l = i
            var r = i + 1
            while (l >= 0 && r < n && s[l] == s[r]) {
                res = maxOf(res, r - l + 2)
                l--
                r++
            }
            var sl = l - 1
            var sr = r
            while (sl >= 0 && sr < n && s[sl] == s[sr]) {
                res = maxOf(res, sr - sl + 1)
                sl--
                sr++
            }
            sl = l
            sr = r + 1
            while (sl >= 0 && sr < n && s[sl] == s[sr]) {
                res = maxOf(res, sr - sl + 1)
                sl--
                sr++
            }
        }
        return minOf(res, n)
    }
}

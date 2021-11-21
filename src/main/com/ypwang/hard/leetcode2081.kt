package com.ypwang.hard

class Solution2081 {
    private fun isPalidrom(s: String): Boolean {
        for (i in 0 until ((s.length+1) / 2))
            if (s[i] != s[s.lastIndex-i])
                return false

        return true
    }

    fun kMirror(k: Int, n: Int): Long {
        var cnt = n
        var rst = 0L

        for (len in 1 until 10) {
            // odd
            for (j in Math.pow(10.0, len.toDouble() - 1).toInt() until Math.pow(10.0, len.toDouble()).toInt()) {
                val s = j.toString()
                val fs = s.substring(0, s.lastIndex) + s.reversed()
                val fd = fs.toLong()
                if (isPalidrom(fd.toString(k))) {
                    rst += fd
                    if (--cnt == 0)
                        return rst
                }
            }

            // even
            for (j in Math.pow(10.0, len.toDouble() - 1).toInt() until Math.pow(10.0, len.toDouble()).toInt()) {
                val s = j.toString()
                val fs = s + s.reversed()
                val fd = fs.toLong()
                if (isPalidrom(fd.toString(k))) {
                    rst += fd
                    if (--cnt == 0)
                        return rst
                }
            }
        }

        return rst
    }
}

fun main() {
    println(Solution2081().kMirror(2,5))
    println(Solution2081().kMirror(3,7))
    println(Solution2081().kMirror(7,17))
}
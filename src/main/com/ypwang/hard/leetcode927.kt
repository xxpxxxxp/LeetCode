package com.ypwang.hard

class Solution927 {
    fun threeEqualParts(A: IntArray): IntArray {
        val count1 = A.count { it == 1 }
        if (count1 == 0) return intArrayOf(0,2)
        if (count1 % 3 != 0) return intArrayOf(-1, -1)

        val tailing = A.takeLastWhile { it == 0 }.size

        val rst = mutableListOf<Int>()
        var i = 0
        for (t in 0..1) {
            var c = count1 / 3
            while (c > 0) {
                if (A[i] == 1) c--
                i++
            }

            var j = tailing
            while (j > 0) {
                if (A[i] == 1) return intArrayOf(-1, -1)
                i++
                j--
            }
            rst.add(i+t-1)
        }

        // back check
        var p = rst[0]
        var q = rst[1] - 1
        var s = A.lastIndex
        while (true) {
            if (p < 0 || q == rst[0] || s < rst[1]) {
                break
            }
            if (A[p] != A[q] || A[q] != A[s]) return intArrayOf(-1, -1)
            p--
            q--
            s--
        }

        return rst.toIntArray()
    }
}

fun main() {
    println(Solution927().threeEqualParts(intArrayOf(0,1,0,1,1,0,0,1,0,1,0,0,0,0,1,0,1,1,1,0)).toList())
    println(Solution927().threeEqualParts(intArrayOf(0,0,0,0,0)).toList())
    println(Solution927().threeEqualParts(intArrayOf(1,0,1,0,1)).toList())
    println(Solution927().threeEqualParts(intArrayOf(1,1,0,1,1)).toList())
}
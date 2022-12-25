package com.ypwang.easy

class Solution2511 {
    fun captureForts(forts: IntArray): Int {
        var rst = 0
        var our = false
        var cnt = 0

        l@ for (v in forts) {
            when (v) {
                1 -> {
                    our = true
                    cnt = 0
                }
                -1 -> {
                    if (our)
                        rst = maxOf(rst, cnt)
                    our = false
                    cnt = 0
                }
                0 -> if (our)
                    cnt++
            }
        }

        our = false
        cnt = 0
        l@ for (v in forts.reversed()) {
            when (v) {
                1 -> {
                    our = true
                    cnt = 0
                }
                -1 -> {
                    if (our)
                        rst = maxOf(rst, cnt)
                    our = false
                    cnt = 0
                }
                0 -> if (our)
                    cnt++
            }
        }

        return rst
    }
}

fun main() {
    println(Solution2511().captureForts(intArrayOf(-1,-1,0,1,0,0,1,-1,1,0)))
    println(Solution2511().captureForts(intArrayOf(1,0,0,-1,0,0,-1,0,0,1)))
    println(Solution2511().captureForts(intArrayOf(1,0,0,-1,0,0,0,0,1)))
    println(Solution2511().captureForts(intArrayOf(0,0,1,-1)))
}
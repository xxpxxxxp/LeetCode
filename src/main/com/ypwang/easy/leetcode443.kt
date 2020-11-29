package com.ypwang.easy

class Solution443 {
    fun compress(chars: CharArray): Int {
        if (chars.size < 2) {
            return chars.size
        }
        var cur = chars[0]
        var ib = 0
        var ie = 1
        var count = 1
        while (ie != chars.size) {
            if (chars[ie] == cur) {
                ie++
                count++
            } else {
                chars[ib] = cur
                ib++
                if (count > 1) {
                    val cstr= count.toString()
                    for (c in cstr) {
                        chars[ib] = c
                        ib++
                    }
                }
                cur = chars[ie]
                count = 1
                ie++
            }
        }

        chars[ib] = cur
        ib++
        if (count > 1) {
            val cstr= count.toString()
            for (c in cstr) {
                chars[ib] = c
                ib++
            }
        }

        return ib
    }
}

fun main() {
    println(Solution443().compress(charArrayOf('a','a','a','b','b','a','a')))
}

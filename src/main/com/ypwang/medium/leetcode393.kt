package com.ypwang.medium

class Solution393 {
    fun validUtf8(data: IntArray): Boolean {
        val iter = data.iterator()

        while (iter.hasNext()) {
            val i = iter.next()
            var begin = 1 shl 7

            var count = 0
            while (i and begin != 0) {
                count++
                begin = begin shr 1
            }

            if (count == 1 || count > 4) return false

            for (j in 0 until count - 1) {
                if (!iter.hasNext()) return false
                val n = iter.next()
                if ((n and (1 shl 7) == 0) || (n and (1 shl 6) != 0)) return false
            }
        }

        return true
    }
}

fun main() {
    println(Solution393().validUtf8(intArrayOf(250,145,145,145,145)))
}
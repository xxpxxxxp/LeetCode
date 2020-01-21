package com.ypwang.hard

class Solution936 {
    private fun indexOf(source: CharArray, target: CharArray, startIdx: Int): Int {
        for (i in startIdx..source.size - target.size) {
            var j = 0
            while (j < target.size) {
                if (source[i + j] != target[j]) break
                j++
            }

            if (j == target.size) return i
        }

        return -1
    }

    fun movesToStamp(stamp: String, target: String): IntArray {
        val rst = mutableListOf<Int>()
        val source = target.toCharArray()
        val pattern = CharArray(stamp.length)
        var total = 0
        var turn = -1
        while (turn != 0) {
            turn = 0
            for (size in stamp.length downTo 1) {
                for (i in 0..stamp.length - size) {
                    pattern.fill('*', 0, i)
                    for (j in i until i + size) pattern[j] = stamp[j]
                    pattern.fill('*', i + size)

                    var pos = indexOf(source, pattern, 0)
                    while (pos != -1) {
                        rst.add(pos)
                        turn += size
                        source.fill('*', pos, pos + stamp.length)
                        pos = indexOf(source, pattern, pos + 1)
                    }
                }
            }
            total += turn
        }

        return if (total == target.length) rst.reversed().toIntArray() else intArrayOf()
    }
}

fun main() {
    println(Solution936().movesToStamp("aye", "eyeye").toList())
    println(Solution936().movesToStamp("abc", "aabccbc").toList())
}
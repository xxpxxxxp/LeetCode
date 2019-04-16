package com.ypwang.medium

class Solution752 {
    fun openLock(deadends: Array<String>, target: String): Int {
        val t = target.toInt()
        val dead = deadends.map { it.toInt() }.toSet()

        if (0 in dead) return -1

        val visited = mutableSetOf<Int>()
        var round = mutableSetOf(0)
        var count = 0
        val r = IntArray(8){0}

        while (round.isNotEmpty()) {
            val next = mutableSetOf<Int>()
            for (i in round) {
                if (i == t) return count

                // thousand
                var tt = i / 1000
                r[0] = i + 1000 * ((tt + 1) % 10 - tt)
                r[1] = i + 1000 * ((tt + 9) % 10 - tt)

                // hundred
                tt = (i / 100) % 10
                r[2] = i + 100 * ((tt + 1) % 10 - tt)
                r[3] = i + 100 * ((tt + 9) % 10 - tt)

                // ten
                tt = (i / 10) % 10
                r[4] = i + 10 * ((tt + 1) % 10 - tt)
                r[5] = i + 10 * ((tt + 9) % 10 - tt)

                // unit
                tt = i % 10
                r[6] = i + ((tt + 1) % 10 - tt)
                r[7] = i + ((tt + 9) % 10 - tt)

                next.addAll(r.filter { i !in dead && i !in visited})
            }

            count++
            visited.addAll(round)
            round = next
        }

        return -1
    }
}

fun main() {
    println(Solution752().openLock(arrayOf("0201","0101","0102","1212","2002"), "0202"))
    println(Solution752().openLock(arrayOf("8888"), "0009"))
    println(Solution752().openLock(arrayOf("8887","8889","8878","8898","8788","8988","7888","9888"), "8888"))
    println(Solution752().openLock(arrayOf("0000"), "8888"))
}
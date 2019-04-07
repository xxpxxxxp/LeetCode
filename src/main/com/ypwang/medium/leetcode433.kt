package com.ypwang.medium

class Solution433 {
    private fun connect(a: String, b: String): Boolean = a.zip(b).count { it.first != it.second } == 1

    fun minMutation(start: String, end: String, bank: Array<String>): Int {
        var level1 = setOf(start)
        var level2 = mutableSetOf<String>()
        val all = bank.toMutableSet()

        var count = 1
        do {
            val remain = all.size
            for (s in level1) {
                val iter = all.iterator()
                while (iter.hasNext()) {
                    val c = iter.next()
                    if (connect(s, c)) {
                        if (c == end)
                            return count

                        iter.remove()
                        level2.add(c)
                    }
                }
            }

            count += 1
            level1 = level2
            level2 = mutableSetOf()
        } while (all.any() && all.size != remain)

        return -1
    }
}

fun main() {
    println(Solution433().minMutation("AAAAACCC", "AACCCCCC", arrayOf("AAAACCCC", "AAACCCCC", "AACCCCCC")))
}
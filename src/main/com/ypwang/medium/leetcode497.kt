package com.ypwang.medium

class Solution497(rects: Array<IntArray>) {
    var rs: List<Pair<Int, IntArray>>
    var sum: Int
    val rand = java.util.Random()

    init {
        var s = 0
        val tmp = mutableListOf<Pair<Int, IntArray>>()
        for (rect in rects) {
            tmp.add(s to rect)
            s += (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1) + 1
        }
        rs = tmp
        sum = s
    }

    fun pick(): IntArray {
        val n = rand.nextInt(sum)
        val i = rs.binarySearch { it.first - n }.let { if (it < 0) -it - 1 - 1 else it }
        val item = rs[i]
        val diff = n - item.first
        val rect = item.second

        val len = rect[2] - rect[0]
        return intArrayOf(diff % len + rect[0], diff / len + rect[1])
    }
}

fun main() {
    val s = Solution497(arrayOf(intArrayOf(82918473, -57180867, 82918476, -57180863), intArrayOf(83793579, 18088559, 83793580, 18088560), intArrayOf(66574245, 26243152, 66574246, 26243153), intArrayOf(72983930, 11921716, 72983934, 11921720)))
    println(s.pick().toList())
    println(s.pick().toList())
    println(s.pick().toList())
    println(s.pick().toList())
    println(s.pick().toList())
    println(s.pick().toList())
    println(s.pick().toList())
    println(s.pick().toList())
    println(s.pick().toList())
    println(s.pick().toList())
    println(s.pick().toList())
    println(s.pick().toList())
    println(s.pick().toList())
    println(s.pick().toList())
    println(s.pick().toList())
    println(s.pick().toList())
    println(s.pick().toList())
    println(s.pick().toList())
    println(s.pick().toList())
    println(s.pick().toList())
    println(s.pick().toList())
    println(s.pick().toList())
    println(s.pick().toList())
    println(s.pick().toList())
}
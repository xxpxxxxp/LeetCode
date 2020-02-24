package com.ypwang.hard

class Solution1363 {
    private fun make(counts: IntArray): String {
        if (counts.all { it == 0 }) return ""
        val t = counts.withIndex().map { iv -> (0 until iv.value).map{ iv.index }.joinToString("") }.reversed().joinToString("").dropWhile { it == '0' }
        return if (t.isEmpty()) "0" else t
    }

    fun largestMultipleOfThree(digits: IntArray): String {
        val counts = IntArray(10)
        digits.forEach { counts[it]++ }

        val sum = digits.sum()

        when (sum % 3) {
            0 -> return make(counts)
            1 -> {
                for (i in listOf(1,4,7)) {
                    if (counts[i] > 0) {
                        counts[i]--
                        return make(counts)
                    }
                }

                var j = 2
                for (i in listOf(2,5,8)) {
                    while (j > 0 && counts[i] > 0) {
                        counts[i]--
                        j--
                        if (j == 0) return make(counts)
                    }
                }
            }
            2 -> {
                for (i in listOf(2,5,8)) {
                    if (counts[i] > 0) {
                        counts[i]--
                        return make(counts)
                    }
                }

                var j = 2
                for (i in listOf(1,4,7)) {
                    while (j > 0 && counts[i] > 0) {
                        counts[i]--
                        j--
                        if (j == 0) return make(counts)
                    }
                }
            }
        }

        return ""
    }
}

fun main() {
    println(Solution1363().largestMultipleOfThree(intArrayOf(9,8,6,8,6)))
    println(Solution1363().largestMultipleOfThree(intArrayOf(8,1,9)))
    println(Solution1363().largestMultipleOfThree(intArrayOf(8,6,7,1,0)))
    println(Solution1363().largestMultipleOfThree(intArrayOf(1)))
    println(Solution1363().largestMultipleOfThree(intArrayOf(0,0,0,0,0,0,0)))
}
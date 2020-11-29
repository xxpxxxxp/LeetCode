package com.ypwang.easy

class Solution893 {
    data class Fuck(val a: String, val b: String)
    fun numSpecialEquivGroups(A: Array<String>): Int {
        return A.map{ Fuck(it.filterIndexed { index, _ -> index % 2 == 0 }.toSortedSet().toString(), it.filterIndexed { index, _ -> index % 2 == 1 }.toSortedSet().toString()).hashCode() }.toSet().count()
    }
}

fun main() {
    println(Solution893().numSpecialEquivGroups(arrayOf("abcd","cdab","adcb","cbad")))
}
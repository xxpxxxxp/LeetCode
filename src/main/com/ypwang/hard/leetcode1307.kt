package com.ypwang.hard

class Solution1307 {
    fun isSolvable(words: Array<String>, result: String): Boolean {
        val pows = intArrayOf(1, 10, 100, 1000, 10000, 100000, 1000000)

        val charSets = words + result
        val candidates = charSets.flatMap { it.toList() }.toSet().toTypedArray()
        val notZeros = charSets.map { it.first() }.toSet()

        val used = BooleanArray(10)

        val count = (words.flatMap {
            it.withIndex().map { (i, c) -> c to pows[it.length-i-1] }
        } + result.withIndex().map { (i, c) -> c to -pows[result.length-i-1] })
                .groupBy { it.first }.mapValues { it.value.sumBy { kv -> kv.second } }

        fun backtrace(idx: Int, diff: Int): Boolean {
            if (idx == candidates.size) return diff == 0
            else {
                for (i in 0..9) {
                    if (used[i] || (i == 0 && candidates[idx] in notZeros)) continue
                    used[i] = true
                    if (backtrace(idx+1, diff + i * count[candidates[idx]]!!)) return true
                    used[i] = false
                }
                return false
            }
        }

        return backtrace(0, 0)
    }
}

fun main() {
    println(Solution1307().isSolvable(arrayOf("THAT","IS","WHY","IT","IS"), "FALSE"))
    println(Solution1307().isSolvable(arrayOf("SEND","MORE"), "MONEY"))
    println(Solution1307().isSolvable(arrayOf("SIX","SEVEN","SEVEN"), "TWENTY"))
    println(Solution1307().isSolvable(arrayOf("THIS","IS","TOO"), "FUNNY"))
    println(Solution1307().isSolvable(arrayOf("LEET","CODE"), "POINT"))
}
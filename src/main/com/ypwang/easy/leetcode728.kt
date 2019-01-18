package com.ypwang.easy

fun isDivid(i: Int): Boolean {
    var j = i
    while (j > 0) {
        val k = j%10
        if (k == 0 || i%k != 0) {
            return false
        }
        j /= 10
    }
    return true
}

class Solution728 {
    fun selfDividingNumbers(left: Int, right: Int): List<Int> {
        val rst = mutableListOf<Int>()
        if (left < 10) {
            rst.addAll(left..9)
        }
        rst.addAll((maxOf(left, 11)..right).filter { isDivid(it) })
        return rst
    }
}

fun main(args: Array<String>) {
    println(Solution728().selfDividingNumbers(47 ,85))
}
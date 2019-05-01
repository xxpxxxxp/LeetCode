package com.ypwang.medium

class Solution738 {
    fun monotoneIncreasingDigits(N: Int): Int {
        val list = mutableListOf<Int>()
        var n = N
        while (n > 0) {
            list.add(n % 10)
            n /= 10
        }
        val array = list.reversed().toIntArray()
        var i = 1
        while (i < array.size && array[i-1] <= array[i]) i++
        while (i > 0 && i < array.size && array[i] < array[i-1]) array[--i]--
        for (j in i+1 until array.size) array[j] = 9
        return array.reduce { acc, y -> acc * 10 + y }
    }
}

fun main() {
    println(Solution738().monotoneIncreasingDigits(322))
}
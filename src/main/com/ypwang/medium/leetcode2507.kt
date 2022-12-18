package com.ypwang.medium

class Solution2507 {
    fun smallestValue(n: Int): Int {
        var sum = 0
        var r = n
        for (i in 2 .. n) {
            if (i > r)
                break
            while (r % i == 0) {
                sum += i
                r /= i
            }
        }
        return if (sum == 0 || sum == n) n else smallestValue(sum)
    }
}

fun main() {
    println(Solution2507().smallestValue(99951))
}
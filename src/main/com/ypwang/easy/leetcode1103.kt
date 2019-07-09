package com.ypwang.easy

class Solution1103 {
    fun distributeCandies(candies: Int, num_people: Int): IntArray {
        var sum = 0
        var round = 0
        var base = 0

        while (candies > sum + (num_people + 1) * num_people / 2 + round * num_people * num_people) {
            sum += (num_people + 1) * num_people / 2 + round * num_people * num_people
            base += round * num_people + 1
            round++
        }

        val rst = IntArray(num_people)
        var rest = candies - sum
        var start = round * num_people + 1
        for (i in 0 until num_people) {
            val r = if (rest > start) start else rest
            rst[i] = base + r + i * round

            rest -= r
            start++
        }

        return rst
    }
}

fun main() {
    println(Solution1103().distributeCandies(10, 3).toList())
}
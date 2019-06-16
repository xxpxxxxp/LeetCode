package com.ypwang.hard

class Solution135 {
    fun candy(ratings: IntArray): Int {
        val cache = IntArray(ratings.size){1}

        for (i in 1 until ratings.size) {
            if (ratings[i] > ratings[i-1])
                cache[i] = cache[i-1]+1
        }

        var sum = cache.last()
        cache[ratings.lastIndex] = 1

        for (i in ratings.lastIndex-1 downTo 0) {
            cache[i] = maxOf(cache[i], if (ratings[i] > ratings[i+1]) cache[i+1]+1 else 1)
            sum += cache[i]
        }

        return sum
    }
}

fun main() {
    println(Solution135().candy(intArrayOf(1,0,2)))
    println(Solution135().candy(intArrayOf(1,2,2)))
    println(Solution135().candy(intArrayOf(2,4,2,8,5,4,7,9,9,3,0,3,7,4,2,0,6,0,5,1)))
}
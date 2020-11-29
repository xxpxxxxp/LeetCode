package com.ypwang.easy

class Solution475 {
    fun findRadius(houses: IntArray, heaters: IntArray): Int {
        heaters.sort()
        return houses.map{
            val index = heaters.binarySearch(it)
            if (index >= 0) {
                return@map 0
            } else {
                val i = -(index + 1)
                if (i >= heaters.size) {
                    return@map it - heaters[i-1]
                }
                if (i - 1 >= 0) {
                    return@map Math.min(it - heaters[i-1], heaters[i] - it)
                }
                return@map heaters[i] - it
            }
        }.max()!!
    }
}

fun main() {
    println(Solution475().findRadius(intArrayOf(1,2,3), intArrayOf(2)))
}
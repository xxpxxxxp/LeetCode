package com.ypwang.medium

class Solution3100 {
    fun maxBottlesDrunk(numBottles: Int, numExchange: Int): Int {
        var k = numExchange
        var sum = numBottles
        var bottle = numBottles
        while (bottle >= k) {
            bottle -= k
            k++
            sum++
            bottle++
        }
        return sum
    }
}

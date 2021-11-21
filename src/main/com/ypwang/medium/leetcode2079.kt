package com.ypwang.medium

class Solution2079 {
    fun wateringPlants(plants: IntArray, capacity: Int): Int {
        var i = 0
        var rst = 0

        while (i < plants.size) {
            rst += 2 * i
            var sum = 0
            var j = i

            while (j < plants.size) {
                if (sum + plants[j] <= capacity) {
                    sum += plants[j++]
                } else
                    break
            }
            i = j
        }

        return rst + plants.size
    }
}

fun main() {
    println(Solution2079().wateringPlants(intArrayOf(2,2,3,3), 5))
    println(Solution2079().wateringPlants(intArrayOf(1,1,1,4,2,3), 4))
    println(Solution2079().wateringPlants(intArrayOf(7,7,7,7,7,7,7), 8))
}
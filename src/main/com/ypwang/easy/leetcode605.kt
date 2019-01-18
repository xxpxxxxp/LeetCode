package com.ypwang.easy

class Solution605 {
    fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
        var count = 0
        for (i in 0 until flowerbed.size) {
            if (flowerbed[i] == 1) {
                continue
            }

            if (i > 0 && flowerbed[i-1] == 1) {
                continue
            }

            if (i < flowerbed.lastIndex && flowerbed[i+1] == 1) {
                continue
            }

            flowerbed[i] = 1
            count++
        }
        return count >= n
    }
}
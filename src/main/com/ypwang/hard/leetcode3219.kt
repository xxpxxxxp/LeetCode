package com.ypwang.hard

class Solution3219 {
    fun minimumCost(m: Int, n: Int, horizontalCut: IntArray, verticalCut: IntArray): Long {
        horizontalCut.sort()
        verticalCut.sort()

        var sumH = horizontalCut.fold(0L) { a, b -> a + b }
        var sumV = verticalCut.fold(0L) { a, b -> a + b }
        var res = 0L

        var i = horizontalCut.lastIndex
        var j = verticalCut.lastIndex
        while (i >= 0 && j >= 0) {
            if (horizontalCut[i] > verticalCut[j]) {
                res += horizontalCut[i] + sumV
                sumH -= horizontalCut[i--]
            } else {
                res += verticalCut[j] + sumH
                sumV -= verticalCut[j--]
            }
        }
        return res + sumH + sumV
    }
}

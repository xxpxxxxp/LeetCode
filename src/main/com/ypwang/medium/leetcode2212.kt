package com.ypwang.medium

class Solution2212 {
    fun maximumBobPoints(numArrows: Int, aliceArrows: IntArray): IntArray {
        fun helper(mask: Int): Triple<Boolean, Int, IntArray> {
            var c = numArrows
            val arr = IntArray(12)
            var score = 0
            for (i in 1 until 12) {
                if (mask and (1 shl i) > 0) {
                    if (c <= aliceArrows[i])
                        return Triple(false, 0, arr)

                    score += i
                    arr[i] = aliceArrows[i] + 1
                    c -= arr[i]
                }
            }

            arr[0] = numArrows - arr.sum()
            return Triple(true, score, arr)
        }

        var s = Int.MIN_VALUE
        var rst = intArrayOf()
        for (i in 0 until (1 shl 12)) {
            val (possible, score, arr) = helper(i)
            if (possible && score > s) {
                s = score
                rst = arr
            }
        }

        return rst
    }
}
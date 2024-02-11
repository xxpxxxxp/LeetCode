package com.ypwang.easy

class Solution10035 {
    fun areaOfMaxDiagonal(dimensions: Array<IntArray>): Int =
        dimensions.fold(0 to 0) { (dia, area), (h, w) ->
            val d = h * h + w * w
            if (dia < d || (dia == d && area < h * w))
                d to h * w
            else
                dia to area
        }.second
}
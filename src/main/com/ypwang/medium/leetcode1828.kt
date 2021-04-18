package com.ypwang.medium

class Solution1828 {
    fun countPoints(points: Array<IntArray>, queries: Array<IntArray>): IntArray =
        queries.map { (x, y, r) ->
            points.count { (a, b) -> (x-a) * (x-a) + (y-b) * (y-b) <= r * r }
        }.toIntArray()
}
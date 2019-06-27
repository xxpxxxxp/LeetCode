package com.ypwang.hard

class Solution780 {
    fun reachingPoints(sx: Int, sy: Int, tx: Int, ty: Int): Boolean {
        var x = tx
        var y = ty
        while (x > sx && y > sy) {
            if (x > y) x %= y
            else y %= x
        }

        return (x == sx && y >= sy && (y - sy) % x == 0) || (y == sy && x >= sx && (x - sx) % y == 0)
    }
}

fun main() {
    println(Solution780().reachingPoints(3, 3, 12, 9))
}
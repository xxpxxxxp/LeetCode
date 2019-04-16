package com.ypwang.medium

class Solution365 {
    private fun gcd(x: Int, y: Int): Int {
        assert(x <= y)
        return if (y % x == 0) x
        else gcd(y % x, x)
    }

    fun canMeasureWater(x: Int, y: Int, z: Int): Boolean {
        if (z == x || z == y) return true
        if (z > x + y) return false
        return (x != 0 && z % x == 0) || (y != 0 && z % y == 0) || (x != 0 && y != 0 && z % gcd(minOf(x, y), maxOf(x, y)) == 0)
    }
}
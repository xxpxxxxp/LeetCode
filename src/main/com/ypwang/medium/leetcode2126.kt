package com.ypwang.medium

class Solution2126 {
    fun asteroidsDestroyed(mass: Int, asteroids: IntArray): Boolean {
        asteroids.sort()
        var m = mass.toLong()

        for (a in asteroids) {
            if (a > m)
                return false

            m += a
        }

        return true
    }
}
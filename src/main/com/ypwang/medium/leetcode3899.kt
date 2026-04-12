package com.ypwang.medium

class Solution3899 {
    fun internalAngles(sides: IntArray): DoubleArray {
        val (a, b, c) = sides
        if (a >= c + b || c >= a + b || b >= a + c)
            return doubleArrayOf()

        val angles = DoubleArray(3)
        angles[0] = Math.toDegrees(Math.acos(((b * b) + (c * c) - (a * a)) / (2.0 * b * c)))
        angles[1] = Math.toDegrees(Math.acos(((a * a) + (c * c) - (b * b)) / (2.0 * a * c)))
        angles[2] = 180 - angles[0] - angles[1]
        angles.sort()
        return angles
    }
}

package com.ypwang.easy

class Solution3200 {
    private fun helper(a: Int, b: Int): Int {
        var a = a
        var b = b
        var i = 0
        while (true) {
            if (a < i+1)
                break

            i++
            a -= i

            if (b < i+1)
                break

            i++
            b -= i
        }

        return i
    }

    fun maxHeightOfTriangle(red: Int, blue: Int): Int =
        maxOf(helper(red, blue), helper(blue, red))
}

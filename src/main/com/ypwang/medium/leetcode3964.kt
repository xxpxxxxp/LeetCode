package com.ypwang.medium

class Solution3964 {
    fun minLights(lights: IntArray): Int {
        val n = lights.size
        val temp = IntArray(lights.size + 1)
        for (i in lights.indices) {
            if (lights[i] >= 1) {
                temp[maxOf(0, i - lights[i])]++
                temp[minOf(n - 1, i + lights[i]) + 1]--
            }
        }
        for (i in 1 until lights.size)
            temp[i] += temp[i - 1]

        var cnt = 0
        temp[lights.size] = 1
        var i = 0
        var j = 0
        while (j < lights.size + 1) {
            if (temp[j] > 0) {
                cnt += (j - i + 2) / 3
                i = ++j
                continue
            }
            j++
        }
        return cnt
    }
}

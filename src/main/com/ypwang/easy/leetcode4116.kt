package com.ypwang.easy

class Solution4116 {
    fun assignUmbrella(rain: IntArray): Array<String> {
        val n = rain.size
        val answer = Array(n) { "" }
        var alicecount = 0
        var bobcount = 0

        for (i in 0 until n) {
            val aliceneeds = (i < n - 1 && rain[i] == 1 && rain[i + 1] == 1)
            val bobneeds = (rain[i] == 1)

            if (aliceneeds && bobneeds) {
                if (alicecount <= bobcount) {
                    answer[i] = "Alice"
                    alicecount++
                } else {
                    answer[i] = "Bob"
                    bobcount++
                }
            } else if (bobneeds) {
                answer[i] = "Bob"
                bobcount++
            } else {
                answer[i] = "None"
            }
        }

        return answer
    }
}

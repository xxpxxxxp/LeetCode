package com.ypwang.hard

class Solution3398 {
    fun minLength(s: String, numOps: Int): Int {
        val n = s.length
        if (n == 1)
            return 1

        val runs = getRuns(s)

        var maxRun = runs.max()

        if (numOps == 0)
            return maxRun

        var low = 1
        var high = maxRun

        while (low < high) {
            val mid = (low + high) / 2
            var cost =
                if (mid == 1) {
                    var cnt = 0
                    for (i in 0 until n) {
                        if (i % 2 == 0) {
                            if (s[i] == '1') cnt++
                        } else if (s[i] == '0') cnt++
                    }

                    var cnt1 = 0
                    for (i in 0 until n) {
                        if (i % 2 == 1) {
                            if (s[i] == '1') cnt1++
                        } else
                            if (s[i] == '0') cnt1++
                    }
                    minOf(cnt1, cnt)
                } else
                    runs.sumOf { it / (mid + 1) }

            if (cost <= numOps)
                high = mid
            else
                low = mid + 1
        }

        return low
    }

    private fun getRuns(s: String): List<Int> {
        val list = mutableListOf<Int>()
        val n = s.length

        var count = 1
        for (i in 1 until n) {
            if (s[i] == s[i - 1])
                count++
            else {
                list.add(count)
                count = 1
            }
        }
        list.add(count)

        return list
    }
}

fun main() {
    println(Solution3398().minLength("0100", 1))
}
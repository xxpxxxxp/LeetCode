package com.ypwang.hard

class Solution466 {
    fun getMaxRepetitions(s1: String, n1: Int, s2: String, n2: Int): Int {
        if (n1 == 0) return 0
        val indexr = IntArray(s2.length+1)
        val countr = IntArray(s2.length+1)

        var index = 0
        var count = 0
        for (i in 1..n1) {
            for (j in s1.indices) {
                if (s1[j] == s2[index]) ++index
                if (index == s2.length) {
                    index = 0
                    ++count
                }
            }

            countr[i] = count
            indexr[i] = index
            for (k in 0 until i) {
                if (indexr[k] == index)
                    return (countr[k + (n1-k) % (i-k)] + (countr[i]-countr[k]) * ((n1-k) / (i-k))) / n2
            }
        }
        return countr[n1] / n2;
    }
}

fun main() {
    println(Solution466().getMaxRepetitions("ecbafedcba", 3, "abcdef", 1))
}
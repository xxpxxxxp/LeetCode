package com.ypwang.hard

class Solution1092 {
    fun shortestCommonSupersequence(str1: String, str2: String): String {
        val cache = Array<Pair<Int, Int>?>((str1.length+1) * (str2.length+1)){ null }

        for (i in 1..str1.length) {
            val id = i * (str2.length+1)
            cache[id] = id to 0
        }

        for (i in 0..str2.length) {
            cache[i] = i to 0
        }

        for (j in 0 until str2.length) {
            for (i in 0 until str1.length) {
                val id = (i + 1) * (str2.length+1) + j + 1
                if (str2[j] == str1[i]) {
                    val pre = i * (str2.length+1) + j
                    cache[id] = pre to (cache[pre]!!.second+1)
                } else {
                    val up = i * (str2.length+1) + j + 1
                    val left = (i+1) * (str2.length+1) + j

                    cache[id] =
                            if (cache[up]!!.second > cache[left]!!.second) up to cache[up]!!.second
                            else left to cache[left]!!.second
                }
            }
        }

        val common = StringBuilder()

        var i = str1.length
        var j = str2.length

        while (i > 0 && j > 0) {
            if (str1[i-1] == str2[j-1])
                common.append(str1[i-1])

            val start = cache[i * (str2.length+1) + j]!!.first
            i = start / (str2.length+1)
            j = start % (str2.length+1)
        }

        i = 0
        j = 0
        val sb = StringBuilder()

        for (c in common.toString().reversed()) {
            while (str1[i] != c) {
                sb.append(str1[i++])
            }

            while (str2[j] != c) {
                sb.append(str2[j++])
            }

            sb.append(c)

            i++
            j++
        }

        sb.append(str1.substring(i))
        sb.append(str2.substring(j))
        return sb.toString()
    }
}

fun main() {
    println(Solution1092().shortestCommonSupersequence("baaacbcbc","bacbcaca"))
}
package com.ypwang.medium

class Solution948 {
    fun bagOfTokensScore(tokens: IntArray, P: Int): Int {
        tokens.sort()
        var bank = P
        var i = 0
        var j = tokens.lastIndex
        var counter = 0
        var max = 0
        while (i <= j) {
            if (bank >= tokens[i]) {
                bank -= tokens[i]
                counter++
                i++

                if (counter > max)
                    max = counter
            } else if (counter > 0) {
                bank += tokens[j]
                counter--
                j--
            } else {
                break
            }
        }

        return max
    }
}

fun main() {
    println(Solution948().bagOfTokensScore(intArrayOf(71,55,82), 54))
}
package com.ypwang.hard

import java.util.LinkedList

class Solution761 {
    fun makeLargestSpecial(S: String): String {
        var balance = 0
        var l = 0
        val subResults = LinkedList<String>()
        for (r in 0 until S.length) {
            if (S[r] == '0') {
                balance--
            } else {
                balance++
            }
            if (balance == 0) {
                subResults.add("1" + makeLargestSpecial(S.substring(l + 1, r)) + "0")
                l = r + 1
            }
        }
        subResults.sortDescending()

        return subResults.joinToString("")
    }
}

fun main(args: Array<String>) {
    println(Solution761().makeLargestSpecial("1101001100"))
}

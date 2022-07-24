package com.ypwang.easy

class Solution2347 {
    fun bestHand(ranks: IntArray, suits: CharArray): String {
        if (suits.toSet().size == 1)
            return "Flush"

        return when (ranks.groupBy { it }.map { it.value.size }.maxOrNull()!!) {
            5, 4, 3 ->
                "Three of a Kind"
            2 ->
                "Pair"
            else ->
                "High Card"
        }
    }
}
package com.ypwang.medium

class Solution464 {
    fun canIWin(maxChoosableInteger: Int, desiredTotal: Int): Boolean {
        if (desiredTotal == 0) return true

        val initial = (1 shl maxChoosableInteger) - 1
        val cache = mutableMapOf<Int, Boolean>()
        // turn = true: first player; false: second player
        fun helper(chooses: Int, sum: Int, turn: Boolean): Boolean {
            val idx = (chooses shl 10) + sum + (if (turn) 1 shl 30 else 0)
            if (idx !in cache) {
                if (sum >= desiredTotal) cache[idx] = !turn
                else {
                    // what else choices we have
                    val c = (1..maxChoosableInteger).filter { chooses and (1 shl (it - 1)) != 0 }

                    /* if first player playing, we could win in current situation if and only if:
                        there's a number in choices, if we play this number, we will win following situations

                       if second player playing, the first player could win in current situation if and only if:
                        whatever number in choices the second player played, the first player always win in following situations
                     */
                    cache[idx] = when {
                        c.isEmpty() -> false    // no number to play with, actually a tie, certainly first player cannot `force a win`
                        turn -> c.any { helper(chooses xor (1 shl (it - 1)), sum + it, !turn) }
                        else -> c.all { helper(chooses xor (1 shl (it - 1)), sum + it, !turn) }
                    }
                }
            }

            return cache[idx]!!
        }

        return helper(initial, 0, true)
    }
}

fun main() {
    println(Solution464().canIWin(18, 79))
}
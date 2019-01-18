package com.ypwang.medium

class Solution638 {
    fun shoppingOffers(price: List<Int>, special: List<List<Int>>, needs: List<Int>): Int {
        val mem = mutableMapOf(List(needs.size){0} to 0)

        fun helper(n: List<Int>): Int {
            if (needs in mem) {
                return mem[needs]!!
            }

            val rst = mutableListOf(n.zip(price).sumBy { it.first * it.second })
            for (offer in special) {
                val p = offer.last()
                val next = n.zip(offer.dropLast(1))
                if (next.all { it.first >= it.second }) {
                    rst.add(p + helper(next.map { it.first - it.second }))
                }
            }

            mem[n] = rst.min()!!
            return mem[n]!!
        }

        return helper(needs)
    }
}
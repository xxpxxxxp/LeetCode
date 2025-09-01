package com.ypwang.medium

class Solution3664 {
    private fun getPairs(total: Int, largestGroup: Int): Int {
        if (total <= 1)
            return 0
        return minOf(total / 2, total - largestGroup)
    }

    fun score(cards: Array<String>, x: Char): Int {
        val leftGroup = mutableMapOf<Char, Int>()
        val rightGroup = mutableMapOf<Char, Int>()
        var doubleX = 0
        val target = "$x$x"

        for (c in cards) {
            if (!c.contains(x)) continue
            if (c == target) {
                doubleX++
            } else if (c[0] == x) {
                leftGroup[c[1]] = leftGroup.getOrDefault(c[1], 0) + 1
            } else {
                rightGroup[c[0]] = rightGroup.getOrDefault(c[0], 0) + 1
            }
        }

        var leftTotal = 0
        var leftMax = 0
        for ((_, v) in leftGroup) {
            leftTotal += v
            leftMax = maxOf(leftMax, v)
        }

        var rightTotal = 0
        var rightMax = 0
        for ((_, v) in rightGroup) {
            rightTotal += v
            rightMax = maxOf(rightMax, v)
        }

        var best = 0
        for (i in 0..doubleX) {
            val total1 = leftTotal + i
            val max1 = maxOf(leftMax, i)
            val score1 = getPairs(total1, max1)

            val total2 = rightTotal + (doubleX - i)
            val max2 = maxOf(rightMax, doubleX - i)
            val score2 = getPairs(total2, max2)

            best = maxOf(best, score1 + score2)
        }
        return best
    }
}

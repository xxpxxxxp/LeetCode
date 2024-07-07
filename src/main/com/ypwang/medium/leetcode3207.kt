package com.ypwang.medium

class Solution3207 {
    fun maximumPoints(enemyEnergies: IntArray, currentEnergy: Int): Long {
        enemyEnergies.sortDescending()
        if (currentEnergy < enemyEnergies.last())
            return 0L
        return (enemyEnergies.fold(0L) { a, b -> a + b } - enemyEnergies.last() + currentEnergy) / enemyEnergies.last()
    }
}

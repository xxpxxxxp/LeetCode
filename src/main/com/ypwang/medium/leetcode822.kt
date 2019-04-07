package com.ypwang.medium

class Solution822 {
    fun flipgame(fronts: IntArray, backs: IntArray): Int {
        val t = fronts.zip(backs).filter { it.first == it.second }.map { it.first }.toSet()
        return (fronts + backs).filter { it !in t }.min() ?: 0
    }
}
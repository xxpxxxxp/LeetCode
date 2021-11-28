package com.ypwang.medium

class Solution2087 {
    fun minCost(startPos: IntArray, homePos: IntArray, rowCosts: IntArray, colCosts: IntArray): Int =
        (minOf(startPos[0], homePos[0])..maxOf(startPos[0], homePos[0])).map { rowCosts[it] }.sum() +
                (minOf(startPos[1], homePos[1])..maxOf(startPos[1], homePos[1])).map { colCosts[it] }.sum() -
                rowCosts[startPos[0]] -
                colCosts[startPos[1]]
}
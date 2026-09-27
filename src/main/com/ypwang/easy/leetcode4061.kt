package com.ypwang.easy

class Solution4061 {
    fun minQueenMoves(source: IntArray, target: IntArray): Int =
        if (source.contentEquals(target)) 0
        else if (Math.abs(source[0] - target[0]) == Math.abs(source[1] - target[1]) || source[0] == target[0] || source[1] == target[1]) 1
        else 2
}

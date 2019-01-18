package com.ypwang.medium

class Solution789 {
    fun escapeGhosts(ghosts: Array<IntArray>, target: IntArray): Boolean {
        val dis = Math.abs(target[0]) + Math.abs(target[1])
        return ghosts.all { Math.abs(it[0] - target[0]) + Math.abs(it[1] - target[1]) > dis }
    }
}
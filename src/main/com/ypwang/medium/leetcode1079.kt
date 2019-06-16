package com.ypwang.medium

class Solution1079 {
    fun numTilePossibilities(tiles: String): Int {
        val count = IntArray(26)
        for (c in tiles.toCharArray()) count[c - 'A']++
        return dfs(count)
    }

    private fun dfs(arr: IntArray): Int {
        var sum = 0
        for (i in 0..25) {
            if (arr[i] == 0) continue
            sum++
            arr[i]--
            sum += dfs(arr)
            arr[i]++
        }
        return sum
    }
}
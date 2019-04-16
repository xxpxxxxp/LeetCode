package com.ypwang.medium

class Solution1024 {
    fun videoStitching(clips: Array<IntArray>, T: Int): Int {
        clips.sortBy { it[0] }
        
        var start = 0
        var index = 0
        var count = 0
        
        while (start < T) {
            count++
            var end = start
            while (index < clips.size) {
                if (clips[index][0] <= start) {
                    if (clips[index][1] > end) {
                        end = clips[index][1]
                        if (end >= T)
                            return count
                    }
                    index++
                } else {
                    break
                }
            }

            if (end <= start)
                return -1

            start = end
        }
        
        return count
    }
}

fun main() {
    println(Solution1024().videoStitching(arrayOf(intArrayOf(0,2),intArrayOf(4,6),intArrayOf(8,10),intArrayOf(1,9),intArrayOf(1,5),intArrayOf(5,9)), 10))
}
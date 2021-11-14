package com.ypwang.hard

class Solution2071 {
    fun maxTaskAssign(tasks: IntArray, workers: IntArray, pills: Int, strength: Int): Int {
        tasks.sort()
        workers.sort()

        fun check(n: Int): Boolean {
            var p = pills
            val ws = workers.takeLast(n).toMutableList()
            for (i in n-1 downTo 0) {
                val p1 = ws.binarySearch(tasks[i]).let { if (it < 0) -it-1 else it }
                if (p1 < ws.size)
                    ws.removeAt(p1)
                else if (p > 0) {
                    val p2 = ws.binarySearch(tasks[i] - strength).let { if (it < 0) -it-1 else it }
                    if (p2 == ws.size)
                        return false

                    ws.removeAt(p2)
                    p--
                } else
                    return false
            }

            return true
        }

        var left = 0
        var right = minOf(tasks.size, workers.size)

        while (left < right) {
            val mid = (left + right + 1) / 2
            if (check(mid))
                left = mid
            else
                right = mid - 1
        }

        return left
    }
}

fun main() {
    println(Solution2071().maxTaskAssign(
        intArrayOf(10,15,30),
        intArrayOf(0,10,10,10,10),
        3,
        10
    ))

    println(Solution2071().maxTaskAssign(
        intArrayOf(5,9,8,5,9),
        intArrayOf(1,6,4,2,6),
        1,
        5
    ))
}
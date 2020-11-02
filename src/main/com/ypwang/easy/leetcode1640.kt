package com.ypwang.easy

class Solution1640 {
    fun canFormArray(arr: IntArray, pieces: Array<IntArray>): Boolean {
        val ps = pieces.toMutableList()

        var i = 0
        while (i < arr.size) {
            var found = false

            for ((j, a) in ps.withIndex()) {
                if (a.isNotEmpty() && a[0] == arr[i]) {
                    found = true
                    for (v in a) {
                        if (v != arr[i++])
                            return false
                    }

                    ps.removeAt(j)
                    break
                }
            }

            if (!found)
                return false
        }

        return true
    }
}
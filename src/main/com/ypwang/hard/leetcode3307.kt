package com.ypwang.hard

class Solution3307 {
    fun kthCharacter(k: Long, operations: IntArray): Char {
        var i = Math.ceil(Math.log(k.toDouble()) / Math.log(2.0)).toInt() - 1
        var count = 0

        var k = k
        while (k > 1) {
            if (k > (1L shl i)) {
                if (operations[i] == 1)
                    count++
                k -= 1L shl i
            }
            i--
        }
        return 'a' + (count % 26)
    }
}

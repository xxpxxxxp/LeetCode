package com.ypwang.medium

class Solution3703 {
    fun removeSubstring(s: String, k: Int): String {
        val sb = StringBuilder()
        var count = 0
        for (ch in s) {
            sb.append(ch)
            if (ch == '(')
                count++
            else {
                if (count >= k && sb.length >= 2 * k) {
                    val len = sb.length
                    var b = true
                    for (i in len - 2 * k..<len - k) {
                        if (sb.get(i) != '(') {
                            b = false
                            break
                        }
                    }
                    for (i in len - k..<len) {
                        if (sb.get(i) != ')') {
                            b = false
                            break
                        }
                    }
                    if (b) {
                        sb.delete(sb.length - 2 * k, sb.length)
                        count -= k
                    }
                }
            }
        }
        return sb.toString()
    }
}

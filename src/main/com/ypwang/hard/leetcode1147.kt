package com.ypwang.hard

class Solution1147 {
    fun longestDecomposition(text: String): Int {
        var f = ""
        var b = ""

        var i = 0
        var j = text.lastIndex

        var rst = 0
        for (t in 0 until text.length/2) {
            f += text[i]
            b = text[j] + b

            if (f == b) {
                rst += 2
                f = ""
                b = ""
            }

            i++
            j--
        }

        if(text.length%2 != 0 || f != "") rst += 1
        return rst
    }
}

fun main() {
    println(Solution1147().longestDecomposition("ghiabcdefhelloadamhelloabcdefghi"))
    println(Solution1147().longestDecomposition("merchant"))
    println(Solution1147().longestDecomposition("antaprezatepzapreanta"))
    println(Solution1147().longestDecomposition("aaa"))
}
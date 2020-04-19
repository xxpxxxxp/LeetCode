package com.ypwang.medium

class Solution1410 {
    fun entityParser(text: String): String {
        var idx = 0
        val sb = StringBuilder()
        while (idx < text.length) {
            if (text[idx] == '&') {
                val end = (minOf(idx+3, text.lastIndex)..minOf(idx+6, text.lastIndex)).firstOrNull{ text[it] == ';' }?.plus(1) ?: idx
                when (text.substring(idx, end)) {
                    "&quot;" -> {
                        sb.append("\"")
                        idx = end
                    }
                    "&apos;" -> {
                        sb.append("'")
                        idx = end
                    }
                    "&amp;" -> {
                        sb.append("&")
                        idx = end
                    }
                    "&gt;" -> {
                        sb.append(">")
                        idx = end
                    }
                    "&lt;" -> {
                        sb.append("<")
                        idx = end
                    }
                    "&frasl;" -> {
                        sb.append("/")
                        idx = end
                    }
                    else -> sb.append(text[idx++])
                }
            } else sb.append(text[idx++])
        }

        return sb.toString()
    }
}

fun main() {
    println(Solution1410().entityParser("&amp; is an HTML entity but &ambassador; is not.&amp;"))
    println(Solution1410().entityParser("&amp; is an HTML entity but &ambassador; is not."))
    println(Solution1410().entityParser("and I quote: &quot;...&quot;"))
    println(Solution1410().entityParser("Stay home! Practice on Leetcode :)"))
    println(Solution1410().entityParser("x &gt; y &amp;&amp; x &lt; y is always false"))
    println(Solution1410().entityParser("leetcode.com&frasl;problemset&frasl;all"))
}
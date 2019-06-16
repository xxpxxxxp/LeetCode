package com.ypwang.easy

class Solution1078 {
    fun findOcurrences(text: String, first: String, second: String): Array<String> {
        val patten = "$first $second "

        var idx = 0
        val rst = mutableListOf<String>()

        while (true) {
            val pos = text.indexOf(patten, idx)
            if (pos != -1 && pos + patten.length != text.length) {
                val end = text.indexOf(' ', pos + patten.length).let { if (it == -1) text.length else it }
                rst.add(text.substring(pos + patten.length, end))
                idx = pos + patten.length
            } else {
                break
            }
        }

        return rst.toTypedArray()
    }
}

fun main() {
    println(Solution1078().findOcurrences("a hyvncrmcw suhpiuso hyvncrmcw suhpiuso stq duvw stq duvw hyvncrmcw stq suhpiuso hyvncrmcw duvw hyvncrmcw hyvncrmcw hyvncrmcw hyvncrmcw hyvncrmcw hyvncrmcw hyvncrmcw duvw a suhpiuso hyvncrmcw suhpiuso hyvncrmcw suhpiuso duvw suhpiuso a hyvncrmcw stq suhpiuso suhpiuso a a suhpiuso hyvncrmcw a suhpiuso duvw a hyvncrmcw duvw a hyvncrmcw a stq a"
            ,"a",
            "stq").toList())
}
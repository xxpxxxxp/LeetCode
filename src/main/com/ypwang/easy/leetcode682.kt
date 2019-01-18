package com.ypwang.easy

class Solution682 {
    fun calPoints(ops: Array<String>): Int {
        val last = mutableListOf<Int>()
        var sum = 0
        ops.forEach {
            when (it) {
                "+" -> {
                    val tmp = last.takeLast(2).sum()
                    last.add(tmp)
                    sum += tmp
                }
                "D" -> {
                    val tmp = last.last() * 2
                    last.add(tmp)
                    sum += tmp
                }
                "C" -> {
                    sum -= last.last()
                    last.removeAt(last.lastIndex)
                }
                else -> {
                    val tmp = it.toInt()
                    last.add(tmp)
                    sum += tmp
                }
            }
        }
        return sum
    }
}

fun main(args: Array<String>) {
    println(Solution682().calPoints(arrayOf("5","-2","4","C","D","9","+","+")))
}
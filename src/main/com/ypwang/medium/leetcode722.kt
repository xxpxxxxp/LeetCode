package com.ypwang.medium

import java.lang.StringBuilder

class Solution722 {
    fun removeComments(source: Array<String>): List<String> {
        val str = source.joinToString("\n").iterator()
        val rst = StringBuilder()

        while (str.hasNext()) {
            val c = str.next()
            if (c == '/') {
                if (str.hasNext()) {
                    val n = str.next()
                    when (n) {
                        '*' -> {
                            val window = mutableListOf('0', '0')
                            while (true) {
                                window.removeAt(0)
                                window.add(str.next())
                                if (window == listOf('*', '/'))
                                    break
                            }
                        }
                        '/' -> {
                            // remove until '\n'
                            while (str.hasNext()) {
                                if (str.next() == '\n') {
                                    rst.append('\n')
                                    break
                                }
                            }
                        }
                        else -> {
                            rst.append('/')
                            rst.append(n)
                        }
                    }
                }
            } else rst.append(c)
        }

        return rst.split('\n').filter { it.isNotEmpty() }
    }
}

fun main() {
    println(Solution722().removeComments(arrayOf("void func(int k) {", "// this function does nothing /*", " k = k*2/4;", " k = k/2;*/", "}")))
}
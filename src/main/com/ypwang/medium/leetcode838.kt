package com.ypwang.medium

class Solution838 {
    fun pushDominoes(dominoes: String): String {
        var lr = dominoes.toList()
        val rst = dominoes.toMutableList()
        var changed = true
        while (changed) {
            changed = false
            for (i in 0 until lr.size) {
                if (lr[i] == '.') {
                    var case = 0
                    if (i > 0 && lr[i-1] == 'R') {
                        case--
                    }
                    if (i < lr.lastIndex && lr[i+1] == 'L') {
                        case++
                    }
                    when (case) {
                        1-> {
                            rst[i] = 'L'
                            changed = true
                        }
                        -1 -> {
                            rst[i] = 'R'
                            changed = true
                        }
                        else -> {}
                    }
                } else {
                    rst[i] = lr[i]
                }
            }
            lr = rst.toList()
        }
        return rst.joinToString("")
    }
}

fun main() {
    println(Solution838().pushDominoes("R.......L.R........."))
}
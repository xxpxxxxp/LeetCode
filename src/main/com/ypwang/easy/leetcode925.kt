package com.ypwang.easy

class Solution925 {
    fun isLongPressedName(name: String, typed: String): Boolean {
        if (name.isEmpty()) {
            return typed.isEmpty()
        }
        var i = 0
        var j = 0
        var counti = 1
        var countj = 1
        while (true) {
            if (name[i] != typed[j]) {
                return false
            }

            while (i+1 < name.length && name[i+1] == name[i]) {
                i++
                counti++
            }

            while (j+1 < typed.length && typed[j+1] == typed[j]) {
                j++
                countj++
            }

            if (counti > countj) {
                return false
            }

            if (i+1 == name.length || j+1 == typed.length) {
                break
            }
            i++
            counti = 1
            j++
            countj = 1
        }
        if (i != name.lastIndex || j != typed.lastIndex) {
            return false
        }
        return true
    }
}

fun main() {
    println(Solution925().isLongPressedName("alex", "aaleex"))
}
package com.ypwang.medium

class Solution3941 {
    fun passwordStrength(password: String): Int =
        password.toSet().map {
            when (it) {
                in 'a'..'z' -> 1
                in 'A'..'Z' -> 2
                in '0'..'9' -> 3
                in setOf('!', '@', '#', '$') -> 5
                else -> 0
            }
        }.sum()
}

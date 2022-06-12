package com.ypwang.easy

class Solution2299 {
    fun strongPasswordCheckerII(password: String): Boolean =
        password.length >= 8 &&
        password.any { it.isLowerCase() } &&
        password.any { it.isUpperCase() } &&
        password.any { it.isDigit() } &&
        password.any { it in "!@#$%^&*()-+" } &&
        (1 until password.length).all { password[it-1] != password[it] }
}